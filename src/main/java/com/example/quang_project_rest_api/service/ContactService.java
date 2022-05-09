package com.example.quang_project_rest_api.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quang_project_rest_api.model.Contact;

@Repository
public interface ContactService extends JpaRepository<Contact, Long>{
    //todo
}