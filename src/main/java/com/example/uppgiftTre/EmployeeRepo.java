package com.example.uppgiftTre;

import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.List;

public class EmployeeRepo implements EmployeeRepository {
    List<Employee> listOfEmployees;
    public EmployeeRepo(List<Employee> listOfEmployees){
        this.listOfEmployees = listOfEmployees;

    }


    @Override
    public List<Employee> findAll() {
        return listOfEmployees;
    }

    @Override
    public Employee save(Employee e) {
        boolean replaced = false;
        for (Employee emp:listOfEmployees
             ) {
            if (emp.getId().equals(e.getId())){
                System.out.println(emp.getId()+" equals "+e.getId());
                emp.setSalary(e.getSalary());
                replaced = true;
            }
        }
        if (!replaced){
            listOfEmployees.add(e);
        }

        return e;
    }
}
