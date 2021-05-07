package fr.snowsdy.app.service;

import fr.snowsdy.app.entity.Agent;
import fr.snowsdy.app.entity.Auditeur;
import fr.snowsdy.app.entity.Poste;
import fr.snowsdy.app.model.AuditM;
import fr.snowsdy.app.model.ModeleM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RestController
public class AuditService implements Serializable {

    @Autowired
    AuditServiceImpl auditServiceImpl;

    public AuditService() {
    }

    @GetMapping("/auditid")
    public Optional<AuditM> getById(@RequestParam(value = "id",defaultValue = "0")  Optional<Long> id){
        return auditServiceImpl.getById(id);
}

    @GetMapping("/auditadd")
    public AuditM getAudit(@RequestParam("agend") Agent agent,
                            @RequestParam("poste") Poste poste,
                            @RequestParam("auditeurs") List<Auditeur> auditeurs,
                            @RequestParam("date") Date date,
                            @RequestParam("modele") ModeleM modeleM,
                            @RequestParam("title") String title) {
        return AuditServiceImpl.save(new AuditM(agent, poste, auditeurs,date, modeleM, title));
    }

    public void deleteById(int id){
        // TODO HERE:
    }

    @GetMapping("/Auditeall")
    public @ResponseBody
    Iterable<AuditM> getAllAudit(){
        return auditServiceImpl.getAll();
    }

    @GetMapping("/Audittest")
    public String test(){
        return auditServiceImpl.test();
    }

    public AuditServiceImpl getAuditServiceImpl() {
        return auditServiceImpl;
    }

    public void setAuditServiceImpl(AuditServiceImpl auditServiceImpl) {
        this.auditServiceImpl = auditServiceImpl;
    }


}
