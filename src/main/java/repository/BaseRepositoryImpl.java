package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.SessionManager;

import java.util.Optional;

public class BaseRepositoryImpl<T, ID> implements BaseRepository<T, ID> {
    private Class<T> clazz;

    public BaseRepositoryImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Because we do only a simple read here is no need of transactions
     */
    @Override
    public Optional<T> findById(ID id) {
        Session session = SessionManager.getSessionFactory().openSession();
        T entity = session.find(clazz, id);
        return Optional.ofNullable(entity);
    }

    /**
     * When we modify anything we must make use of transactions
     */
    @Override
    public void save(T entity) {
        Transaction transaction = null;
        try {
            Session session = SessionManager.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            session.save(entity);

            transaction.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void update(T entity) {
        Transaction transaction = null;
        try {
            Session session = SessionManager.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            session.update(entity);

            transaction.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(T entity) {
        Transaction transaction = null;
        try {
            Session session = SessionManager.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            session.delete(entity);

            transaction.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}