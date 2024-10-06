package lk.ijse.possystembackendwithspring.service;

import lk.ijse.possystembackendwithspring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto,String id);
    void deleteCustomer(String id);
    List<CustomerDTO> getAllCustomers();
}
