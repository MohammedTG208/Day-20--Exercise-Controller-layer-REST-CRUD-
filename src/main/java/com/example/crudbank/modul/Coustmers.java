package com.example.crudbank.modul;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coustmers {
//    //Customers Class : ID , Username , Balance
    private int id;
    private String username;
    private double balance;
}
