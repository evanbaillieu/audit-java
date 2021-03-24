package fr.snowsdy.app.entity;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Admin")
public class Administrateur extends Auditeur implements Serializable {

    private static final long serialVersionUID = 1L;

    public Administrateur() throws NoSuchAlgorithmException {
        super("", "", "", "");
    }

    public Administrateur(String nom, String prenom, String login, String password) throws NoSuchAlgorithmException {
        super(nom, prenom, login, password);
    }

}
