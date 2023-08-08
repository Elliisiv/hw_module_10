package org.module_10.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.module_10.entity.Planet;
import org.module_10.util.HibernateUtil;

public class PlanetCrudService {
    public String create(Planet planet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil
                .getInstance()
                .getSessionFactory()
                .openSession()) {
            transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return planet.getId();
    }
    public Planet getById(String id) {
        try (Session session = HibernateUtil
                .getInstance()
                .getSessionFactory()
                .openSession()) {
            Query<Planet> query = session.createQuery("from Planet where id = :id", Planet.class);
            query.setParameter("id", id);
            return query.stream().findFirst().orElse(null);

        }
    }

    public void deleteById(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil
                .getInstance()
                .getSessionFactory()
                .openSession()) {
            transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                session.remove(planet);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
