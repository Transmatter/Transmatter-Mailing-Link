package transmatter.project.security.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transmatter.project.security.authentication.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
