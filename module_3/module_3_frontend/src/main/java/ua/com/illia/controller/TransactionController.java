package ua.com.illia.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.illia.api.TransactionApiService;
import ua.com.illia.model.TransactionPostModel;

@Controller
@AllArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionApiService transactionApiService;

    @GetMapping("/export/{id}")
    public String exportByAccId(@PathVariable Long id) {
        transactionApiService.exportByAccId(id);
        return "export_done";
    }

    @GetMapping("/export")
    public String exportAll() {
        transactionApiService.exportAll();
        return "export_done";
    }

    @GetMapping("/new")
    public String createTransactionMenu(Model model) {
        model.addAttribute("transaction", new TransactionPostModel());
        return "pages/transaction_new";
    }

    @PostMapping("/new")
    public String createTransaction(@ModelAttribute TransactionPostModel transaction) {
        if (!transactionApiService.create(transaction)) {
            return "400";
        }
        return "redirect:/transactions";
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("transactions", transactionApiService.findAll());
        return "pages/transactions";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        if (transactionApiService.findById(id).isPresent()) {
            model.addAttribute("transaction", transactionApiService.findById(id).get());
            return "pages/transaction_details";
        }
        return "404";
    }
}
