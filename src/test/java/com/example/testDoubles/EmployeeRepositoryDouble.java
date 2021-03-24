package com.example.testDoubles;
import com.example.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeRepositoryDouble implements EmployeeRepository {

    List<Employee> returnList = new ArrayList<>();
    @Override
    public List<Employee> findAll() {

        for (int i = 0; i < 5; i++) {
            returnList.add(new Employee(String.valueOf(i),20000));
        }
        return returnList;
    }

    @Override
    public Employee save(Employee e) {
        returnList.add(e);
        return e;
    }


}
