package org.learning;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import org.hibernate.Transaction;
import org.learning.model.Pokemon;

public class PokemonDao {
    @Transactional
    public void savePokemon(Pokemon pokemon) {
        EntityManager em = HibernateUtil.getEmf().createEntityManager();

        em.persist(pokemon);
//        EntityTransaction tx = null;
//        try (em) {
//            tx = em.getTransaction();
//            tx.begin();
//            em.persist(pokemon);
//            tx.commit();
//        } catch (Exception e) {
//            if (tx.isActive()) tx.rollback();
//            e.printStackTrace();
//        }
    }

    @Transactional
    public Pokemon getPokemon(long pokeId) {
        EntityManager em = HibernateUtil.getEmf().createEntityManager();
        return em.find(Pokemon.class, pokeId);

//        try (em) {
//            Pokemon pm = em.find(Pokemon.class, pokeId);
//            return pm;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

    }

    @Transactional
    public void updatePokemon(long pokeId, String newName, String newType, Boolean isTamed) {
        EntityManager em = HibernateUtil.getEmf().createEntityManager();
//        EntityTransaction tx = null;

        Pokemon existingPokemon = em.find(Pokemon.class, pokeId);

        if(existingPokemon == null) {
            throw new IllegalArgumentException("Pokemon with ID " + pokeId + " was not found");
        }

        if (newName != null) {
            existingPokemon.setName(newName);
        }

        if (newType != null) {
            existingPokemon.setType(newType);
        }

        if (isTamed != null) {
            existingPokemon.isTamed(isTamed);
        }

        em.merge(existingPokemon);

//        try (em) {
//            tx = em.getTransaction();
//            tx.begin();
//
//            Pokemon existingPokemon = em.find(Pokemon.class, pokeId);
//
//            if(existingPokemon == null) {
//                throw new IllegalArgumentException("Pokemon with ID " + pokeId + " was not found");
//            }
//
//            if (newName != null) {
//                existingPokemon.setName(newName);
//            }
//
//            if (newType != null) {
//                existingPokemon.setType(newType);
//            }
//
//            if (isTamed != null) {
//                existingPokemon.isTamed(isTamed);
//            }
//
//            em.merge(existingPokemon);
//            tx.commit();
//        } catch (Exception e) {
//
//            if (tx != null && tx.isActive()) tx.rollback();
//            e.printStackTrace();
//        }
    }
}
