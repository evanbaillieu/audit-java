/* package fr.snowsdy.app.service;

import fr.snowsdy.app.entity.Modele;
import fr.snowsdy.app.repository.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Optional;

public class ModeleServiceImpl {
    @Autowired
    ModeleRepository modeleRepository;

    String prenom;

    Collection<? extends GrantedAuthority> authorities;

    public Modele save(Modele m){
        return modeleRepository.save(m);
    }

    public Optional<Modele> getById(long id) {
        return modeleRepository.findById(id);
    }

    public String test() {
        return modeleRepository.testOk();
    }

    public Iterable<Modele> getAll() {
        return modeleRepository.findAll();
    }
*/
   /* public String getModele() {
        return modele;
    }*/
/*
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

}
*/