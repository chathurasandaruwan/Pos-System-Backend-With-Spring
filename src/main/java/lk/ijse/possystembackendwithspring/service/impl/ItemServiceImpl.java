package lk.ijse.possystembackendwithspring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.possystembackendwithspring.dao.ItemDAO;
import lk.ijse.possystembackendwithspring.dto.ItemDTO;
import lk.ijse.possystembackendwithspring.entity.impl.Item;
import lk.ijse.possystembackendwithspring.exeption.DataPersistException;
import lk.ijse.possystembackendwithspring.exeption.ItemNotFoundException;
import lk.ijse.possystembackendwithspring.service.ItemService;
import lk.ijse.possystembackendwithspring.util.AppUtil;
import lk.ijse.possystembackendwithspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveItem(ItemDTO dto) {
        dto.setItem_code(AppUtil.generateItemId());

        Item saveItem = itemDAO.save(mapping.toItemEntity(dto));
        if (saveItem == null) {
            throw new DataPersistException("Item Not Saved !!!");
        }
    }

    @Override
    public void updateItem(ItemDTO dto, String id) {
        Optional<Item> findItem = itemDAO.findByTempId(id);
        if (!findItem.isPresent()) {
            throw new ItemNotFoundException("Item not found");
        }else {
            findItem.get().setItem_Name(dto.getItem_Name());
            findItem.get().setItem_price(dto.getItem_price());
            findItem.get().setItem_qty(dto.getItem_qty());
        }
    }

    @Override
    public void deleteItem(String id) {
        Optional<Item> SelectedItem = itemDAO.findByTempId(id);
        if (!SelectedItem.isPresent()) {
            throw new ItemNotFoundException("Item Not Found");
        } else {
            itemDAO.deleteById(SelectedItem.get().getItem_code());
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> itemList = itemDAO.findAll();
        return mapping.asItemDTOList(itemList);
    }
}
