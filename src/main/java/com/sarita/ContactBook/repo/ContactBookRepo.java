package com.sarita.ContactBook.repo;

import com.sarita.ContactBook.entity.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactBookRepo extends JpaRepository<ContactDetails, Long> {
    ContactDetails findByEmail(String email);

    List<ContactDetails> findByFirstName(String firstName);
}
