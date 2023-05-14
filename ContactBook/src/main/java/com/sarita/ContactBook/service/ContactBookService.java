package com.sarita.ContactBook.service;

import com.sarita.ContactBook.entity.ContactDetails;
import com.sarita.ContactBook.repo.ContactBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactBookService {
    @Autowired
    private ContactBookRepo contactBookRepo;

    public ContactDetails createNewContact(ContactDetails contactDetails) {
        try {
            return contactBookRepo.save(contactDetails);
        } catch (Exception ex) {
            throw new RuntimeException("Email already exist " + ex.getMessage());
        }
    }

    public List<ContactDetails> getAllContacts() {
        return contactBookRepo.findAll();
    }

    public ContactDetails findContactByEmail(String email) {
        return contactBookRepo.findByEmail(email);
    }

    public List<ContactDetails> findByFirstName(String firstName) {
        return contactBookRepo.findByFirstName(firstName);
    }

    public ContactDetails updateContactDetails(ContactDetails contactDetails) {
        ContactDetails contactDetails1 = contactBookRepo.findByEmail(contactDetails.getEmail());

        contactDetails.setContactNumber(contactDetails.getContactNumber() != null ?
                contactDetails.getContactNumber() : contactDetails1.getContactNumber());
        contactDetails.setEmail(contactDetails.getEmail() != null ?
                contactDetails.getEmail() : contactDetails1.getEmail());
        contactDetails.setFirstName(contactDetails.getFirstName() != null ?
                contactDetails.getFirstName() : contactDetails1.getFirstName());
        contactDetails.setLastName(contactDetails.getLastName() != null ?
                contactDetails.getLastName() : contactDetails1.getLastName());
        contactBookRepo.delete(contactDetails1);

        return contactBookRepo.save(contactDetails);
    }

    public String deleteRecords(String email) {
        try{
            ContactDetails contactDetails=contactBookRepo.findByEmail(email);
            contactBookRepo.delete(contactDetails);
        }catch (Exception ex){
            throw new RuntimeException("Exception while removing records");
        }
        return "Record successfully deleted";

    }
}
