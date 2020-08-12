package br.com.devjony.billingcompany.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class Debt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private BigDecimal value;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name = "company_id")
    Company company;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name = "borrower_id")
    Borrower borrower;

}
