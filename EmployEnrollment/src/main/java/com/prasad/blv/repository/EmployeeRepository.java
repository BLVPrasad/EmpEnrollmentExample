package  com.prasad.blv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prasad.blv.model.Employee;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query("select e from Employee e where e.userName = :userName")
	Employee findByUserName(@Param("userName") String userName);
	
}
