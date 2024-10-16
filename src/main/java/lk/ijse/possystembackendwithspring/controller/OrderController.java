package lk.ijse.possystembackendwithspring.controller;

import lk.ijse.possystembackendwithspring.dto.OrderDTO;
import lk.ijse.possystembackendwithspring.exeption.DataPersistException;
import lk.ijse.possystembackendwithspring.service.OrderService;
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
@RequestMapping("api/v1/order")
public class OrderController {
    static Logger logger =  LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDTO orderDTO) {
        try {
            orderService.saveOrder(orderDTO);
            logger.info("From Order: "+"Order Save Successfully !!!");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            logger.warn("From Order: "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("From Order: "+"Order Not Save !!!");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> allOrders = orderService.getAllOrders();
        logger.info("From Order: "+"Order Get Successfully !!!");
        return allOrders;
    }
}
