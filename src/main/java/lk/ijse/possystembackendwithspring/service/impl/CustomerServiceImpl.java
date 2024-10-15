package lk.ijse.possystembackendwithspring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.possystembackendwithspring.dao.CustomerDAO;
import lk.ijse.possystembackendwithspring.dto.CustomerDTO;
import lk.ijse.possystembackendwithspring.entity.impl.Customer;
import lk.ijse.possystembackendwithspring.exeption.CustomerNotFoundException;
import lk.ijse.possystembackendwithspring.exeption.DataPersistException;
import lk.ijse.possystembackendwithspring.service.CustomerService;
import lk.ijse.possystembackendwithspring.util.AppUtil;
import lk.ijse.possystembackendwithspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Customer> findCustomer = customerDAO.findByTempId(id);
        System.out.println(findCustomer);
        if (!findCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            findCustomer.get().setCustomerName(dto.getCustomerName());
            findCustomer.get().setCustomerAdd(dto.getCustomerAdd());
            findCustomer.get().setCustomerSalary(dto.getCustomerSalary());
        }
    }

    @Override
    public void deleteCustomer(String id) {
        Optional<Customer> SelectedCustomer = customerDAO.findByTempId(id);
        if (!SelectedCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer Not Found");
        } else {
            customerDAO.deleteById(SelectedCustomer.get().getCustomerId());
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerDAO.findAll();
        return mapping.asCustomerDTOList(customers);
    }
}
