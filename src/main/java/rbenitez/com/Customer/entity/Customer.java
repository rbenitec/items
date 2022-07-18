package rbenitez.com.Customer.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
public class Customer {

    @Id
    String dni;
    String nombre;
    String apellido;
    String fechaNacimiento;

}
