package boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.entity.Account;
import boot.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;

	public List<Account> findAll() {
		return repository.findAll();
	}

	public Account findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public void save(Account account) {
		repository.save(account);
	}

	public void update(Long id, Account account) {
		Account old = findById(id);
		if (old != null) {
			repository.save(account);
		}
	}

	public void delete(Long id) {
		Account old = findById(id);
		if (old != null) {
			repository.delete(old);
		}
	}
}
