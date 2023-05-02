package com.cleanAqruitect.CleanArquitect.dominio.entidad;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movement")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "datemov")
    private Date dateMov;

    @Column(name = "typemove")
    private String typeMove;
    @Column(name = "value")
    private float value;
    @Column(name = "balance")
    private float balance;

    @ManyToOne
    @JoinColumn( name = "accountId")
    @JsonBackReference
    private Account account;

}
