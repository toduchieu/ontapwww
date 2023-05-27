package boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import boot.entity.Role;
import boot.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("roles", roleService.findAll());
		return "role/role";
	}

	@GetMapping("/add")
	public String saveGet(Model model) {
		model.addAttribute("role", new Role());
		return "role/role_add";
	}

	@PostMapping("/add")
	public String savePost(@ModelAttribute Role role) {
		roleService.save(role);
		return "redirect:/role";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		roleService.delete(id);
		return "redirect:/role";
	}

	@GetMapping("/update/{id}")
	public String updateGet(Model model, @PathVariable("id") Long id) {
		model.addAttribute("role", roleService.findById(id));
		return "role/role_update";
	}

	@PostMapping("/update/{id}")
	public String savePost(@ModelAttribute Role role, @PathVariable("id") Long id) {
		roleService.update(id, role);
		return "redirect:/role";
	}
}
