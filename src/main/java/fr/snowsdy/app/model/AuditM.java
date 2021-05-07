/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.snowsdy.app.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import fr.snowsdy.app.entity.Agent;
import fr.snowsdy.app.entity.Audit;
import fr.snowsdy.app.entity.Auditeur;
import fr.snowsdy.app.entity.Champ;
import fr.snowsdy.app.entity.Modele;
import fr.snowsdy.app.entity.Poste;
import fr.snowsdy.app.entity.Section;
import fr.snowsdy.app.entity.Valeurs;

/**
 *
 * @author bob
 */
public class AuditM {
    
    private long id;
    private Agent agent;
    private Poste poste;
    private List<Auditeur> auditeurs;
    private Date date;
    private ModeleM modele;
    private String title;

    public void parsedto(Audit a){
        this.id = a.getId();
        this.agent = a.getAgent();
        this.poste = a.getPoste();
        this.auditeurs = a.getAuditeurs();
        this.date = a.getDate();
        this.modele.setId(a.getModele().getId());
        this.modele.setNiveau(a.getModele().getNiveau());
        this.modele.setType(a.getModele().getType());
        a.getModele().getSections().forEach((s) -> {
            SectionM se = new SectionM(s);
            int i = 0;
            if (se.getChamps() == null) {
                for(Champ c: s.getChamps()){
                    i = 0;
                    for(Valeurs v: a.getValeurs()){
                        if(c.equals(v.getChamp())){
                            ChampM ch = new ChampM(v);
                            se.addChamps(ch);
                            i++;
                        }
                    }
                    if(i == 0){
                        ChampM champ = new ChampM();
                        ValeurM val = new ValeurM(0,"n'a pas ete presicer", 0);
                        champ.setId(c.getId());
                        champ.setNom(c.getNom());
                        champ.setValeurs(val);
                        se.addChamps(champ);
                    }
                }
            }
            this.modele.addSections(se);
        }); 
    }

    
    public AuditM(long id, Agent agent, Poste poste, List<Auditeur> auditeurs, Date date, ModeleM modele, String title) {
        this.id = id;
        this.agent = agent;
        this.poste = poste;
        this.auditeurs = auditeurs;
        this.date = date;
        this.modele = modele;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public List<Auditeur> getAuditeurs() {
        return auditeurs;
    }

    public void setAuditeurs(List<Auditeur> auditeurs) {
        this.auditeurs = auditeurs;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ModeleM getModele() {
        return modele;
    }

    public void setModele(ModeleM modele) {
        this.modele = modele;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Audit getAudit(){
        Audit a = new Audit();
        a.setDate(this.date);
        a.setId(this.id);
        a.setPoste(this.poste);
        a.setAgent(this.agent);
        a.setTitre(this.title);
        
        return a;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.agent);
        hash = 29 * hash + Objects.hashCode(this.poste);
        hash = 29 * hash + Objects.hashCode(this.auditeurs);
        hash = 29 * hash + Objects.hashCode(this.date);
        hash = 29 * hash + Objects.hashCode(this.modele);
        hash = 29 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AuditM other = (AuditM) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.agent, other.agent)) {
            return false;
        }
        if (!Objects.equals(this.poste, other.poste)) {
            return false;
        }
        if (!Objects.equals(this.auditeurs, other.auditeurs)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return Objects.equals(this.modele, other.modele);
    }

    @Override
    public String toString() {
        return "AuditM{" + "id=" + id + ", agent=" + agent + ", poste=" + poste + ", auditeurs=" + auditeurs + ", date=" + date + ", modele=" + modele + ", title=" + title + '}';
    }
    
    public Audit toAudit(){
           Audit a = new Audit();
           a.setAgent(this.agent);
           a.setAuditeurs(this.auditeurs);
           a.setDate(this.date);
           a.setPoste(this.poste);
           a.setTitre(this.title);
           Modele m = new Modele();
           m.setId(this.modele.getId());
           m.setNiveau(this.modele.getNiveau());
           m.setObsolete(false);
           m.setType(this.modele.getType());
           List<Section> s = null;
           List<Valeurs> v = null;
           for(SectionM sec: this.modele.getSections()){
              Section se = new Section();
              se.setId(sec.getId());
              se.setImage(sec.getImage());
              se.setNom(sec.getNom());
              se.setType(sec.getType());
              List<Champ> ch = null;
              for(ChampM champ: sec.getChamps()){
                  Champ c = new Champ();
                  Valeurs val = new Valeurs();
                  c.setId(champ.getId());
                  c.setNom(champ.getNom());
                  c.setType(champ.getValeurs().getType());
                  val.setId(champ.getValeurs().getId());
                  val.setType(champ.getValeurs().getType());
                  val.setValeur(champ.getValeurs().getValeur());
                  val.setChamp(c);
                  v.add(val);
                  ch.add(c);
              }
              se.setChamps(ch);
              s.add(se);
            }
           m.setSections(s);
           a.setValeurs(v);
           a.setModele(m);
           return a;
    } 
}
