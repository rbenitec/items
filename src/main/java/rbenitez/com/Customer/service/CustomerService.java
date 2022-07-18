package rbenitez.com.Customer.service;

import rbenitez.com.Customer.entity.Customer;
import org.springframework.stereotype.Service;
import rbenitez.com.Customer.entity.Item;

import java.util.List;

public interface CustomerService {

    //Metodo para listar todos los customer
    List<Customer> getAllCustomers();

    public List<Customer> findAll();

    //Metodo para Agregar Customer
    public void insertCustomer(Customer customer);

    //MEtodo para modificar Customer
    public void update(String id, Customer customer);

    //Metodo para eliminar Customer.
    public void deleteById(String id);

    public Customer save(Customer customer);

    //Find Customer by Id
    public Customer findById(String id);

    // -->  Metodo para asignar un item
    public void saveItem(String dniCustomer, Item item);

    // --> Metodo para eliminar un item del costumer
   // public void deleteItem(Customer customer);

}
