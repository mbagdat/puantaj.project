package com.puantaj.project.controller;


import com.puantaj.project.models.*;
import com.puantaj.project.payload.request.LoginRequest;
import com.puantaj.project.payload.request.SignupRequest;
import com.puantaj.project.payload.response.JwtResponse;
import com.puantaj.project.payload.response.MessageResponse;
import com.puantaj.project.repositories.PermissionRepository;
import com.puantaj.project.repositories.RoleRepository;
import com.puantaj.project.repositories.UserRepository;
import com.puantaj.project.security.jwt.JwtUtils;
import com.puantaj.project.security.service.UserDetailsImpl;
import com.puantaj.project.service.EmailService;
import com.puantaj.project.service.UserService;
import com.puantaj.project.tokenexception.InvalidTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private EmailService emailService;

    @Autowired
    UserService userService;

    @Autowired
    PermissionRepository permissionRepository;



    // BU KODLAR KULLANICI GİRİŞ YAPTIKTAN SONRA OTOMATİK OLARAK BELLİ SÜRE SONUNDA ÇIKIŞ YAPMASI VE MEVCUT TOKEN'IN SİLİNMESİ VE GİRİŞ YAPTIKTAN SONRA YENİ TOKEN OLUŞMASINI SAĞLIYOR


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
                passwordEncoder.encode(signUpRequest.getPassword()));

        Set<Role> roles = new HashSet<>();
        Set<ERole> requestRoles = signUpRequest.getRoles();

        if (requestRoles == null || requestRoles.isEmpty()) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role 'ROLE_USER' is not found."));
            roles.add(userRole);
        } else {
            requestRoles.forEach(requestRole -> {
                Role role = roleRepository.findByName(requestRole)
                        .orElseThrow(() -> new RuntimeException("Error: Role '" + requestRole + "' is not found."));
                roles.add(role);
            });
        }

        user.setRoles(roles);
        userService.saveUser(user);

        // Handle permissions
        Set<EPermission> requestPermissions = signUpRequest.getPermissions();
        if (requestPermissions != null && !requestPermissions.isEmpty()) {
            Set<Permission> permissions = new HashSet<>();
            requestPermissions.forEach(requestPermission -> {
                Permission permission = permissionRepository.findByName(requestPermission)
                        .orElseThrow(() -> new RuntimeException("Error: Permission '" + requestPermission + "' is not found."));
                permissions.add(permission);
            });
            user.setPermissions(permissions);
        }

        userService.saveUser(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }



    //FRONT-END ÜZERİNDEN DOĞRULAMA LİNKİNİ BU KOD PARÇACIĞI GÖNDERİYOR

    @PostMapping("/password/reset")
    public ResponseEntity<String> resetPassword(@RequestParam("email") String email, HttpServletRequest request, HttpServletResponse response) {
        // Check if the user exists
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
//        String token = UUID.randomUUID().toString();
//        String shortenedToken = token.substring(0, 1); // Token'ı ilk 8 karakterle temsil ediyoruz
//        user.setPasswordResetToken(shortenedToken);
//        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        user.setPasswordResetToken(token);
        userRepository.save(user);


        // Send an email with the password reset link
        String resetUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/api/auth/password/reset/" + token;
        emailService.sendPasswordResetEmail(user.getEmail(), resetUrl);
//
        // Return a success response
        return ResponseEntity.ok("Password reset link sent to " + email);

    }
    //POSTMAN ÜZERİNDEN DOĞRULAMA LİNKİNİ BU KOD PARÇACIĞI GÖNDERİYOR

//    @PostMapping("/password/reset")
//    public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> requestBody, HttpServletRequest request, HttpServletResponse response) {
//        String email = requestBody.get("email");
//
//        // Check if the user exists
//        User user = userRepository.findByEmail(email);
//        if (user == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
//        }
//
//        // Generate a password reset token
//        String token = UUID.randomUUID().toString();
//        user.setPasswordResetToken(token);
//        userRepository.save(user);
//
//        // Send an email with the password reset link
//        String resetUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/api/auth/password/reset/" + token;
//        emailService.sendPasswordResetEmail(user.getEmail(), resetUrl);
//
//        // Return a success response
//        return ResponseEntity.ok("Password reset link sent to " + email);
//    }


    //ŞİFRE SIFIRLAMA FORMU AÇILIR VE YENİ ŞİFREYİ GİRMENİ SAĞLAR
    @GetMapping("/password/reset/{token}")
    public String showResetPasswordForm(@PathVariable("token") String token, Model model, HttpServletResponse response) throws InvalidTokenException, IOException {
        // Check if the token is valid
        User user = userRepository.findByPasswordResetToken(token);
        if (user == null) {
            throw new InvalidTokenException("Invalid password reset token");
        }

        // Redirect to the password reset page on the frontend
        response.sendRedirect("http://localhost:8081/passwordreset?token=" + token);
        return null;
    }

    @PostMapping("/password/reset/{token}")
    public ResponseEntity<String> resetPassword(@PathVariable("token") String token, @RequestBody Map<String, String> requestBody, HttpServletRequest request, HttpServletResponse response) throws InvalidTokenException {
        // Check if the token is valid
        User user = userRepository.findByPasswordResetToken(token);
        if (user == null) {
            throw new InvalidTokenException("Invalid password reset token");
        }

        // Update the user's password and clear the reset token
        String newPassword = requestBody.get("password");
        // Hash the new password before saving it
        String hashedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(hashedPassword);
        user.setPasswordResetToken(null);
        userRepository.save(user);

        // Return a success response
        return ResponseEntity.ok("Password reset successful");
    }



}