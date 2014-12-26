package  com.prasad.blv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prasad.blv.model.Employee;
import com.prasad.blv.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public boolean findByLogin(String userName, String password) {	
		Employee emp = employeeRepository.findByUserName(userName);
		
		if(emp != null && emp.getPassword().equals(password)) {
			return true;
		} 
		
		return false;		
	}

	public boolean findByUserName(String userName) {
		Employee emp = employeeRepository.findByUserName(userName);
		
		if(emp != null) {
			return true;
		}
		
		return false;
	}
	
	public List<Employee> listEmployees(){
		
		List<Employee> list = employeeRepository.findAll();
		
		for(Employee emp: list){
			
			System.out.println("emp Id"+emp.getId() +"\t"+"User Name"+emp.getUserName() +"\t"+ "FirstName"+emp.getFirstName() +"\t"+"Email"+emp.getEmailAddress() +"\t");
		}
		
		return list;
	}
	

}
