package com.example.uppgiftTre;

import com.example.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

class EmployeeRepoTest {

    //assign
    Employee emp1 = new Employee("1",10000);
    Employee emp2 = new Employee("2",30000);
    Employee emp3 = new Employee("3",40000);
    List<Employee> EmployeeList = new ArrayList<>(Arrays.asList(emp1,emp2,emp3));
    EmployeeRepo repo = new EmployeeRepo(EmployeeList);

    @Test
    void findAll() {
        var actualValue = repo.findAll();

        assertEquals(EmployeeList,actualValue);
    }

    @Test
    void saveAddingPeople() {
        Employee emp4 = new Employee("4",50000);

        repo.save(emp4);
        //base size is 3, we added one.
        assertEquals(4,repo.findAll().size());
    }

    @Test
    void saveReplacingPeopleCheckBySalary(){
        Employee emp5 = new Employee("1",202342);


        repo.save(emp5);
        var newActualValue = repo.findAll().get(0).getSalary();
        //old salary was 10000
        assertEquals(202342,newActualValue,0);


    }
    @Test
    void saveReplacingPeopleCheckByListLen(){
        //
        Employee emp5 = new Employee("1",3245345);

        repo.save(emp5);
        var newActualValue = repo.findAll().size();


        assertEquals(3,newActualValue);


    }
}