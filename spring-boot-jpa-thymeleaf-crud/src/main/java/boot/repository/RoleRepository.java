package boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
