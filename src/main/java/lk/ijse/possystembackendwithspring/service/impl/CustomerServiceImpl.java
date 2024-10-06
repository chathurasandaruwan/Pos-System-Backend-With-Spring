package lk.ijse.possystembackendwithspring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.possystembackendwithspring.dao.CustomerDAO;
import lk.ijse.possystembackendwithspring.dto.CustomerDTO;
import lk.ijse.possystembackendwithspring.entity.impl.Customer;
import lk.ijse.possystembackendwithspring.exeption.DataPersistException;
import lk.ijse.possystembackendwithspring.service.CustomerService;
import lk.ijse.possystembackendwithspring.util.AppUtil;
import lk.ijse.possystembackendwithspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveCustomer(CustomerDTO dto) {
        dto.setCustomerId(AppUtil.generateCustomerId());

        Customer savedCustomer = customerDAO.save(mapping.toCustomerEntity(dto));
        if (savedCustomer == null) {
            throw new DataPersistException("Customer Not Saved !!!");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto, String id) {

    }

    @Override
    public void deleteCustomer(String id) {

    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        return null;
    }
}
