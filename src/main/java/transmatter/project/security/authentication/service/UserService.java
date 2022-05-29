package transmatter.project.security.authentication.service;

import transmatter.project.security.authentication.controller.JwtAuthenticationRequest;
import transmatter.project.security.authentication.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUser(Long userID);
    User updateUser(Long userID,JwtAuthenticationRequest user);
    User getUserByUsername(String username);
    Boolean userValidation(JwtAuthenticationRequest authenticationRequest);
    User addUser(JwtAuthenticationRequest authenticationRequest);
}
