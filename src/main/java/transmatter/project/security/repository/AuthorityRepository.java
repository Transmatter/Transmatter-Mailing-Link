package transmatter.project.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import transmatter.project.security.entity.Authority;
import transmatter.project.security.entity.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName input);
}
