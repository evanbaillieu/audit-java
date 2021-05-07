/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.snowsdy.app.model;

import fr.snowsdy.app.entity.Valeurs;

import java.util.Objects;

/**
 *
 * @author evanbaillieu
 */
public class ChampM {

    private long id;
    private String nom;
    private ValeurM valeurs;

    public ChampM(Valeurs v) {
        this.id = v.getChamp().getId();
        this.nom = v.getChamp().getNom();
        this.valeurs.setId(v.getId());
        this.valeurs.setType(v.getType());
        this.valeurs.setValeur(v.getValeur());
    }

    public ChampM() {
    }

    public ChampM(long id, String nom, ValeurM valeurs) {
        this.id = id;
        this.nom = nom;
        this.valeurs = valeurs;
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

    public ValeurM getValeurs() {
        return valeurs;
    }

    public void setValeurs(ValeurM valeurs) {
        this.valeurs = valeurs;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 13 * hash + Objects.hashCode(this.nom);
        hash = 13 * hash + Objects.hashCode(this.valeurs);
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
        final ChampM other = (ChampM) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.valeurs, other.valeurs)) {
            return false;
        }
        return true;
    }

}
