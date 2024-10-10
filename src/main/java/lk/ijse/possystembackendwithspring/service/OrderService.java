package lk.ijse.possystembackendwithspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.possystembackendwithspring.dto.OrderDTO;
import lk.ijse.possystembackendwithspring.entity.impl.Order;

import java.util.List;

public interface OrderService {
    @Transactional
    void saveOrder(OrderDTO orderDTO);

    List<OrderDTO> getAllOrders();
}
