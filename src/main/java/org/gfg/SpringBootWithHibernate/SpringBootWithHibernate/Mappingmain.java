package org.gfg.SpringBootWithHibernate.SpringBootWithHibernate;
import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mappingmain {

	public static void main(String[] args) {
		
		Configuration c = new Configuration();
		SessionFactory factory = c.configure("hbm.cfg.xml").buildSessionFactory();
//		
//		Employee emp =  new Employee("vipin", "chand");
//		Employee emp1 = new Employee("Jaspal", "ramola");
//		Employee emp2 = new Employee("hitesh","chand");
		Session session = factory.openSession();
		Transaction tx;
		try {
			tx = session.beginTransaction();			
			Employee emp = new Employee();
            emp.setId(14);
			session.delete(emp);
			tx.commit();
			session.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  }
	}


