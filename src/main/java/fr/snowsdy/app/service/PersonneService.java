package fr.snowsdy.app.service;

import fr.snowsdy.app.entity.Personne;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Optional;

@Service
@RestController
public abstract class PersonneService implements Serializable {

    @Autowired
    PersonneServiceImpl personneServiceImpl;

    public static final String springMessage = "Spring Service";

    public PersonneService() {
    }

    public String sayHello() {
        return springMessage;
    }


    @GetMapping("/Personneid")
    public Optional<Personne> getById(@RequestParam(value = "id", defaultValue = "0") Optional<Long> id) {
        return personneServiceImpl.getById(id) ;
    }


    @GetMapping("/Personneadd")
    public Personne getPersonne(@RequestParam("nom") String nom,
                                @RequestParam("prenom") String prenom,
                                @RequestParam("login") String login,
                                @RequestParam("mdp") String mdp,
                                @RequestParam("poste") int poste) {
        return personneServiceImpl.save(new Personne(nom, prenom, login, mdp, poste));
    }

    @GetMapping("/Personneend")
    public void end() {
        System.exit(0);
    }

    /*
    Normalement, le service est une interface, sauf que comme
    on l'utilise pour être l'api, on déclare les méthodes en lien
    avec la BdD en **abstract** pour que quand tu créera ta classe
    PersonneServiceImpl (par exemple), elle implémentera PersonneService
    qui implémentera les méthodes ci-dessous :
     */

    public void deleteById(int id){
        // TODO HERE:
    }

    @GetMapping("/Personneall")
    public @ResponseBody Iterable<Personne> getAllPersonne(){
        return personneServiceImpl.getAll();
    }

    @GetMapping("/Personnetest")
    public String test(){
        return personneServiceImpl.test();
    }

    public PersonneServiceImpl getPersonneServiceImpl() {
        return personneServiceImpl;
    }

    public void setPersonneServiceImpl(PersonneServiceImpl personneServiceImpl) {
        this.personneServiceImpl = personneServiceImpl;
    }

}
