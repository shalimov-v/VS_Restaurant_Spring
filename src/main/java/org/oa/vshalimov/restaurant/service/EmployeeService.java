package org.oa.vshalimov.restaurant.service;

import org.oa.vshalimov.restaurant.model.Employee;
import org.oa.vshalimov.restaurant.model.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/employees")
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody List<Employee> loadAll() {
        return employeeRepository.loadAll();
    }

    @RequestMapping(value = "{id}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody Employee findById(@PathVariable("id") String id) {
        return employeeRepository.findById(Integer.parseInt(id));
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.POST)
    public @ResponseBody Employee create(@RequestBody Employee employee) {
        if (employeeRepository.create(employee)) {
            return employee;
        } else {
            return null;
        }
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.PUT)
    public @ResponseBody Employee update(@RequestBody Employee employee) {
        if (employeeRepository.update(employee)) {
            return employee;
        } else {
            return null;
        }
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.DELETE)
    public @ResponseBody Employee delete(@RequestBody Employee employee) {
        if (employeeRepository.delete(employee)) {
            return employee;
        } else {
            return null;
        }
    }

}