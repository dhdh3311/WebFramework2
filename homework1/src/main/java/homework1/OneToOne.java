package homework1;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOne {

	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		
		Serializable id;

		sessionFactory = new Configuration().configure().buildSessionFactory();

		Person person1 = new Person();
		person1.setFirstName("Alice");
		person1.setLastName("Lee");
		
		License license1 = new License();
		license1.setLicenseNumber("123456");
		license1.setIssueDate(new Date());
		license1.setPerson(person1);
		
		person1.setLicense(license1);
		
		Session session = sessionFactory.openSession();
		
		Serializable lisId = 0;
		
		try {
			Transaction tx = session.beginTransaction();

			lisId = session.save(person1); // instead of sql statement
			
			tx.commit();
			
		} catch (Exception exc) {
			exc.printStackTrace();

		} finally {
			
			session.close();
			
		}
		
//		Session session1 = sessionFactory.openSession();
//		Transaction tx1 = session1.beginTransaction();
//		
//		Person aPerson = session1.get(Person.class, lisId);
//	
//		tx1.commit();
//		session1.close();
//			
		
		
		sessionFactory.close();
	}

}
