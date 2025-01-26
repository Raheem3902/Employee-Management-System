package springboot.EmpManagement.Service.impl;

import org.springframework.stereotype.Service;
import springboot.EmpManagement.Entity.Employee;
import springboot.EmpManagement.Mapper.EmployeeMapper;
import springboot.EmpManagement.Repository.EmployeeRepository;
import springboot.EmpManagement.Service.EmployeeService;
import springboot.EmpManagement.dto.EmployeeDto;
import springboot.EmpManagement.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Constructor injection for EmployeeRepository
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : "+ employeeId));
        return EmployeeMapper.maptoEmployeeDto(employee);

    }


    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.maptoEmployeeDto(employee))
                .collect(Collectors.toList());
    }



    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee= employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id:" + employeeId)
                );

                employee.setFirstName(updatedEmployee.getFirstName());
                employee.setLastName(updatedEmployee.getLastName());
                employee.setEmail(updatedEmployee.getEmail());

                Employee updatedEmployeeObj =employeeRepository.save(employee);

                return EmployeeMapper.maptoEmployeeDto(updatedEmployeeObj);




}

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : "+ employeeId));

        employeeRepository.deleteById(employeeId);
    }
}