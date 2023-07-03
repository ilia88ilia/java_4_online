package ua.com.illia.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.illia.api.UserApiService;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserApiService userApiService;

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
