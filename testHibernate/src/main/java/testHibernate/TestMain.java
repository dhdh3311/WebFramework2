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

		Product product = new Product();
		product.setName("notebook2");
		product.setPrice(2000);
		product.setDescription("Awesome notebook2!!!");
		
		Product product2 = new Product();
		product2.setName("notebook1");
		product2.setPrice(20000);
		product2.setDescription("Awesome notebook1!!!");

		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction();

			session.save(product); // instead of sql statement
			session.save(product2); // instead of sql statement

			
			/*
			 * Product savedProduct = session.get(Product.class, id);
			 * System.out.println(savedProduct);
			 */

			Query<Product> theQuery = session.createQuery("from Product", Product.class); // HQL
			List<Product> products = theQuery.getResultList();
			System.out.println(products);
			
			tx.commit();

		} catch (Exception exc) {
			exc.printStackTrace();

		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
