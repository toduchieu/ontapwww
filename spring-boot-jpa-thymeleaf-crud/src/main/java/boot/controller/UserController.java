package boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import boot.entity.User;
import boot.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("users", userService.findAll());
		return "user/user";
	}

	@GetMapping("/add")
	public String saveGet(Model model) {
		model.addAttribute("user", new User());
		return "user/user_add";
	}

	@PostMapping("/add")
	public String savePost(@ModelAttribute User user) {
		userService.save(user);
		return "redirect:/user";
	}

	@GetMapping("/update/{id}")
	public String updateGet(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("user", userService.findById(id));
		return "user/user_update";
	}

	@PostMapping("/update/{id}")
	public String updatePost(@ModelAttribute User user, @PathVariable(name = "id") Long id) {
		userService.update(id, user);
		return "redirect:/user";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		userService.delete(id);
		return "redirect:/user";
	}
}
