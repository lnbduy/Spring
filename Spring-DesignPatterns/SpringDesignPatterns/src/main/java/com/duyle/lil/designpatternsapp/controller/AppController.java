package com.duyle.lil.designpatternsapp.controller;


import com.duyle.lil.designpatternsapp.builder.Contact;
import com.duyle.lil.designpatternsapp.builder.ContactBuilder;
import com.duyle.lil.designpatternsapp.factory.Pet;
import com.duyle.lil.designpatternsapp.factory.PetFactory;
import com.duyle.lil.designpatternsapp.repository.PresidentEntity;
import com.duyle.lil.designpatternsapp.repository.PresidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class AppController {
    private final PetFactory petFactory;

    public AppController(PetFactory petFactory) {
        this.petFactory = petFactory;
    }

    @GetMapping
    public String getDefault(){
        return "{\"message\": \"Hello World\"}";
    }

    @PostMapping("adoptPet/{type}/{name}")
    public Pet adoptPet(@PathVariable String type, @PathVariable String name) {
        Pet pet = petFactory.createPet(type);
        pet.setName(name);
        pet.feed();
        return pet;
    }

    @GetMapping("presidents")
    public List<Contact> getPresidents() {
        List<Contact> contacts = new ArrayList<>();
        Contact contact = new Contact();
        contact.setFirstName("George");
        contact.setLastName("Washington");

        contacts.add(contact);
        contacts.add(new Contact("John", "Adams", null));
        contacts.add(new ContactBuilder().firstName("Thomas").lastName("Jefferson").buildContact());
        return contacts;
    }

    @Autowired
    PresidentRepository presidentRepository;

    @GetMapping("presidents/{id}")
    public PresidentEntity getPresById(@PathVariable Long id) {
        return this.presidentRepository.findById(id).get();
    }

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("presidentContact/{id}")
    public Contact getPresContactById(@PathVariable Long id) {
        PresidentEntity entity = this.restTemplate.getForEntity("http://localhost:8080/presidents/{id}", PresidentEntity.class, id).getBody();
        return new ContactBuilder().firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .emailAddress(entity.getEmailAddress())
                .buildContact();
    }

}
