package fr.snowsdy.app.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "disc", discriminatorType = DiscriminatorType.STRING)
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;

    @Column(unique = true)
    private String login;
    private String password;

    public Personne() {
    }

    public Personne(String nom, String prenom, String login, String password) throws NoSuchAlgorithmException {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        //this.password = this.codeMD5(password);
//        this.password = password;
        this.password = toHexString(getSHA(password));
    }

    public Personne(String name, String prename, String login, String mdp, int poste) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException {
        this.password = toHexString(getSHA(password));
    }

    //    public void setEncodedMdp(String password) throws NoSuchAlgorithmException {
//        this.password = password;
//    }
    public void setLogin(String login) {
        this.login = login;
    }

    /*private String codeMD5(String msg) throws NoSuchAlgorithmException {
     String code = "";
     byte[] b;
     MessageDigest md;
     try {
     md = MessageDigest.getInstance("MD5");
     b = md.digest(msg.getBytes());
     for (int i = 0; i < b.length; i++) {
     int x = b[i];

     if (x < 0) {
     x += 256;
     }

     String s = String.format("%02x", x);
     code += s;
     }
     } catch (NoSuchAlgorithmException ex) {
     System.out.println(ex.getMessage());
     }

     return code;
     }*/
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);

        StringBuilder hexString = new StringBuilder(number.toString(16));

        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    public boolean isValid(String pswrd) throws NoSuchAlgorithmException {
        return this.password.equals(toHexString(getSHA(pswrd)));
    }

    /*public String getPassword() {
     return password;
     }

     public void setPassword(String pswrd) throws NoSuchAlgorithmException {
     this.password = this.codeMD5(pswrd);
     }

     public void setEncodedMdp(String pswrd) throws NoSuchAlgorithmException {
     this.password = pswrd;
     }*/
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 59 * hash + Objects.hashCode(this.nom);
        hash = 59 * hash + Objects.hashCode(this.prenom);
        hash = 59 * hash + Objects.hashCode(this.login);
        hash = 59 * hash + Objects.hashCode(this.password);
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
        final Personne other = (Personne) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password + '}';
    }

    @Repository
    public interface PersonneRepository extends JpaRepository<Personne, Long> {
    Optional<Personne> findByPrenom(String prenom);
        Boolean existsByPrenom(String prenom);
    }
}
