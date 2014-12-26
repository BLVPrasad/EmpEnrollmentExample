package  com.prasad.blv.service;

import java.util.List;

import com.prasad.blv.model.Employee;



public interface EmployeeService {
	Employee save(Employee employee);
	boolean findByLogin(String userName, String password);
	boolean findByUserName(String userName);
	
	List<Employee> listEmployees();
	
}
