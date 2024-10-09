package lk.ijse.possystembackendwithspring.dto;

import lk.ijse.possystembackendwithspring.entity.impl.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    private String orderId;
    private String orderDate;
    private int qty;
    private String customerId;
    private List<ItemDTO> items;
}
