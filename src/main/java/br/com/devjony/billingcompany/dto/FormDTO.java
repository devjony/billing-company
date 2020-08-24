package br.com.devjony.billingcompany.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class FormDTO {

    @Getter
    @Setter
    private String cpf;

    @Getter
    @Setter
    private Integer companyId;
}
