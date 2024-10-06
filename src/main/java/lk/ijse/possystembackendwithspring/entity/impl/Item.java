package lk.ijse.possystembackendwithspring.entity.impl;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lk.ijse.possystembackendwithspring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item implements SuperEntity{
    @Id
    String item_code;
    String item_Name;
    String item_price;
    String item_qty;
    @ManyToMany(mappedBy = "items", cascade = CascadeType.ALL)
    private List<Order> orders;
}
