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
		//person1.setLicense(license1);
		
		License license1 = new License();
		license1.setLicenseNumber("123456");
		license1.setIssueDate(new Date());
		license1.setPerson(person1);
		
		Session session = sessionFactory.openSession();
		
		try {
			Transaction tx = session.beginTransaction();

			session.save(license1); // instead of sql statement
			license1.setPerson(null);
			
			tx.commit();
		} catch (Exception exc) {
			exc.printStackTrace();

		} finally {
			
			session.close();
			sessionFactory.close();
		}
		
	}

}
