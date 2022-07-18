package rbenitez.com.Customer.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rbenitez.com.Customer.entity.Customer;
import rbenitez.com.Customer.entity.Item;
import rbenitez.com.Customer.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    // --> metodo para listar todos
    @GetMapping()
    public ResponseEntity<List<Item>> items(){
        List<Item> lis = itemService.findAll();
        if(lis.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lis);
    }

    // --> Crear un item
    @PostMapping()
    public ResponseEntity<Item> save(@RequestBody Item item){
        Item itm = itemService.save(item);
        return ResponseEntity.ok(itm);
    }

    // --> Metodo para actualizar
    @PutMapping("/{id}")
    public void update(@PathVariable("id") String id,@Validated @RequestBody Item item){
        itemService.update(id,item);
    }

    //--> Metodo para Elimina
    @DeleteMapping("/{id}")
    public void deleteItem (@PathVariable("id") String id){
        itemService.deleteById(id);
    }

    // ------  Guaradar Customer para los Item     ----
    /*
    @PostMapping("/savecustomer/{idItem}")
    public ResponseEntity<Customer> saveCustomerByIdItem(@PathVariable("idItem") String idItem, @RequestBody Customer customer){
        if(itemService.getItemById(idItem)==null){
            return ResponseEntity.notFound().build();
        }
        Customer customerNew = itemService.saveCustomer(idItem, customer);
        return ResponseEntity.ok(customerNew);
    }
    */

}
