package rbenitez.com.Customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rbenitez.com.Customer.configSequenceService.SequenceGeneratorService;
import rbenitez.com.Customer.entity.Customer;
import rbenitez.com.Customer.entity.Item;
import rbenitez.com.Customer.entity.Operation;
import rbenitez.com.Customer.repository.ItemRepository;
import rbenitez.com.Customer.repository.OperationRepository;
import rbenitez.com.Customer.service.CustomerService;
import rbenitez.com.Customer.service.ItemService;
import rbenitez.com.Customer.service.OperationService;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static rbenitez.com.Customer.entity.Operation.SEQUENCE_NAME;

@Service
public class OperationServiceImpl implements OperationService{

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    ItemService itemService;


    @Autowired
    CustomerService customerService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Item> getItems(String dniCustomer) {
        List<Item> items = itemService.itemByCustomerId(dniCustomer);
        return items;
    }

    @Override
    public Operation operationPutItemToCustomer(Operation operation, String dniCustomer, String idItem) {
        Date fechaUtc = Date.from(Instant.now());
        SimpleDateFormat formatoUtc = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        String fechaUtcActual = formatoUtc.format(fechaUtc);

        //Generated sequence
        operation.setIdOperation(sequenceGeneratorService.getSecuenceNumber(SEQUENCE_NAME));

        //Asignarles los atribbutos
        operation.setIdCustomer(dniCustomer);
        operation.setIdItem(idItem);
        operation.setStatus("CREATED");
        operation.setTimeStamp(fechaUtcActual);
        //crear la operation
        operationRepository.insert(operation);

        //Buscar el item por su id
        Item item = itemService.getItemById(idItem);


        //asignar el item que ya existe al customer que ya existe
        customerService.saveItem(dniCustomer, item);

        return operation;
    }


    //Metodo para eliminar una operacion y eliminar el item del Customer

    @Override
    public Operation anularOperation(int idOperation) {
        Operation operation = operationRepository.findById(idOperation).orElse(null);
        if(operation==null){
            return null;
        }
        //Encontrar el Item a modificar
        Item itemNew = itemService.getItemById(operation.getIdItem());
        //Pasar el estado de la operacion ANULADO
        operation.setStatus("ANULADO");
        //Setear en null el dniCustumer en el item
        itemNew.setDniCustomer(null);

        //Update Item
        itemService.update(itemNew.getIdItem(),itemNew);
        //Update Operation
        operationRepository.save(operation);

        return operation;
    }


    @Override
    public Map<String, Object> getCustomerAndItems(String dniCustumer) {
        Map<String, Object> result = new HashMap<>();

        Customer customer = customerService.findById(dniCustumer);
        if(customer == null){
            result.put("Mensaje", "No existe el usuario!!");
            return  result;
        }
        result.put("User", customer);


        List<Item> items = itemService.itemByCustomerId(dniCustumer);
        if(items.isEmpty()){
            result.put("Items","Este Customer no tiene Items");
        }else{
            result.put("Items",items);
        }
        return result;
    }

    @Override
    public List<Operation> getAllOperation() {
        return operationRepository.findAll();
    }
}
