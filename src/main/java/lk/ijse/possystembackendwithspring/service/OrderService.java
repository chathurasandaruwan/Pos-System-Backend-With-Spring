package lk.ijse.possystembackendwithspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.possystembackendwithspring.dto.OrderDTO;
import lk.ijse.possystembackendwithspring.entity.impl.Order;

public interface OrderService {
    @Transactional
    Order saveOrder(OrderDTO orderDTO);
}
