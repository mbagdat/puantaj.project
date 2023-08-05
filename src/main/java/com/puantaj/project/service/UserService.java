package com.puantaj.project.service;


import com.puantaj.project.models.User;
import com.puantaj.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
     UserRepository userRepository;

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // Diğer metotlar ve işlevler...
}


//import com.puantaj.project.models.Role;
//import com.puantaj.project.models.User;
//import com.puantaj.project.repositories.RoleRepository;
//import com.puantaj.project.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class UserService {
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    RoleRepository roleRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public User signUp(User user) {
//        // Şifreyi hashleme
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        // Default rol ataması
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleRepository.findByName("ROLE_USER"));
//        user.setRoles(roles);
//        return userRepository.save(user);
//    }
//
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//}
