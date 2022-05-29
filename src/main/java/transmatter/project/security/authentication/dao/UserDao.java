package transmatter.project.security.authentication.dao;

import transmatter.project.security.authentication.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    Page<User> getAllUserPagination(Integer pageSize,Integer pageNo);
    User getUser(Long userID);
    User updateUser(User user);
    User getUserByUsername(String username);
    User addUser(User user);
}
