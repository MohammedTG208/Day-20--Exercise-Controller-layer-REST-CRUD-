package com.example.crudbank.BankController;
import com.example.crudbank.API.ApiResponse;
import com.example.crudbank.modul.Coustmers;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/bank/customers/info")
public class Controller {
//    Create Bank management system where you can get all the Customers
//, add , remove , update Customers
//Endpoints :
//Get all the customers
//Add new customers
//Update customers
//Delete customers
//Deposit money to customer
//Withdraw money from customers
    ArrayList<Coustmers> coustmersList = new ArrayList<>();
    //Get all the customers
    @GetMapping("/get")
    public ArrayList<Coustmers> getCustomers() {
        return coustmersList;
    }

    @PostMapping("/add")
//    Add new customers
    public ApiResponse addCustomer(@RequestBody Coustmers coustmers) {
        coustmersList.add(coustmers);
        return new ApiResponse("Successfully added customers");
    }

    @PutMapping("/update/{id}")
//    Update customers
    public ApiResponse updateCustomer(@RequestBody Coustmers coustmers, @PathVariable int id) {
        coustmersList.set(id, coustmers);
        return new ApiResponse("Successfully updated customer");
    }

    @DeleteMapping("/delete/{id}")
    //Delete customers
    public ApiResponse deleteCustomer(@PathVariable int id) {
        coustmersList.remove(id);
        return new ApiResponse("Successfully deleted customers");
    }

    @PutMapping("/Deposit/{deposit}/{id}")
    //Deposit money to customer
    public ApiResponse depositCustomer(@PathVariable int id, @PathVariable double deposit) {
        for (int i = 0; i < coustmersList.size(); i++) {
            if (coustmersList.get(i).getId() == id) {
                coustmersList.get(i).setBalance(coustmersList.get(i).getBalance() + deposit);
                return new ApiResponse("Successfully updated deposit");
            }
        }
        return new ApiResponse("Customer not found");
    }

    @PutMapping("/withdraw/{money}/{id}")
    //Withdraw money from customers
    public ApiResponse withdrawalCustomer(@PathVariable double money,@PathVariable int id) {
       for (int i = 0; i < coustmersList.size(); i++) {
           if (coustmersList.get(i).getId() == id) {
               if (coustmersList.get(i).getBalance() < money) {
                   coustmersList.get(i).setBalance(coustmersList.get(i).getBalance() - money);
                   return new ApiResponse("Withdraw money");
               }
           }
       }
        return new ApiResponse("Customer not found");
    }


    @PutMapping("/update/{id}")
    public ApiResponse updateCustomer(@RequestBody Coustmers coustmers) {
        for (int i = 0; i < coustmersList.size(); i++) {
            if (coustmersList.get(i).getId() == coustmers.getId()) {
                coustmersList.set(i, coustmers);
            }
        }
    }
}
