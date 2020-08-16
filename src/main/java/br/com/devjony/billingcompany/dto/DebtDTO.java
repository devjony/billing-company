package br.com.devjony.billingcompany.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
public class DebtDTO {

    public DebtDTO(String borrowerName, String companyFantasyName, BigDecimal value) {
        this.borrowerName = borrowerName;
        this.companyFantasyName = companyFantasyName;
        this.debtValue = value;
    }

    @Getter
    @Setter
    private String borrowerName;

    @Getter
    @Setter
    private String companyFantasyName;

    @Getter
    @Setter
    private BigDecimal debtValue;
}
