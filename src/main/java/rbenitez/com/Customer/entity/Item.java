package rbenitez.com.Customer.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "item")
public class Item {

    @Id
    String idItem;
    String nombreItem;
    String tipo;
    String requisito;
    String capacidad;
    String envase;
    String dniCustomer;

}
