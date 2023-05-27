package boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.entity.Role;
import boot.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;

	public List<Role> findAll() {
		return repository.findAll();
	}

	public Role findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public void save(Role role) {
		repository.save(role);
	}

	public void update(Long id, Role role) {
		Role old = findById(id);
		if (old != null) {
			repository.save(role);
		}
	}

	public void delete(Long id) {
		Role old = findById(id);
		if (old != null) {
			repository.delete(old);
		}
	}
}
