package evolution;  

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  

public class Application {  
	public static void main(String[] args) {  
		// Create configuration.  
		Configuration configuration = new Configuration();  
		// Populate the configuration file.
		// Put all the configuration files under resources folder. Do not put it under java folder.
		configuration.configure("hibernate.cfg.xml");  
		// Create session factory.  
		SessionFactory sessionFactory = configuration.buildSessionFactory();  
		// Create session.
		Session session = sessionFactory.openSession();  
		// Creating transaction.
		Transaction transaction = session.beginTransaction();
		Employee employee = new Employee();  
		employee.setId(3);  
		employee.setFirstName("Donald");  
		employee.setLastName("Trump");  
		session.persist(employee);// Persist the employee object.
		// Commit the transaction.
		// You don't need to create a table because hibernate will take care of that.
		transaction.commit(); 
		session.close();  
		System.out.println("Success");  
	}  
}  