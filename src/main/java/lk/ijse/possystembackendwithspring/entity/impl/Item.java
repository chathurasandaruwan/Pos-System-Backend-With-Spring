package lk.ijse.possystembackendwithspring.entity.impl;

import jakarta.persistence.*;
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
    @Column(unique = true)
    String tempId;
    @ManyToMany(mappedBy = "items", cascade = CascadeType.ALL)
    private List<Order> orders;
}
