package rbenitez.com.Customer.service;

import org.springframework.stereotype.Service;
import rbenitez.com.Customer.entity.Item;
import rbenitez.com.Customer.entity.Operation;

import java.util.List;
import java.util.Map;

@Service
public interface OperationService {

    //Buscar todos los item del cliente
    public List<Item> getItems(String dniCustomer);

    //Añadir un item al Cliente, Crear un operation
    public Operation operationPutItemToCustomer(Operation operation, String dniCustomer, String idItem);

    //Anular un item al cliente, Eliminar un operation con status delete
    public Operation anularOperation(int IdOperation);

    //Obtener todos los clientes y items.
    public Map<String, Object> getCustomerAndItems(String dniCustumer);

    //Listar todas la operaciones
    public List<Operation> getAllOperation();

    //Listar las operaciones con status CREATED
    //Listar las operaciones con status DELETE

}
