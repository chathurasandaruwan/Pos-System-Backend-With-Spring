package lk.ijse.possystembackendwithspring.service;

import lk.ijse.possystembackendwithspring.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO dto);

    void updateItem(ItemDTO dto, String id);

    void deleteItem(String id);

    List<ItemDTO> getAllItems();
}
