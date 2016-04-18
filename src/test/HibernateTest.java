package test;


import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by bluesky on 16-3-14.
 */
public class HibernateTest {

    public static  void main(String args[]) {
        SessionFactory sessionFactory = null;
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry =
                new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User("huang2","123456");
        session.save(user);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
