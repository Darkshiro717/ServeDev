package com.example.contact;

import com.example.contact.data.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
public class ContactController {
//    private List<Contact> contacts = new ArrayList<>();

    private ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/")
    public String GetForm(Model model) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("contacts", contactRepository.findAll());
        return "home";
    }

    @PostMapping("/contact")
    public String SubmitForm(@Valid @ModelAttribute Contact contact, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contacts", contactRepository.findAll());
            return "home";
        }

        contactRepository.save(contact);
        model.addAttribute("contact", new Contact());
        model.addAttribute("contacts",contactRepository.findAll());
        return "home";
    }

}
