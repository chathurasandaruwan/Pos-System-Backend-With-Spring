package lk.ijse.possystembackendwithspring.dto;

import lk.ijse.possystembackendwithspring.entity.impl.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private String orderId;
    private int qty;
    private List<Item> items;
}
