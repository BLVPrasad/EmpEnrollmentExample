package  com.prasad.blv.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.prasad.blv.model.Employee;
import com.prasad.blv.model.EmployeeLogin;
import com.prasad.blv.service.EmployeeService;


@Controller
@SessionAttributes("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
		
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model) {
		Employee employee = new Employee();		
		model.addAttribute("employee", employee);		
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, Model model) {		
		if(result.hasErrors()) {
			return "signup";
		} else if(employeeService.findByUserName(employee.getUserName())) {
			model.addAttribute("message", "User Name already exists. Try another user name");
			return "signup";
		} else {
			employeeService.save(employee);
			model.addAttribute("message", "Saved employee details");
			return "redirect:login.html";
		}
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {			
		EmployeeLogin employeeLogin = new EmployeeLogin();		
		model.addAttribute("employeeLogin", employeeLogin);
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("employeeLogin") EmployeeLogin employeeLogin, BindingResult result) {
		if (result.hasErrors()) {
			return "login";
		} else {
			boolean found = employeeService.findByLogin(employeeLogin.getUserName(), employeeLogin.getPassword());
			if (found) {				
				return "redirect:all.html";
			} else {				
				return "failure";
			}
		}
		
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String getEmployees(Model model) {	
			System.out.println("=========== getEmployees ()     ==============");
			employeeService.listEmployees();
			model.addAttribute("emps", employeeService.listEmployees());
			return "empList";
	}
	
	
}
