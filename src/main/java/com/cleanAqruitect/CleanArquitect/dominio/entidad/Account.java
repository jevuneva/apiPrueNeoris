package com.cleanAqruitect.CleanArquitect.dominio.entidad;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nroAccount", nullable = false, unique = true)
    private String nroAccount;

    @Column(name = "typeAccount")
    private String typeAccount;

    @Column(name = "initBalance")
    private float initBalance;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn( name = "clientId")
    @JsonBackReference
    private Client client;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Movement> movementList;

}
