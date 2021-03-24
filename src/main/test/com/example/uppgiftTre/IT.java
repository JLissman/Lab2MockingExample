package com.example.uppgiftTre;

import com.example.BankService;
import com.example.Employee;
import com.example.EmployeeManager;
import com.example.uppgiftTre.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;


class IT {
    Employee emp1 = new Employee("1",10000);
    Employee emp2 = new Employee("2",20000);
    Employee emp3 = new Employee("2",30000);
    List<Employee> EmployeeList = new ArrayList<>(Arrays.asList(emp1,emp2,emp3));
    EmployeeRepo repo = new EmployeeRepo(EmployeeList);
    @Mock
    BankService swedbank = mock(BankService.class);
    @Test
    void payEmployee(){
        //arrange
        EmployeeManager em = new EmployeeManager(repo,swedbank);
        //act
        var ActualValue = em.payEmployees();
        //assert
        assertEquals(3,ActualValue);
    }


    @Test
    void payEmployeeException(){
        EmployeeManager em = new EmployeeManager(repo,swedbank);

        doThrow(RuntimeException.class)
                .when(swedbank)
                .pay(anyString(),anyDouble());

        int actualPaid = em.payEmployees();
        //we didnt pay anybody because they all threw an exception
        assertEquals(0,actualPaid);

    }




}

