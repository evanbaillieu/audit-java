package fr.snowsdy.app.entity;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Section implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private int type; //0= strings , 1 = tableau, 2= image

    private int position;

    @ElementCollection
    @OneToMany(orphanRemoval = true)
    private List<Champ> champs;

    @ElementCollection
    private List<String> entetes;
    private int nbChampsParLigne;

    @OneToOne
    private Image image;

    public Section() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNbChampsParLigne() {
        return nbChampsParLigne;
    }

    public void setNbChampsParLigne(int nbChampsParLigne) {
        this.nbChampsParLigne = nbChampsParLigne;
    }

    public Section(String nom, int type, int position) {
        this.nom = nom;
        this.type = type;
        this.position = position;
    }

    public Section(String nom, int type, List<Champ> champs, List<String> entetes, int nbChampsParLigne, Image image, int position) {
        this.nom = nom;
        this.type = type;
        this.position = position;
        this.champs = champs;
        this.entetes = entetes;
        this.nbChampsParLigne = nbChampsParLigne;
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Champ> getChamps() {
        return champs;
    }

    public void addChamp(Champ champ) {
        this.champs.add(champ);

    }

    public void setChamps(List<Champ> champs) {
        this.champs = champs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nom);
        hash = 67 * hash + this.type;
        hash = 67 * hash + Objects.hashCode(this.champs);
        hash = 67 * hash + this.nbChampsParLigne;
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
        final Section other = (Section) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.champs, other.champs)) {
            return false;
        }
        if (this.nbChampsParLigne != other.nbChampsParLigne) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Section{" + "id=" + id + ", nom=" + nom + ", type=" + type + ", champs=" + champs + ", nbChampsParLigne=" + nbChampsParLigne + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<String> getEntetes() {
        return entetes;
    }

    public void setEntetes(List<String> entetes) {
        this.entetes = entetes;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
