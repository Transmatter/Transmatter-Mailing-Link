package transmatter.project.security.authentication.service;

import transmatter.project.security.authentication.controller.JwtAuthenticationRequest;
import transmatter.project.security.authentication.dao.UserDao;
import transmatter.project.security.authentication.entity.*;
import transmatter.project.security.authentication.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User getUser(Long userID) {
        return userDao.getUser(userID);
    }

    @Override
    public User updateUser(Long userID, JwtAuthenticationRequest authenticationRequest) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = userDao.getUser(userID);

        user.setEmail(authenticationRequest.getEmail());
        user.setImageProfile(authenticationRequest.getImageProfile());
        user.setPassword(encoder.encode(authenticationRequest.getPassword()));
        user.setFirstname(authenticationRequest.getFirstname());
        user.setLastname(authenticationRequest.getLastname());
        user.setPhoneNo(authenticationRequest.getPhoneNo());
        return userDao.updateUser(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public User addUser(
            JwtAuthenticationRequest authenticationRequest
    ) {
        Authority authUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        authorityRepository.save(authUser);

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setEmail(authenticationRequest.getEmail());
        user.setUsername(authenticationRequest.getUsername());
        user.setPassword(encoder.encode(authenticationRequest.getPassword()));
        user.setImageProfile(authenticationRequest.getImageProfile());
        user.setFirstname(authenticationRequest.getFirstname());
        user.setLastname(authenticationRequest.getLastname());
        user.setPhoneNo(authenticationRequest.getPhoneNo());

        user.setEnabled(true);
        user.getAuthorities().add(authUser);

        return userDao.addUser(user);
    }

    @Override
    public Boolean userValidation(JwtAuthenticationRequest authenticationRequest){
        List<User> users = userDao.getAllUser();
        // in case user want to update their data might reconsider to do this again.
//        if(authenticationRequest.getPersonalID().length() == 0){
//            for(User u : users){
//                if(u.getEmail().equals(authenticationRequest.getEmail())){
//                    return false;
//                }
//            }
//            return true;
//        }

        //in case user want to change their username and password
        if(authenticationRequest.getEmail() == null){
            for(User u : users){
                if(u.getUsername().equals(authenticationRequest.getUsername())){
                    return false;
                }
            }
            return true;
        }

        // normal case
        for(User u : users){
            if(
                    u.getUsername().equals(authenticationRequest.getUsername())
            ){
                return false;
            }
        }
        return true;
    }
}
