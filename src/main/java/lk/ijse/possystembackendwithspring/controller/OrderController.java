package lk.ijse.possystembackendwithspring.controller;

import lk.ijse.possystembackendwithspring.dto.OrderRequestDTO;
import lk.ijse.possystembackendwithspring.exeption.DataPersistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(@RequestBody OrderRequestDTO orderRequestDTO) {
        try {
            System.out.println(orderRequestDTO.getOrderId());
            System.out.println(orderRequestDTO.getCustomerId());
            System.out.println(orderRequestDTO.getItems());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
