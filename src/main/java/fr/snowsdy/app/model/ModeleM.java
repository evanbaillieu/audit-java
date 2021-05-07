package fr.snowsdy.app.model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.Objects;
/**
 *
 * @author bob
 */
public class ModeleM {
    private long id;
    private String type;
    private int niveau;
    private List<SectionM> sections;
    
    public ModeleM(long id, String type, int niveau, List<SectionM> sections) {
        this.id = id;
        this.type = type;
        this.niveau = niveau;
        this.sections = sections;
    }
    
    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getNiveau() {
        return niveau;
    }

    public List<SectionM> getSections() {
        return sections;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setSections(List<SectionM> sections) {
        this.sections = sections;
    }
    
    public void addSections(SectionM s){
        this.sections.add(s);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.type);
        hash = 67 * hash + this.niveau;
        hash = 67 * hash + Objects.hashCode(this.sections);
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
        final ModeleM other = (ModeleM) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.niveau != other.niveau) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.sections, other.sections)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModeleM{" + "id=" + id + ", type=" + type + ", niveau=" + niveau + ", sections=" + sections + '}';
    }
    
    
    
    
    
    
    
}
