package rbenitez.com.Customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rbenitez.com.Customer.entity.Customer;
import rbenitez.com.Customer.entity.Item;
import rbenitez.com.Customer.entity.Operation;
import rbenitez.com.Customer.service.CustomerService;
import rbenitez.com.Customer.service.OperationService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    OperationService operationService;

    @Autowired
    CustomerService customerService;

    // --> Obtener todos los items por idCustomer
    @GetMapping("/getitems/{dniCustomer}")
    public ResponseEntity<List<Item>> getItemsByCustumerId(@PathVariable("dniCustomer") String dniCustomer){
        Customer customer = customerService.findById(dniCustomer);
        if(customer==null){
            ResponseEntity.notFound().build();
        }
        List<Item> items = operationService.getItems(dniCustomer);
        return ResponseEntity.ok(items);
    }

    // --> Obtener todos los items del customer
    @GetMapping("/getall/{dniCustomer}")
    public ResponseEntity<Map<String, Object>> getCustomerAndItems(@PathVariable("dniCustomer") String dniCustomer){
        Map<String, Object> all = operationService.getCustomerAndItems(dniCustomer);
        return ResponseEntity.ok(all);
    }

    // ---> Añadir un item al Cliente, Crear un operation
    @PostMapping("/difine/{dniCustomer}/{idItem}")
    public ResponseEntity<Operation> defineItemToCustomer(@PathVariable("dniCustomer") String dniCustomer, @PathVariable("idItem") String idItem) {
        Operation operation = new Operation();
        Operation operationNew = operationService.operationPutItemToCustomer(operation, dniCustomer, idItem);
        return ResponseEntity.ok(operation);
    }

    // --> Borrar el Item del customer, y eliminar la operacion

    @PostMapping("/anula/{idOperation}")
    public ResponseEntity<Operation> anularOperation(@PathVariable("idOperation") int idOperation){
        Item item = new Item();
        Operation operation = operationService.anularOperation(idOperation);
        if(operation == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(operation);
    }

    // --> Obtener  todas las operaciones
    @GetMapping("/getAllOperation")
    public ResponseEntity<List<Operation>> getAllOperation(){
        List<Operation> operations = operationService.getAllOperation();
        if(operations.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(operations);
    }

}
