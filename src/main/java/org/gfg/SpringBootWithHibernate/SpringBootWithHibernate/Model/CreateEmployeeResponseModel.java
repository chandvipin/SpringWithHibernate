package org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Model;

import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.entity.Employee;

public class CreateEmployeeResponseModel {

	private int id;
	private String firstname;
	private String lastname;
	private int status;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return "CreateEmployeeResponseModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", status=" + status + "]";
	}
	public CreateEmployeeResponseModel(int id, String firstname, String lastname,int status) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.status = status;
	}
	
	
	public Employee postEmployee(CreateEmployeeResponseModel emp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
