
package com.example.accessingmongodbdatarest;

import java.util.List;
import javax.validation.Valid;
import java.util.Optional;

import com.example.accessingmongodbdatarest.PersonRepository;
import com.example.accessingmongodbdatarest.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/person")
public class PersonController {
  @Autowired
  private PersonRepository repository;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Person> getAllPets() {
    return repository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Optional<Person> getPetById(@PathVariable("id") String id) {
    return repository.findById(id);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifyPetById(@PathVariable("id") String id, @Valid @RequestBody Person person) {
    person.setId(id);
    repository.save(person);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Person createPet(@Valid @RequestBody Person person) {
    repository.save(person);
    return person;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePet(@PathVariable String id) {
    repository.deleteById(id);
}
}