package org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Model;

import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.entity.Employee;

public class DeleteEmployeeResponseModel {

	private int id;
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
	public DeleteEmployeeResponseModel(int id, int status) {
		super();
		this.id = id;
		this.status = status;
	}
	public Employee postEmployee(DeleteEmployeeResponseModel emp) {
		return null;
	}
	
	
	
	
}
