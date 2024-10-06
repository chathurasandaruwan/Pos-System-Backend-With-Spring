package lk.ijse.possystembackendwithspring.dto;

import lk.ijse.possystembackend.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements Serializable {
    String order_id;
    String item_code;
    String order_date;
    String customer_id;
}
