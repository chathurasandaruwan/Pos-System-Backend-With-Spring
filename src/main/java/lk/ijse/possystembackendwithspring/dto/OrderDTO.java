package lk.ijse.possystembackendwithspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String order_id;
    private String order_date;
    private String qty;
    String tempId;
    private CustomerDTO customer;
    private List<ItemDTO> items;
}
