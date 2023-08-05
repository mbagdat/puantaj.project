package com.puantaj.project.payload.request;


import com.puantaj.project.models.EPermission;
import com.puantaj.project.models.ERole;
import lombok.Data;


import java.util.Set;


@Data
public class SignupRequest {

    private String username;
    private String email;
    private String password;
    private Set<ERole> roles;
    private String description;
    private Set<EPermission> permissions;







//    @NotBlank
//    @Size(min = 3, max = 20)
//    private String username;
//
//    @NotBlank
//    @Size(max = 50)
//    @Email
//    private String email;
//
////    private boolean active;
////
////    private String verificationCode;
////
////    private String passwordResetToken;
//
//    private Set<String> role;
//
//    @NotBlank
//    @Size(min = 6, max = 40)
//    private String password;
//
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
////    public boolean isActive() {
////        return active;
////    }
////
////    public void setActive(boolean active) {
////        this.active = active;
////    }
////
////    public String getVerificationCode() {
////        return verificationCode;
////    }
////
////    public void setVerificationCode(String verificationCode) {
////        this.verificationCode = verificationCode;
////    }
////
////    public String getPasswordResetToken() {
////        return passwordResetToken;
////    }
////
////    public void setPasswordResetToken(String passwordResetToken) {
////        this.passwordResetToken = passwordResetToken;
////    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Set<String> getRole() {
//        return this.role;
//    }
//
//    public void setRole(Set<String> role) {
//        this.role = role;
//    }
}



