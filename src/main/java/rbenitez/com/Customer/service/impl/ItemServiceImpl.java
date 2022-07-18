package rbenitez.com.Customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rbenitez.com.Customer.entity.Customer;
import rbenitez.com.Customer.entity.Item;
import rbenitez.com.Customer.repository.CustomerRepository;
import rbenitez.com.Customer.repository.ItemRepository;
import rbenitez.com.Customer.service.ItemService;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item save(Item item) {
        return itemRepository.insert(item);
    }

    @Override
    public void update(String id, Item item) {
        itemRepository.save(item);
    }

    @Override
    public void deleteById(String id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item getItemById(String id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public List<Item> itemByCustomerId(String dniCustomer) {
        return itemRepository.findByDniCustomer(dniCustomer);
    }

    // ### Guardar un customer desde Item
    /*
    @Override
    public Customer saveCustomer(String idItem, Customer customer) {
        customer.setIdItem(idItem);
        Customer customerNew = customerRepository.save(customer);
        return customerNew;
    }
     */
}
