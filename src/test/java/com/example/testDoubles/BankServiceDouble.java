package com.example.testDoubles;

import com.example.BankService;

public class BankServiceDouble implements BankService{

    @Override
    public void pay(String id, double amount) {
        return;
    }
}
