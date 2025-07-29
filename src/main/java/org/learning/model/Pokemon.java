package org.learning.model;

import jakarta.persistence.*;
//import org.hibernate.boot.model.naming.Identifier;

@Entity
@Table(name="pokemons")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String type;
    private boolean isTamed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", isTamed=" + isTamed +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isTamed(Boolean isTamed) {
        return this.isTamed;
    }

    public void setTamed(boolean tamed) {
        isTamed = tamed;
    }
}
