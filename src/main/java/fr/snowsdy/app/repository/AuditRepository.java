package fr.snowsdy.app.repository;

import fr.snowsdy.app.model.AuditM;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("auditRepository")
public interface AuditRepository extends CrudRepository<AuditM, Long> {

    default String testOk(){
        return "Repository ok!";
    }
}
