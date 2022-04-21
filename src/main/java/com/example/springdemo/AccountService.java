package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService{
    @Autowired
    MyDataBase dataInstance;

    public boolean createAccount(String name, String pw) {
        List<Account> accounts = dataInstance.getAccounts();

        boolean alreadyExists = accounts.stream().any(item -> item.Name.equals(name));

        if(alreadyExists){
            return dataInstance.createNewAccount(name, pw);
        }
        return false;
    }
}
