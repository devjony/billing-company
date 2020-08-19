package br.com.devjony.billingcompany.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class CompanyDTO {

    public CompanyDTO(Integer id, String companyFantasyName) {
        this.id = id;
        this.companyFantasyName = companyFantasyName;
    }

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String companyFantasyName;
}
