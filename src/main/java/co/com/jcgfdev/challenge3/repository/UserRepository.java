package co.com.jcgfdev.challenge3.repository;

import co.com.jcgfdev.challenge3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
