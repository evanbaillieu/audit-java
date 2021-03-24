package fr.snowsdy.app.entity;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author abyss
 * @modif Kev,Flo
 */
@Entity
@DiscriminatorValue("Agent")
public class Agent extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @OneToOne
    private Poste poste;

    public Agent() throws NoSuchAlgorithmException {
        super("", "", "", "");
        this.poste = null;
    }

    public Agent(String nom, String prenom, String login, String password, Poste poste) throws NoSuchAlgorithmException {
        super(nom, prenom, login, password);
        this.poste = poste;

    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.poste);
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
        final Agent other = (Agent) obj;
        if (!Objects.equals(this.poste, other.poste)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Agent{" + "poste=" + poste + '}';
    }

}
