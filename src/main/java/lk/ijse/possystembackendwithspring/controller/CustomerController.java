package lk.ijse.possystembackendwithspring.controller;

import lk.ijse.possystembackendwithspring.dto.CustomerDTO;
import lk.ijse.possystembackendwithspring.exeption.CustomerNotFoundException;
import lk.ijse.possystembackendwithspring.exeption.DataPersistException;
import lk.ijse.possystembackendwithspring.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    static Logger logger =  LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            customerService.saveCustomer(customerDTO);
            logger.info("From Customer: "+"Customer Saved Successfully !!!");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.warn("From Customer: "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error("From Customer: "+"Customer Not Saved !!!");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers() {
        logger.info("From Customer: "+"Customer Get Successfully !!!");
        return customerService.getAllCustomers();
    }
    @PutMapping(value = "/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable("customerId") String customerId,@RequestBody CustomerDTO customerDTO) {
        try {
            if(customerDTO == null){
                logger.warn("From Customer: "+"Customer Not Found !!!");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.updateCustomer(customerDTO,customerId);
            logger.info("From Customer: "+"Customer Updated Successfully !!!");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            e.printStackTrace();
            logger.warn("From Customer: "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("From Customer: "+"Customer Not Updated !!!");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") String customerId) {
        try {
            customerService.deleteCustomer(customerId);
            logger.info("From Customer: "+"Customer Deleted Successfully !!!");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            logger.warn("From Customer: "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("From Customer: "+"Customer Not Deleted !!!");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
