package rbenitez.com.Customer.service.impl;

import org.springframework.stereotype.Service;
import rbenitez.com.Customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import rbenitez.com.Customer.entity.Item;
import rbenitez.com.Customer.repository.CustomerRepository;
import rbenitez.com.Customer.repository.ItemRepository;
import rbenitez.com.Customer.service.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(String id, Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(String id) {
//        Optional<Customer> optionalCustomer = customerRepository.findById(id);
 //       Customer customer = optionalCustomer.get();
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveItem(String dniCustomer, Item item) {
        item.setDniCustomer(dniCustomer);
        itemRepository.save(item);
    }

    /*
    @Override
    public void deleteItem(Customer customer, Item item) {
        customer.set
    }
    */

}
