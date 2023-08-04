package org.dargor.customer.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Address> addresses;

}
