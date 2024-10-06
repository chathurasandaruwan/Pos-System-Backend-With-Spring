package lk.ijse.possystembackendwithspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDTO implements Serializable {
    String id;
    String order_id;
    String item_code;
    String qty;
    String order_date;
    String customer_id;
}
