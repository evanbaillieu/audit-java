package fr.snowsdy.app.service;

import fr.snowsdy.app.entity.Personne;
import fr.snowsdy.app.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("personneService")
public class PersonneServiceImpl extends PersonneService{

    @Autowired
    PersonneRepository personneRepository;

    public Personne save(Personne p){
        // verif si login / mdp / poste :
        return personneRepository.save(p);
    }

    public Optional<Personne> getById(long id) {
        return personneRepository.findById(id);
    }

    public String test() {
        return personneRepository.testOk();
    }

    public Iterable<Personne> getAll() {
        return personneRepository.findAll();
    }
}
