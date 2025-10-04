package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressbookController {
    AddressBookRepository addressBookRepository;

    AddressbookController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/book")
    public String book(@RequestParam(name = "id", required=false, defaultValue="1") int id, Model model) {
        model.addAttribute("bookString", addressBookRepository.findById(1L));
        return "book";
    }
}
