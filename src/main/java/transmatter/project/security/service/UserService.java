package transmatter.project.security.service;

import transmatter.project.security.controller.JwtAuthenticationRequest;
import transmatter.project.security.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUser(Long userID);
    User updateUser(Long userID,JwtAuthenticationRequest user);
    User getUserByUsername(String username);
    Boolean userValidation(JwtAuthenticationRequest authenticationRequest);
    User addUser(JwtAuthenticationRequest authenticationRequest);
}
