package test;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by bluesky on 16-3-14.
 */
public class HibernateCacheTest {


    public static void main(String args[]) {
        SessionFactory sessionFactory = null;
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry =
                new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        User user1 = (User)session.get(User.class,4);

        System.out.println(user1.toString());

        session.close();
        session = sessionFactory.openSession();

        User user2 = (User)session.get(User.class,4);

        System.out.println(user2.toString());

        session.close();
        sessionFactory.close();


    }
}