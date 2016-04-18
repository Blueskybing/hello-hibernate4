package test;

/**
 * Created by bluesky on 16-3-14.
 */

import net.sf.ehcache.CacheManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author Michael
 * @blog http://sjsky.iteye.com
 */
public class TestEhcacheHibernate {

    /**
     * @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        testMulitConfigMethod();
    }

    /**
     * 测试多种配置缓存的方法
     */
    public static void testMulitConfigMethod() {
        SessionFactory sessionFactory = null;
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry =
                new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String[] cacheNames = CacheManager.getInstance().getCacheNames();
        System.out.println("缓存的key cacheNames length := "
                + cacheNames.length + " 具体详细列表如下：");
        for (String name : cacheNames) {
            System.out.println("name := " + name);
        }

        System.out.println("ehcache - hibernate Test end.");
    }
}
