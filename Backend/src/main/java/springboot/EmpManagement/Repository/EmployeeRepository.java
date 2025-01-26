package springboot.EmpManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.EmpManagement.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
