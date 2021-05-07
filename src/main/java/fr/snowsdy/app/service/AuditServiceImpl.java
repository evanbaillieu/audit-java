package fr.snowsdy.app.service;

import fr.snowsdy.app.model.AuditM;
import fr.snowsdy.app.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service("auditService")
public class AuditServiceImpl extends AuditService {

    @Autowired
    AuditRepository auditRepository;

    Collection<? extends GrantedAuthority> authorities;

    public static AuditM save(AuditM a){
        return auditRepository.save(a);
    }
    public Optional<AuditM> getById(long id) {
        return auditRepository.findById(id);
    }

    public Iterable<AuditM> getAll() {
        return auditRepository.findAll();
    }




}