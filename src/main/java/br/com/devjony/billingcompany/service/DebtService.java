package br.com.devjony.billingcompany.service;

import br.com.devjony.billingcompany.dto.DebtDTO;
import br.com.devjony.billingcompany.entity.Debt;
import br.com.devjony.billingcompany.repository.DebtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DebtService {

    @Autowired
    DebtRepository debtRepository;

    public Debt save(Debt debt) {
        return debtRepository.save(debt);
    }

    public List<DebtDTO> findDebitsByBorrowerCpf(String cpf) {
        return debtToDebtDTO(debtRepository.findDebtsByBorrowerCpf(cpf));
    }

    public List<DebtDTO> debtToDebtDTO(List<Debt> debts) {
        List<DebtDTO> debtDTOS = new ArrayList<DebtDTO>();

        for (Debt debt : debts) {
            debtDTOS.add(new DebtDTO(debt.getId(),
                    debt.getBorrower().getName(),
                    debt.getCompany().getFantasyName(),
                    debt.getValue()
            ));
        }

        return debtDTOS;
    }
}
