package org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Controller;

import java.util.List;

import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Model.CreateEmployeeRequestModel;
import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Model.CreateEmployeeResponseModel;
import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Model.DeleteEmployeeResponseModel;
import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Model.GetEmployeeResponseModel;
import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Model.UpdateEmployeeRequestModel;
import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Model.UpdateEmployeeResponseModel;
import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.Service.EmployeeService;
import org.gfg.SpringBootWithHibernate.SpringBootWithHibernate.entity.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmloyeeController {

	EmployeeService empservice = null;

	public EmloyeeController() {
		// TODO Auto-generated constructor stub
		empservice = new EmployeeService();
	}

	@RequestMapping("/test")
	public String TestAPI() {
		return "Hello world !..";
	}

	@RequestMapping("/get/all")
	public List<Employee> getAllEmployees() {
		return empservice.getAllEmployees();
	}

	
	@RequestMapping("/get/{id}")
	public GetEmployeeResponseModel getAllEmployeesUsingId(@PathVariable int id) {
		return empservice.getAllEmployeesUsingId(id);
	}

	
	@RequestMapping("/post")
	public CreateEmployeeResponseModel postEmployee(@RequestBody CreateEmployeeRequestModel emp) {
		return  empservice.postEmployee(emp);
	}
	

	@RequestMapping("/post/{id}")
	public UpdateEmployeeResponseModel updateEmployee(@RequestBody UpdateEmployeeRequestModel emp, @PathVariable int id) {
		return  empservice.updateEmployee(emp, id);
	}


	@RequestMapping("/delete/{id}")
	public DeleteEmployeeResponseModel deleteEmployee(@PathVariable int id) {
		return  empservice.deleteEmployee(id);
	}

	
	
	
	
}
