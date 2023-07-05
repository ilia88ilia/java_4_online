package ua.com.illia.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.illia.api.AccountApiService;

@Controller
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountApiService accountApiService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("accounts", accountApiService.findAll());
        return "pages/accounts";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        if (accountApiService.findById(id).isPresent()) {
            model.addAttribute("account", accountApiService.findById(id).get());
            return "pages/account_details";
        }
        return "404";
    }

}