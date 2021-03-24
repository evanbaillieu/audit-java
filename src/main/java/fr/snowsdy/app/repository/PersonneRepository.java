package fr.snowsdy.app.repository;

import fr.snowsdy.app.entity.Personne;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("personneRepository")
public interface PersonneRepository extends CrudRepository<Personne, Long> {

    default String testOk(){
        return "Repository ok!";
    }
}
