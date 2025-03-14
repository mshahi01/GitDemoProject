package Tutorial.example.MyApp.Controllers;


import Tutorial.example.MyApp.DTO.EmployeeDTO;
import Tutorial.example.MyApp.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//This is the chnage

@RestController
@RequestMapping(path= "/employees")
@ComponentScan(basePackages = "Tutorial.example.MyApp*")
@EnableJpaRepositories(basePackages = "Tutorial.example.MyApp.Reposotories")
@EntityScan(basePackages = "Tutorial.example.MyApp.Entities")
public class EmployeeController {

   @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path= "/{id}")
    public EmployeeDTO getEmployeesById(@PathVariable("id") long employeeId)
    {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        return employeeService.createNewEmployee(employeeDTO);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id)
    {
        return employeeService.deleteEmployeeById(id);

    }


}
