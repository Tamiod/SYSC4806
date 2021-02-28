package com.example.Lab5;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AddressBookController {
    private AddressBookRepository addressBookRepository;
    private BuddyInfoRepository buddyInfoRepository;

    public AddressBookController(AddressBookRepository adr, BuddyInfoRepository bir){
        this.addressBookRepository = adr;
        this.buddyInfoRepository = bir;
    }

    @RequestMapping("/")
    public @ResponseBody
    String greeting() {
        return "Hello, World";
    }

    @GetMapping("/addressbook")
    public String addressBook(@RequestParam(name = "ID", required = true) Long ID, Model model) {
        model.addAttribute("ID", ID);

        AddressBook ab = new AddressBook();
        ab.setId(Math.toIntExact(ID));
        addressBookRepository.save(ab);

        return "addressbook";
    }

    @GetMapping("/addBuddy")
    public String addBuddy(@RequestParam(name = "name", required=false, defaultValue="Lois") String name,
                           @RequestParam(name = "address", required = false, defaultValue = "ottawa") String address,
                           @RequestParam(name = "phoneNumber", required = false, defaultValue = "123") String phoneNumber,
                           @RequestParam(name = "ID", required = true)long ID,
                           @RequestParam(name="AddressBookID", required=false, defaultValue = "1") long AddressBookID,
                           Model model
    ){
        model.addAttribute("name", name);
        BuddyInfo buddyAdded = new BuddyInfo(name, address, phoneNumber);
        buddyAdded.setId(Math.toIntExact(ID));

        buddyInfoRepository.save(buddyAdded);

        AddressBook addressBookToAdd = addressBookRepository.findById(AddressBookID);
        addressBookToAdd.addBuddies(buddyAdded);
        addressBookRepository.save(addressBookToAdd);
        return "addBuddy";
    }
//
//    @GetMapping("/removeBuddy")
//    public String removeBuddy(@RequestParam(name="ID", required = true) long ID,
//                              @RequestParam(name= "AddressBookID", required = true) long AddressBookID,
//                              Model model){
//        model.addAttribute("ID", Long.toString(ID));
//        model.addAttribute("AddressBookID", Long.toString(AddressBookID));
//
//        BuddyInfo buddytoRemove = buddyInfoRepository.findById(ID);
//        buddyInfoRepository.delete(buddytoRemove);
//
//        AddressBook addressBookRemovedFrom = addressBookRepository.findById(AddressBookID);
//
//        addressBookRemovedFrom.removeBuddy(buddytoRemove);
//
//        addressBookRepository.save(addressBookRemovedFrom);
//
//        return "removeBuddy";    }

}
