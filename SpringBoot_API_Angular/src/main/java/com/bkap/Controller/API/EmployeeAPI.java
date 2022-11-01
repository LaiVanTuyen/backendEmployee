package com.bkap.Controller.API;

import com.bkap.DTO.EmployeeDTO;
import com.bkap.Entity.EmployeeEntity;
import com.bkap.Exception.ResourceNotFoundException;
import com.bkap.Service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bkap.Config.AppConstants.ID;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeAPI {

    @Autowired
    private IEmployeeService employeeService;
    //get all employee
//    @GetMapping("/employees")
//    public Page<EmployeeEntity> getEmployeeList(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "3") int size){
//        Pageable paging = PageRequest.of(page, size);
//        return employeeService.findAll(paging);
//    }
    @GetMapping("/employees")
    public List<EmployeeEntity> getEmployee(){
        return  employeeService.fillAll();
    }
       //get employee by id
    @GetMapping("/employees/{id}")
    public EmployeeEntity getEmployee(@PathVariable Long id) {
        return employeeService.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee", ID, id));
    }
    //create employee
    @PostMapping("/employees")
//    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
//        return employeeReprsitory.save(employee);
//    }
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeDTO employee) {
        employeeService.save(employee);
        return ResponseEntity.ok(employee);
    }
    //update employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employee) {
        employeeService.update(id, employee);
        return ResponseEntity.ok(employee);
    }
    //delete employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        EmployeeEntity employee = employeeService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("employee", ID, id));
            employeeService.deleteById(id);
//        employeeReprsitory.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
