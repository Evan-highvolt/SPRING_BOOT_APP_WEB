package fr.afpa.pompey.cda.AppWeb.service;

import fr.afpa.pompey.cda.AppWeb.model.Person;
import fr.afpa.pompey.cda.AppWeb.repository.PersonRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person getPerson(Integer id) {
        return personRepository.getPerson(id);
    }

    public Iterable<Person> getPersons() {
        return personRepository.getPersons();
    }

    public void deletePerson(final Integer id) {
        personRepository.deletePerson(id);
    }

    public Person savePerson(Person person) {
        Person saved;
        person.setLastName(person.getLastName().toUpperCase());

        if (person.getId() == null) {
            saved = personRepository.createPerson(person);
        } else {
            saved = personRepository.updatePerson(person);
        }
        return saved;
    }


}
