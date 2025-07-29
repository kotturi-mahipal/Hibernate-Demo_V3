package org.learning;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.learning.model.Pokemon;

public class HibernateUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void shutdown() {
        if (emf != null) emf.close();
    }
}



