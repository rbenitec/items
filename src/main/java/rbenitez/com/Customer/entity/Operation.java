package rbenitez.com.Customer.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "operation")
public class Operation {

    @Transient
    public static final String SEQUENCE_NAME="operation_sequence";

    @Id
    int idOperation;
    String idCustomer;
    String idItem;
    String timeStamp;
    String status;
}
