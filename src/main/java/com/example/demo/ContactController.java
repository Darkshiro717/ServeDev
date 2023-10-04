package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {

    private List<Contact> contacts = new ArrayList<>();

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("contacts", contacts);
        return "home";
    }

    @PostMapping("/contact")
    public String submitForm(@Valid @ModelAttribute Contact contact, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contacts", contacts);
            return "home";
        }

        contacts.add(contact);
        model.addAttribute("contact", new Contact());
        model.addAttribute("contacts", contacts);
        return "home";
    }
}
