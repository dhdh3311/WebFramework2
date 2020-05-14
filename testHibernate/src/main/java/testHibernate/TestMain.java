package testHibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

public class TestMain {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

//		Configuration conf = new Configuration();
//		conf.configure("hibernate.cfg.xml");
//		sessionFactory = conf.buildSessionFactory();
		
		Serializable id;

		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Category category1 = new Category() ;
		category1.setName("검퓨터");

		Category category2 = new Category() ;
		category2.setName("자동차");

		
		Product product1 = new Product();
		product1.setName("notebook1");
		product1.setPrice(2000);
		product1.setDescription("Awesome notebook1!!!");
		product1.setCategory(category1);
		
		Product product2 = new Product();
		product2.setName("notebook2");
		product2.setPrice(20000);
		product2.setDescription("Awesome notebook2!!!");
		product2.setCategory(category2);
		
		Product product3 = new Product();
		product3.setName("sonata");
		product3.setPrice(20000);
		product3.setDescription("Popular Car!!!");
		product3.setCategory(category2);

		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction();

			session.save(product1); // instead of sql statement
			session.save(product2); // instead of sql statement
			session.save(product3); // instead of sql statement
			
			product1.setCategory(null);
			session.delete(product1); // product3 -> category2

			
			tx.commit();
		} catch (Exception exc) {
			exc.printStackTrace();

		} finally {
			
			session.close();
			sessionFactory.close();
		}

	}

}
