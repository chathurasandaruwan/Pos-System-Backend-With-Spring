package lk.ijse.possystembackendwithspring.controller;

import lk.ijse.possystembackendwithspring.dto.CustomerDTO;
import lk.ijse.possystembackendwithspring.exeption.DataPersistException;
import lk.ijse.possystembackendwithspring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveNote(@RequestBody CustomerDTO customerDTO) {
        try {
            customerService.saveCustomer(customerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
