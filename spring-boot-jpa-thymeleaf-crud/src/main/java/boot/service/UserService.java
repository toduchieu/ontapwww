package boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.entity.User;
import boot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public void save(User user) {
		repository.save(user);
	}

	public void update(Long id, User user) {
		User old = findById(id);
		if (old != null) {
			repository.save(user);
		}
	}

	public void delete(Long id) {
		User old = findById(id);
		if (old != null) {
			repository.delete(old);
		}
	}
}
