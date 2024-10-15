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
public class Customer implements SuperEntity {
    @Id
    String customerId;
    String customerName;
    String customerAdd;
    String customerSalary;
    @Column(unique = true)
    String tempId;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

}
