package lk.ijse.possystembackendwithspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String orderId;
    private String orderDate;
    private int qty;
    private CustomerDTO customer;
    private List<ItemDTO> items;
}
