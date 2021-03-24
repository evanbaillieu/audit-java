package fr.snowsdy.app.entity;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Auditeur")
public class Auditeur extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;

    public Auditeur() {
    }

    public Auditeur(String nom, String prenom, String login, String password) throws NoSuchAlgorithmException {
        super(nom, prenom, login, password);

    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + super.getId() + ", nom=" + this.getNom() + ", prenom=" + this.getNom() + '}';
    }

}
