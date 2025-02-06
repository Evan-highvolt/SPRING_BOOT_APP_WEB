package fr.afpa.pompey.cda.AppWeb.controller;
import fr.afpa.pompey.cda.AppWeb.service.PersonService;
import fr.afpa.pompey.cda.AppWeb.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {
        Iterable<Person> listPersons = personService.getPersons();
        model.addAttribute("listPersons", listPersons);
        return "home";
    }

    @GetMapping(value = {"/createperson"})
    public String createPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "createPerson";
    }

    @GetMapping(value = {"/updatePerson/{id}"})
    public String updatePerson(Model model, @PathVariable ("id") final Integer id, Model model1) {
        Person person = personService.getPerson(id);
        model.addAttribute("person", person);
        return "updatePerson";
    }

    @GetMapping(value = {"/deleteperson/{id}"})
    public ModelAndView deletePerson(@PathVariable ("id") final Integer id) {
        personService.deletePerson(id);
        return new ModelAndView("redirect:/");
    }

    @PostMapping(value = {"/savePerson"})
    public ModelAndView savePerson(@ModelAttribute("person") final Person person) {
        personService.savePerson(person);
        return new ModelAndView("redirect:/");
    }






}
