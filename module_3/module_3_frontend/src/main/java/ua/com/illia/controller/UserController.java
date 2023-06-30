package ua.com.illia.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.illia.api.UserApiService;
import ua.com.illia.model.AccountPostModel;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserApiService userApiService;

   /* @GetMapping("/new")
    public String createUserMenu(Model model) {
        model.addAttribute("user", new UserModel());
        return "nep/user_new";
    }*/

   /* @PostMapping("/new")
    public String createUser(@ModelAttribute UserModel user) {
        if (!userApiService.create(user)) {
            return "400";
        }
        return "redirect:/users";
    }*/

    @GetMapping("/{id}/new")
    public String createAccountMenu(@PathVariable Long id, Model model) {
        model.addAttribute("account", new AccountPostModel());
        model.addAttribute("owner_id", id);
        return "nep/account_new";
    }

    @PostMapping("/{id}/new")
    public String createAccount(@PathVariable Long id, @ModelAttribute AccountPostModel account) {
        if (!userApiService.createAccount(account, id)) {
            return "400";
        }
        return "redirect:/users/" + id;
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("users", userApiService.findAll());
        return "pages/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        if (userApiService.findById(id).isPresent()) {
            model.addAttribute("user_det", userApiService.findById(id).get());
            return "pages/user_details";
        }
        return "404";
    }
}
