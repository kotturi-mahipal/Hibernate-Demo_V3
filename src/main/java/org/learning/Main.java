package org.learning;

import org.learning.model.Pokemon;

public class Main {
    public static void main(String[] args) {
        PokemonDao pokemonDao = new PokemonDao();
        Pokemon p1 = new Pokemon();

//        p1.setId(7);
        p1.setName("Probopass");
        p1.setType("Rocky");
        p1.setTamed(false);

        Pokemon p2 = new Pokemon();

        p1.setName("");
        p2.setTamed(true);
        p2.setType("Rock");

//        userDao.savePokemon(p1);
        System.out.println("User saved successfully!");
//        System.out.println(userDao.getPokemon(3));
        pokemonDao.updatePokemon(3, null, null, true);

        HibernateUtil.shutdown(); // Optional: close EntityManagerFactory

//        System.out.println(p1.toString());
    }
}