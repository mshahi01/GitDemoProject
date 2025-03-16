package Tutorial.example.MyApp.Controllers;

import Tutorial.example.MyApp.DTO.EmployeeDTO;
import Tutorial.example.MyApp.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/oddOrEven/{number}")
    public String oddOrEven(@PathVariable int number) {
        return (number % 2 == 0) ? "even" : "odd";
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeesById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    /**
     * This method creates a new employee
     * @param employeeDTO
     * @return
     */
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createNewEmployee(employeeDTO);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * This method deletes an employee by id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id) {
        return employeeService.deleteEmployeeById(id);
    }
}