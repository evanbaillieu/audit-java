package fr.snowsdy.app.service;

import fr.snowsdy.app.entity.Personne;
import fr.snowsdy.app.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service("personneService")
public class PersonneServiceImpl extends PersonneService{

    @Autowired
    PersonneRepository personneRepository;

    String prenom;

    Collection<? extends GrantedAuthority> authorities;

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

    public String getPrenom() {
        return prenom;
    }

    public interface PersonneService {
        PersonneService loadUserByPrenom(String prenom);
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

 /*   @Transactional
    public Personne loadPersonneByPrenom(String prenom){
        Personne personne = personneRepository.findByPrenom(prenom)
                .orElseThrow(() -> new PersonneNotFoundException("User Not Found with username: " + prenom));

        return personneServiceImpl.build(prenom);
    }
*/

}
