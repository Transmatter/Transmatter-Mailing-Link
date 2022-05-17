package transmatter.project.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transmatter.project.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
