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

    @PutMapping("/Deposit/{deposit}")
    //Deposit money to customer
    public ApiResponse depositCustomer(@RequestBody Coustmers coustmers, @PathVariable double deposit) {
        for(Coustmers coustmer : coustmersList) {
            if (coustmer.equals(coustmers)) {
                coustmer.setBalance(coustmer.getBalance()+deposit);
                return new ApiResponse("Successfully deposited");
            }
        }
        return new ApiResponse("Customer not found");
    }

    @PutMapping("/withdraw/{money}")
    //Withdraw money from customers
    public ApiResponse withdrawalCustomer(@RequestBody Coustmers coustmers,@PathVariable double money) {
        for (Coustmers coustmer : coustmersList) {
            if (coustmer.equals(coustmers)) {
                if (money > coustmers.getBalance()) {
                    return new ApiResponse("can not withdraw");
                } else {
                    coustmer.setBalance(coustmer.getBalance() - money);
                    return new ApiResponse("Successfully withdrawn");
                }
            }
        }
        return new ApiResponse("Customer not found");
    }


}
