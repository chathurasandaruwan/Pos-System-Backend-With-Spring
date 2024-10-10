package lk.ijse.possystembackendwithspring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.possystembackendwithspring.dao.CustomerDAO;
import lk.ijse.possystembackendwithspring.dao.ItemDAO;
import lk.ijse.possystembackendwithspring.dao.OrderDAO;
import lk.ijse.possystembackendwithspring.dto.OrderDTO;
import lk.ijse.possystembackendwithspring.entity.impl.Customer;
import lk.ijse.possystembackendwithspring.entity.impl.Item;
import lk.ijse.possystembackendwithspring.entity.impl.Order;
import lk.ijse.possystembackendwithspring.exeption.DataPersistException;
import lk.ijse.possystembackendwithspring.service.OrderService;
import lk.ijse.possystembackendwithspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private Mapping mapping;

    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    @Override
    public void saveOrder(OrderDTO orderDTO) {

        Order order = mapping.toOrderEntity(orderDTO);
        order.setItems(mapping.asItemEntityList(orderDTO.getItems()));
        Customer customer = customerDAO.findById(orderDTO.getCustomer().getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        order.setCustomer(customer);
        order.setOrder_id(orderDTO.getOrderId());
        order.setOrder_date(orderDTO.getOrderDate());
        order.setQty(String.valueOf(orderDTO.getQty()));

        Order saveOder = orderDAO.save(order);
        if (saveOder == null) {
            throw new DataPersistException("Order Not Saved !!!");
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> all = orderDAO.findAll();
        return mapping.asOrderDTOList(all);
    }
}
