package org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Model;

import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.entity.Employee;

public class UpdateEmployeeRequestModel {

    private String firstname;
    private String lastname;
    
	public UpdateEmployeeRequestModel(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public UpdateEmployeeRequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFirstname() {
		// TODO Auto-generated method stub
		return firstname;
	}

	public String getLastname() {
		// TODO Auto-generated method stub
		return lastname;
	}

	 
    
    
	
	
}
