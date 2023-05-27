package boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
