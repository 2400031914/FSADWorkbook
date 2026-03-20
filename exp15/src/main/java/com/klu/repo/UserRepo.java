package com.klu.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.model.User;
import java.util.Optional;
public interface UserRepo extends JpaRepository<User,Integer>{
Optional<User> findByUsername(String username);
}