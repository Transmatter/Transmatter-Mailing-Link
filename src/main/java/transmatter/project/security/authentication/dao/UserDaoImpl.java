package transmatter.project.security.authentication.dao;

import transmatter.project.security.authentication.entity.User;
import transmatter.project.security.authentication.repository.AuthorityRepository;
import transmatter.project.security.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAllUserPagination(Integer pageSize, Integer pageNo) {
        return userRepository.findAll(PageRequest.of(pageNo-1,pageSize));
    }

    @Override
    public User getUser(Long userID) {
        return userRepository.findById(userID).orElse(null);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public User addUser(User user){
        return userRepository.save(user);
    }
}
