package com.example.crudex.modul;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
//    Task Class : ID , title , description , status
    private int id;
    private String title;
    private String description;
    private String status;
}
