package boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import boot.entity.Account;
import boot.service.AccountService;
import boot.service.RoleService;
import boot.service.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("accounts", accountService.findAll());
		return "account/account";
	}

	@GetMapping("/add")
	public String saveGet(Model model) {
		model.addAttribute("account", new Account());
		model.addAttribute("users", userService.findAll());
		model.addAttribute("roles", roleService.findAll());
		return "account/account_add";
	}

	@PostMapping("/add")
	public String savePost(@ModelAttribute Account account) {
		accountService.save(account);
		return "redirect:/account";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") Long id) {
		accountService.delete(id);
		return "redirect:/account";
	}

	@GetMapping("/update/{id}")
	public String update(Model model, @PathVariable("id") Long id) {
		model.addAttribute("account", accountService.findById(id));
		model.addAttribute("users", userService.findAll());
		model.addAttribute("roles", roleService.findAll());
		return "account/account_update";
	}
}
