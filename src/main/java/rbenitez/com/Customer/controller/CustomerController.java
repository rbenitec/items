package rbenitez.com.Customer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import rbenitez.com.Customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rbenitez.com.Customer.entity.Item;
import rbenitez.com.Customer.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping()
    public List<Customer> Customers(){
        return customerService.getAllCustomers();
    }

    /*
    @GetMapping("/all")
    public List<Customer> getAll(){
        return customerService.findAll();
    }

     */

    //FIN ---

    //### METODO PARA OBTENER POR ID --------------------------------

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") String id){
        return customerService.findById(id);
    }

    // ### FIN ---

    // ### METODO PARA ELIMINAR POR ID  --------------------------------------

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") String id){
        customerService.deleteById(id);

    }
    @DeleteMapping("byid/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") String id){
        customerService.deleteById(id);
        String msm = "Se elimino el Customer con ID: "+id;
        return ResponseEntity.ok(msm);
    }


    // ### METODO PARA REGISTRAR UN CUSTOMER
    @PostMapping()
    public void RegisterCustomer(@RequestBody Customer customer){
        customerService.insertCustomer(customer);
    }

    /*
    =======  METODO PARA ACTUALIZAR
     */
    @PutMapping("/{id}")
    public void update(@PathVariable("id") String id,@Validated @RequestBody Customer customer){
        customerService.update(id, customer);
    }

    /*
     * ---> Guadar un Item para los customer
     */
    /*
    @PostMapping("/saveitem/{dniCustomer}")
    public ResponseEntity<Item> saveCustomerByIdItem(@PathVariable("dniCustomer") String dniCustomer, @RequestBody Item item){
        if(customerService.findById(dniCustomer)==null){
            return ResponseEntity.notFound().build();
        }
        Item itemNew = customerService.saveItem(dniCustomer, item);
        return ResponseEntity.ok(itemNew);
    }
    */

    /*
    // ### METODOS PRA LISTR TODOS LOS CUSTOMERS
    @GetMapping("/get")
    public ResponseEntity<List<Customer>> getAllCostumer(){
        List<Customer> customers = customerService.getAllCustomers();
        if(customers.isEmpty()){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }
     */

    /*
    Metodo post desarrollado con ResponseEntity


    @PostMapping("/insert")
    public ResponseEntity<Customer> insert(@RequestBody Customer customer){
        Customer customer1 = customerService.save(customer);
        return ResponseEntity.ok(customer1);
    }

     */
}
