package lk.ijse.possystembackendwithspring.util;

import lk.ijse.possystembackendwithspring.dto.CustomerDTO;
import lk.ijse.possystembackendwithspring.dto.ItemDTO;
import lk.ijse.possystembackendwithspring.dto.OrderDTO;
import lk.ijse.possystembackendwithspring.entity.impl.Customer;
import lk.ijse.possystembackendwithspring.entity.impl.Item;
import lk.ijse.possystembackendwithspring.entity.impl.Order;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper mapper;

//    for customer mapping
    public CustomerDTO toCustomerDTO(Customer customer){
        CustomerDTO customerDTO = mapper.map(customer,CustomerDTO.class);
        return customerDTO;
    }

    public Customer toCustomerEntity(CustomerDTO customerDTO){
        Customer customer = mapper.map(customerDTO,Customer.class);
        return customer;
    }

//    for item mapping
    public ItemDTO toItemDTO(Item item){
        ItemDTO itemDTO = mapper.map(item,ItemDTO.class);
        return itemDTO;
    }

    public Item toItemEntity(ItemDTO itemDTO){
        Item item = mapper.map(itemDTO,Item.class);
        return item;
    }

    public Order toOrderEntity(OrderDTO orderDTO){
        Order order = mapper.map(orderDTO,Order.class);
        return order;
    }
    public List<CustomerDTO> asCustomerDTOList(List<Customer> customerList){
        List<CustomerDTO> customerDTOList = mapper.map(customerList, new TypeToken<List<CustomerDTO>>(){}.getType());
        return customerDTOList;
    }
    public List<ItemDTO> asItemDTOList(List<Item> itemList){
        List<ItemDTO> itemDTOList = mapper.map(itemList, new TypeToken<List<ItemDTO>>(){}.getType());
        return itemDTOList;
    }

    public List<Item> asItemEntityList(List<ItemDTO> itemList){
        List<Item> itemEntityList = mapper.map(itemList, new TypeToken<List<Item>>(){}.getType());
        return itemEntityList;
    }
}
