package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressbookController {
    AddressBookRepository addressBookRepository;
    BuddyInfoRepository buddyInfoRepository;
    long curAddressBookId;

    AddressbookController(AddressBookRepository addressBookRepository , BuddyInfoRepository buddyInfoRepository) {
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @GetMapping("/booksearch")
    public String getBookForm(@ModelAttribute AddressBook addressBook) {
        return "booksearch";
    }

    @PostMapping("/booksearch")
    public String getBookSubmit(@ModelAttribute AddressBook addressBook) {
        return "redirect:/book?id=" + addressBook.getId();
    }


    @GetMapping("/book")
    public String book(@RequestParam(name = "id", required=false, defaultValue="1") int id, Model model) {
        model.addAttribute("bookString", addressBookRepository.findById(id));
        model.addAttribute("addbuddyredirect", "/addbuddy?id=" + id);
        return "book";
    }

    @GetMapping("/books")
    @ResponseBody
    public AddressBook books(@RequestParam(name = "id", required=true) int id) {
        return addressBookRepository.findById(id);
    }

    @GetMapping("/newbook")
    public String addBookForm(@ModelAttribute AddressBook addressBook,  Model model) {
        model.addAttribute("bookString", addressBookRepository.save(addressBook));
        model.addAttribute("addbuddyredirect", "/addbuddy?id=" + addressBook.getId());
        return "newbook";
    }

    @PostMapping("/newbook")
    public String addBookSubmit(@ModelAttribute AddressBook addressBook,  Model model) {
        model.addAttribute("bookString", addressBookRepository.save(addressBook));
        model.addAttribute("addbuddyredirect", "/addbuddy?id=" + addressBook.getId());
        return "book";
    }

    @GetMapping("/addbuddy")
    public String addBuddyForm(@RequestParam(name = "id", required=true, defaultValue="1") int id, @ModelAttribute BuddyInfo buddyInfo, Model model) {
        model.addAttribute("bookString", addressBookRepository.findById(id));
        model.addAttribute("addbuddyredirect", "/addbuddy?id=" + id);
        curAddressBookId = id;
        return "addbuddy";
    }

    @PostMapping("/addbuddy")
    public String addBuddySubmit(@ModelAttribute BuddyInfo buddyInfo, Model model) {
        buddyInfoRepository.save(buddyInfo);
        AddressBook addressBook = addressBookRepository.findById(curAddressBookId);
        addressBook.addBuddy(buddyInfo);
        model.addAttribute("bookString", addressBookRepository.save(addressBook));
        model.addAttribute("addbuddyredirect", "/addbuddy?id=" + curAddressBookId);
        return "book";
    }
}
