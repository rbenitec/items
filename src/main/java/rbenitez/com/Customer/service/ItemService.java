package rbenitez.com.Customer.service;

import rbenitez.com.Customer.entity.Customer;
import rbenitez.com.Customer.entity.Item;

import java.util.List;

public interface ItemService {

    //PAra Leer todos
    public List<Item> findAll();

    //CRear item
    public Item save(Item item);

    //Modificar Item
    public void update(String id, Item item);

    //Eliminar un Item
    public void deleteById(String id);

    // --> Obtener Item por ID
    public Item getItemById(String id);

    //____________________ PRUEBAS __________________________

    //## --> Obtener itemas por usuario id
    public List<Item> itemByCustomerId(String dniCustomer);

    // -->  Metodo para guardar un cliente
    //public Customer saveCustomer(String idItem, Customer customer);

}
