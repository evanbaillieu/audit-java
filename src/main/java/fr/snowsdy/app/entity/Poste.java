package fr.snowsdy.app.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Poste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fonction;
    private String activite;
    private String emplacement;

    public Poste() {
    }

    public Poste(String fonction, String activite, String emplacement) {
        this.fonction = fonction;
        this.activite = activite;
        this.emplacement = emplacement;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.fonction);
        hash = 29 * hash + Objects.hashCode(this.activite);
        hash = 29 * hash + Objects.hashCode(this.emplacement);
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
        final Poste other = (Poste) obj;
        if (!Objects.equals(this.fonction, other.fonction)) {
            return false;
        }
        if (!Objects.equals(this.activite, other.activite)) {
            return false;
        }
        if (!Objects.equals(this.emplacement, other.emplacement)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Poste{" + "fonction=" + fonction + ", activitÃ©=" + activite + ", emplacement=" + emplacement + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

}
