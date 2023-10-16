package com.example.contact;

import com.example.contact.data.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/")
@SessionAttributes("contacts")
public class ContactController {

    private ContactRepository contactRepository;

    @ModelAttribute(name = "contact")
    public Contact contact() {
        return new Contact();
    }

    @ModelAttribute(name = "contacts")
    public void addContactsToModel(Model model) {
        model.addAttribute("contacts",contactRepository.findAll());
    }

    public ContactController(ContactRepository contactRepo){
        this.contactRepository=contactRepo;
    }

    @GetMapping
    public String showContactForm() {
        return "home";
    }

    @PostMapping
    public String process(@Valid Contact contact, Errors errors, SessionStatus sessionStatus) {

        if (errors.hasErrors()) {
            return "home";
        }

        contactRepository.save(contact);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
