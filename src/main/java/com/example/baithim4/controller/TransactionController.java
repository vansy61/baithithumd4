package com.example.baithim4.controller;

import com.example.baithim4.model.Customer;
import com.example.baithim4.model.Transaction;
import com.example.baithim4.model.TransactionDto;
import com.example.baithim4.service.ICustomerService;
import com.example.baithim4.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private ICustomerService customerService;

    @ModelAttribute("customers")
    public Iterable<Customer> customers() {
        return customerService.findAll();
    }

    @RequestMapping("")
    public String index(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String transactionType,
            Model model
    ) {
        Iterable<TransactionDto> transactions = transactionService.searchAll(name, transactionType);
        model.addAttribute("transactions", transactions);
        model.addAttribute("name", name);
        model.addAttribute("transactionType", transactionType);
        return "transactions/index";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "transactions/create";
    }


    @PostMapping("/create")
    public String create(
            @Validated @ModelAttribute Transaction transaction,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model
    ) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("transaction", transaction);
            return "transactions/create";
        }
        transactionService.save(transaction);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/transactions";
    }

    @RequestMapping("/{id}/show")
    public String show(@PathVariable Long id, Model model) {
        Transaction transaction = transactionService.findById(id);
        model.addAttribute("transaction", transaction);
        return "transactions/show";
    }

    @RequestMapping("/{id}/delete")
    public String delete(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes
    ) {
        transactionService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/transactions";
    }

}
