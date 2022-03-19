package repositorytest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.BaseRepository;
import utils.SessionManager;
import utilstest.SessionManagerTest;

import java.util.List;
import java.util.Optional;

public class BaseRepositoryImplTest<T, ID> implements BaseRepository<T, ID> {
    private Class<T> clazz;

    public BaseRepositoryImplTest(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Because we do only a simple read here is no need of transactions
     */
    @Override
    public Optional<T> findById(ID id) {
        Session session = SessionManagerTest.getSessionFactory().openSession();
        T entity = session.find(clazz, id);
        session.close();
        return Optional.ofNullable(entity);
    }

    @Override
    public List<T> findAll() {
        Session session = SessionManagerTest.getSessionFactory().openSession();
        List<T> entityList = session.createQuery("from " + clazz.getSimpleName(), clazz).list();
        session.close();

        return entityList;
    }

    @Override
    public List<T> findByName(String name) {
        Session session = SessionManagerTest.getSessionFactory().openSession();
        List<T> t = session.createQuery("from " + clazz.getSimpleName(), clazz).list();
        session.close();

        return t;
    }

    /**
     * When we modify anything we must make use of transactions
     */
    @Override
    public void save(T entity) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionManagerTest.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            session.save(entity);

            transaction.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(T entity) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionManagerTest.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            session.update(entity);

            transaction.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(T entity) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionManagerTest.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            session.delete(entity);

            transaction.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            if (session != null) {
                session.close();
            }
        }
    }
}