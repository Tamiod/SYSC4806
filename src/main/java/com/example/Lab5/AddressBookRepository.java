package com.example.Lab5;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

    List<AddressBook> findAll();

    AddressBook findById(long id);
}

