package boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
