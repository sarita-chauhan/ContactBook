package com.sarita.ContactBook.control;

import com.sarita.ContactBook.entity.ContactDetails;
import com.sarita.ContactBook.repo.ContactBookRepo;
import com.sarita.ContactBook.service.ContactBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact/")
public class ContactBookController {
    @Autowired
    private ContactBookRepo contactBookRepo;
    @Autowired
    private ContactBookService contactBookService;
    @PostMapping("create")
    public ContactDetails createNewContact(@RequestBody ContactDetails contactDetails){
        return contactBookService.createNewContact(contactDetails);
    }
    @GetMapping("getAll")
    public List<ContactDetails> getAllContacts(){
        return contactBookService.getAllContacts();
    }
    @GetMapping("findByEmail/{email}")
    public ContactDetails findContactByEmail(@PathVariable("email") String email){
        return contactBookService.findContactByEmail(email);
    }
    @GetMapping("findByName/{firstName}")
    public List<ContactDetails> findByFirstName(@PathVariable("firstName") String firstName){
        return contactBookService.findByFirstName(firstName);
    }
    @PutMapping("updateRecord")
    public ContactDetails updateContactDetails(@RequestBody ContactDetails contactDetails){
        return contactBookService.updateContactDetails(contactDetails);
    }
    @DeleteMapping("delete/{email}")
    public String deleteContact(@PathVariable("email")String email){
        return contactBookService.deleteRecords(email);
    }
}
