package fr.snowsdy.app.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Champ implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String nom;
    private int nbValeurs;
    private int type; // 0 =String , 1=images

    public Champ() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNbValeurs() {
        return nbValeurs;
    }

    public void setNbValeurs(int nbValeurs) {
        this.nbValeurs = nbValeurs;
    }

    public Champ(String nom, int nbValeurs, int type) {
        this.nom = nom;
        this.nbValeurs = nbValeurs;
        this.type = type;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.nom);
        hash = 53 * hash + this.nbValeurs;
        hash = 53 * hash + this.type;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Champ other = (Champ) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (this.nbValeurs != other.nbValeurs) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Champ{" + "id=" + id + ", nom=" + nom + ", nbValeurs=" + nbValeurs + ", type=" + type + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
