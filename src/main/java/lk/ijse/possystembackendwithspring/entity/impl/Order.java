package lk.ijse.possystembackendwithspring.entity.impl;

import jakarta.persistence.*;
import lk.ijse.possystembackendwithspring.entity.SuperEntity;
import lk.ijse.possystembackendwithspring.entity.impl.Customer;
import lk.ijse.possystembackendwithspring.entity.impl.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order implements SuperEntity {
    @Id
    String order_id;
    String item_code;
    String order_date;
    String qty;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_details",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;
}
