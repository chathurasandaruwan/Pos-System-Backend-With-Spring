package lk.ijse.possystembackendwithspring.controller;

import lk.ijse.possystembackendwithspring.dto.ItemDTO;
import lk.ijse.possystembackendwithspring.exeption.CustomerNotFoundException;
import lk.ijse.possystembackendwithspring.exeption.DataPersistException;
import lk.ijse.possystembackendwithspring.service.ItemService;
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
@RequestMapping("api/v1/item")
public class ItemController {
    static Logger logger =  LoggerFactory.getLogger(ItemController.class);
    @Autowired
    private ItemService itemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItem(@RequestBody ItemDTO itemDTO) {
        try {
            itemService.saveItem(itemDTO);
            logger.info("From Item: "+"Item Saved Successfully !!!");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            logger.warn("From Item: "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("From Item: "+"Item Not Saved !!!");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{itemCode}")
    public ResponseEntity<Void> updateItem(@PathVariable("itemCode") String itemCode,@RequestBody ItemDTO itemDTO) {
        try {
            if(itemDTO == null){
                logger.warn("From Item: "+"ItemDTO Is Empty !!!");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.updateItem(itemDTO,itemCode);
            logger.info("From Item: "+"Item Updated Successfully !!!");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            e.printStackTrace();
            logger.warn("From Item: "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("From Item: "+"Item Not Updated !!!");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{itemCode}")
    public ResponseEntity<Void> deleteItem(@PathVariable("itemCode") String itemCode) {
        try {
            itemService.deleteItem(itemCode);
            logger.info("From Item: "+"Item Deleted Successfully !!!");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            logger.warn("From Item: "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("From Item: "+"Item Not Deleted !!!");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems() {
        logger.info("From Item: "+"Item Get Successfully !!!");
        return itemService.getAllItems();
    }

}
