package lk.ijse.possystembackendwithspring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.possystembackendwithspring.dao.CustomerDAO;
import lk.ijse.possystembackendwithspring.dao.ItemDAO;
import lk.ijse.possystembackendwithspring.dao.OrderDAO;
import lk.ijse.possystembackendwithspring.dto.ItemDTO;
import lk.ijse.possystembackendwithspring.dto.OrderDTO;
import lk.ijse.possystembackendwithspring.entity.impl.Customer;
import lk.ijse.possystembackendwithspring.entity.impl.Item;
import lk.ijse.possystembackendwithspring.entity.impl.Order;
import lk.ijse.possystembackendwithspring.exeption.DataPersistException;
import lk.ijse.possystembackendwithspring.service.OrderService;
import lk.ijse.possystembackendwithspring.util.AppUtil;
import lk.ijse.possystembackendwithspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private Mapping mapping;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private ItemDAO itemDAO;

    @Transactional
    @Override
    public void saveOrder(OrderDTO orderDTO) {
        Order order = mapping.toOrderEntity(orderDTO);
        order.setOrder_id(AppUtil.generateOrderId());
//        get Item TempIds
        List<String> tempIds = orderDTO.getItems().stream()
                .map(ItemDTO::getTempId)
                .collect(Collectors.toList());
        List<Item> itemList = itemDAO.findAllByTempIdIn(tempIds);
        List<Item> itemsFromOrderDTO= mapping.asItemEntityList(orderDTO.getItems());

        // Create a map from itemList tempId as key
        Map<String, Item> itemListMap = itemList.stream()
                .collect(Collectors.toMap(Item::getTempId, Function.identity()));

        // set Item codes to itemsFromOrderDTO based on tempId
        for (Item item : itemsFromOrderDTO) {
            Item itemLists = itemListMap.get(item.getTempId());
            if (itemLists != null) {
                item.setItem_code(itemLists.getItem_code());
            }
        }
        order.setItems(itemsFromOrderDTO);
        Customer customer = customerDAO.findByTempId(orderDTO.getCustomer().getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        order.setCustomer(customer);

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
