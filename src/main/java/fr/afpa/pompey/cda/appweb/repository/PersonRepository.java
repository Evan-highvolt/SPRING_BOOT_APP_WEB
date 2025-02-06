package fr.afpa.pompey.cda.AppWeb.repository;

import fr.afpa.pompey.cda.AppWeb.config.CustomProperties;
import fr.afpa.pompey.cda.AppWeb.model.Person;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Data
@Component
public class PersonRepository {

    private static final Logger log = LoggerFactory.getLogger(PersonRepository.class);
    @Autowired
    private CustomProperties properties;

    public Iterable<Person> getPersons() {
//        Recuperation de ma proprities contenant l'url de l'API
        String baseURL = properties.getUrlAPI();

//        construction de l'url pour appeller l'API
        String getPersonsURL = baseURL + "/persons";

//        construction de la rqt HTTP
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Person>> response = restTemplate.exchange(
                getPersonsURL,
                HttpMethod.GET,
                null
                ,new ParameterizedTypeReference<>() {}
        );
        log.debug("Get Persons Call" + response.getStatusCode());
//        envoi la reponse
        return response.getBody();
    }

    public Person getPerson(Integer id) {
        String baseURL = properties.getUrlAPI();
        String getPersonsURL = baseURL + "/person/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Person> response = restTemplate.exchange(
                getPersonsURL,
                HttpMethod.GET,
                null,
                Person.class
        );
        log.debug("Get Person Call" + response.getStatusCode());
        return response.getBody();
    }

    public Person createPerson(Person person) {
        String basApiUrl = properties.getUrlAPI();
        String createPersonURL = basApiUrl + "/person";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Person> request = new HttpEntity<>(person);
        ResponseEntity<Person> response = restTemplate.exchange(
                createPersonURL,
                HttpMethod.POST,
                request,
                Person.class
        );
        log.debug("Create Person Call" + response.getStatusCode());
        return response.getBody();

    }

    public Person updatePerson(Person person) {
        String basApiUrl = properties.getUrlAPI();
        String updatePersonURL = basApiUrl + "/person/" + person.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Person> request = new HttpEntity<>(person);
        ResponseEntity<Person> response = restTemplate.exchange(
                updatePersonURL,
                HttpMethod.PUT,
                request,
                Person.class
        );
        log.debug("Update Person Call" + response.getStatusCode());
        return response.getBody();
    }


    public void deletePerson(Integer id) {
        String basApiUrl = properties.getUrlAPI();
        String deletePersonURL = basApiUrl + "/person/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response =restTemplate.exchange(
                deletePersonURL,
                HttpMethod.DELETE,
                null,
                Void.class
        );
        log.debug("Delete Person Call" + response.getStatusCode());
    }


}
