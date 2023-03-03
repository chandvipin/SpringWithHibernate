package org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Service;

import java.util.List;

import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Model.CreateEmployeeRequestModel;
import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Model.CreateEmployeeResponseModel;
import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Model.DeleteEmployeeResponseModel;
import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Model.GetEmployeeResponseModel;
import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Model.UpdateEmployeeRequestModel;
import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Model.UpdateEmployeeResponseModel;
import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class EmployeeService {

	Configuration config;
	SessionFactory factory;
	
	public EmployeeService() {
		config = new Configuration();
	    factory = config.configure("hbm.cfg.xml").buildSessionFactory();
	}
	
	
	public List<Employee> getAllEmployees() {
		Session session = factory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cqEmp = cb.createQuery(Employee.class);
		Root<Employee> rootEntry =cqEmp.from(Employee.class);
		CriteriaQuery<Employee> all = cqEmp.select(rootEntry);
		TypedQuery<Employee> allQuery = session.createQuery(all);
		return allQuery.getResultList();
	}
	
	
	
	public GetEmployeeResponseModel getAllEmployeesUsingId(int id) {
		Session session = factory.openSession();
		GetEmployeeResponseModel empModel = null;
		try {
			Employee emp = session.get(Employee.class,id);
			empModel = new  GetEmployeeResponseModel(emp.getId(),emp.getFirstname(),emp.getLastname(),200);
		}catch(Exception e) {
			e.printStackTrace();
			empModel = new  GetEmployeeResponseModel(500);
		}
		session.close();
		return empModel;
	}
	
	
	
	public CreateEmployeeResponseModel postEmployee(CreateEmployeeRequestModel emp) {
        Session session = factory.openSession();
        CreateEmployeeResponseModel response = null;
		Employee e1 = new Employee(emp.getFirstname(), emp.getLastname());
		Transaction tx;
		try {
			tx = session.beginTransaction();
			session.save(e1);
			tx.commit();
			if(e1!=null) {
				response = new CreateEmployeeResponseModel(e1.getId(), e1.getFirstname(), e1.getLastname(),200);
			}
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
			response = new CreateEmployeeResponseModel(0, emp.getFirstname(), emp.getLastname(),500);
		}
		return response;
	}
	
	
	
	public UpdateEmployeeResponseModel updateEmployee(UpdateEmployeeRequestModel emp,@PathVariable int id) {
		 Session session = factory.openSession();
		 UpdateEmployeeResponseModel response = null;
			Transaction tx;
			try {
				tx = session.beginTransaction();
				//Employee e2 = new Employee(emp.getFirstname(), emp.getLastname());
				Employee e2 = session.load(Employee.class, id);
				e2.setFirstname("honey");
				e2.setLastname("singh");
				session.save(e2);
				tx.commit();
				if(e2!=null) {
					response = new UpdateEmployeeResponseModel(e2.getId(), e2.getFirstname(), e2.getLastname(),200);
				}
				session.close();
			}catch (Exception e) {
				e.printStackTrace();
				response = new UpdateEmployeeResponseModel(0, emp.getFirstname(), emp.getLastname(),500);
			}
		return response;
	}
	
	

	public DeleteEmployeeResponseModel deleteEmployee(@PathVariable int id) {
		 Session session = factory.openSession();
		 DeleteEmployeeResponseModel response = null;
			Transaction tx;
			try {
				tx = session.beginTransaction();
				Employee emp = new Employee();
				emp.setId(id);
				session.delete(emp);
				response = new DeleteEmployeeResponseModel(id,200);
				tx.commit();
				session.close();
			}catch (Exception e) {
				e.printStackTrace();
				response = new DeleteEmployeeResponseModel(0,500);
			}
		return response;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
