package transmatter.project.security.authentication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import transmatter.project.security.authentication.entity.Authority;
import transmatter.project.security.authentication.entity.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName input);
}
