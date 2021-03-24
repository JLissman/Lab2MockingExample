package com.example;

import org.junit.jupiter.api.Test;
import com.example.testDoubles.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;


class EmployeeManagerTest {
    //test double
    EmployeeRepositoryDouble slaves = new EmployeeRepositoryDouble();
    @Mock  //mockito
    BankService swedbank = mock(BankService.class);
    @Test
    void payEmployee(){
        //arrange
        EmployeeManager em = new EmployeeManager(slaves,swedbank);
        //act
        var ActualValue = em.payEmployees();
        //assert
        assertEquals(5,ActualValue);
    }


    @Test
    void payEmployeeException(){
        EmployeeManager em = new EmployeeManager(slaves,swedbank);

        doThrow(RuntimeException.class)
                .when(swedbank)
                .pay(anyString(),anyDouble());

        int actualPaid = em.payEmployees();

        assertEquals(0,actualPaid);

    }




}

