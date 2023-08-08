package org.module_10.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.module_10.entity.Client;
import org.module_10.util.HibernateUtil;

public class ClientCrudService {
    public long create(Client client) {
        Transaction transaction = null;
        try (Session session = HibernateUtil
                .getInstance()
                .getSessionFactory()
                .openSession()) {
            transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return client.getId();
    }

    public Client getById(long id) {
        try (Session session = HibernateUtil
                .getInstance()
                .getSessionFactory()
                .openSession()) {
            Query<Client> query = session.createQuery("from Client where id = :id", Client.class);
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
            Client client = session.get(Client.class, id);
            if (client != null) {
                session.remove(client);
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
