package data.repo;

import data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface userRepo extends JpaRepository<User,String> {
}
