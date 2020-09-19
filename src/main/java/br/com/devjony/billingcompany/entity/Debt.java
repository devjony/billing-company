package br.com.devjony.billingcompany.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@ToString
@NoArgsConstructor
public class Debt implements Serializable {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(name = "price")
    private BigDecimal value;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "borrower_id")
    Borrower borrower;

}
