package lk.ijse.possystembackendwithspring.entity.impl;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lk.ijse.possystembackendwithspring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Order order;
}
