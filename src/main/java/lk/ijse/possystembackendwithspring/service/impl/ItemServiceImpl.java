package lk.ijse.possystembackendwithspring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.possystembackendwithspring.dao.ItemDAO;
import lk.ijse.possystembackendwithspring.dto.ItemDTO;
import lk.ijse.possystembackendwithspring.entity.impl.Customer;
import lk.ijse.possystembackendwithspring.entity.impl.Item;
import lk.ijse.possystembackendwithspring.exeption.DataPersistException;
import lk.ijse.possystembackendwithspring.service.ItemService;
import lk.ijse.possystembackendwithspring.util.AppUtil;
import lk.ijse.possystembackendwithspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    }

    @Override
    public void deleteItem(String id) {

    }

    @Override
    public List<ItemDTO> getAllItems() {
        return null;
    }
}
