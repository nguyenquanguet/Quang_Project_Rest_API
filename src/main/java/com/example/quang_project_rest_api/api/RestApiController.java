package com.example.quang_project_rest_api.api;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.quang_project_rest_api.model.Contact;
import com.example.quang_project_rest_api.service.ContactService;

@RestController
@RequestMapping("/api")
public class RestApiController {
    public static Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    ContactService contactService;

    //Get Request
    @RequestMapping(value = "/contact/", method = RequestMethod.GET)
    public ResponseEntity<List<Contact>> listAllContact(){
        List<Contact> listContact= contactService.findAll();
        if(listContact.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Contact>>(listContact, HttpStatus.OK);
    }

    //Get Request by id
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    public Contact findContact(@PathVariable("id") long id) {
        Contact contact= contactService.getOne(id);
        if(contact == null) {
            ResponseEntity.notFound().build();
        }
        return contact;
    }

    //Post Request
    @RequestMapping(value = "/contact/", method = RequestMethod.POST)
    public Contact saveContact(@Valid @RequestBody Contact contact) {
        return contactService.save(contact);
    }

    //Put Request by id
    @RequestMapping(value = "/contact/", method = RequestMethod.PUT)
    public ResponseEntity<Contact> updateContact(@PathVariable(value = "id") Long contactId,
                                                 @Valid @RequestBody Contact contactForm) {
        Contact contact = contactService.getOne(contactId);
        if(contact == null) {
            return ResponseEntity.notFound().build();
        }
        contact.setName(contactForm.getName());
        contact.setAge(contactForm.getAge());

        Contact updatedContact = contactService.save(contact);
        return ResponseEntity.ok(updatedContact);
    }

    //Delete Request
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Contact> deleteContact(@PathVariable(value = "id") Long id) {
        Contact contact = contactService.getOne(id);
        if(contact == null) {
            return ResponseEntity.notFound().build();
        }

        contactService.delete(contact);
        return ResponseEntity.ok().build();
    }
}