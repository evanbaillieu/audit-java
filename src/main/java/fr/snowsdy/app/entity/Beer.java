package fr.snowsdy.app.entity;

import java.io.Serializable;

/**
 * @author Snowsdy
 */
public class Beer implements Serializable {

    // Attributs :
    private String name;        // Nom de la bière
    private float price;         // Prix de la bière
    private boolean available;  // S'il elle est dispo

    public Beer() {
    }

    public Beer(String name, float price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    /**
     * @return le nom de la bière
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Set le nom de la bière
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return le prix de la bière
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price Set le prix de la bière
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return Retourne un booléen, si la bière est disponible ou non.
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available Set si la bière est dispo.
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Beer[" +
                "name= '" + name + '\'' +
                ", price= " + price +
                ", available= " + available +
                ']';
    }
}
