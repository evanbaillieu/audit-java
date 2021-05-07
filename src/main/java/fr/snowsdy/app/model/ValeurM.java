/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.snowsdy.app.model;

import java.util.Objects;

/**
 *
 * @author evanbaillieu
 */
public class ValeurM {
    private long id;
    private String valeur;
    private int type;

    public ValeurM(long id, String valeur, int type) {
        this.id = id;
        this.valeur = valeur;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 13 * hash + Objects.hashCode(this.valeur);
        hash = 13 * hash + this.type;
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
        final ValeurM other = (ValeurM) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.valeur, other.valeur)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValeurM{" + "id=" + id + ", valeur=" + valeur + ", type=" + type + '}';
    }
    
    
    
}
