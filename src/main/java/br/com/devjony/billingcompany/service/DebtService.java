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
        return debtToDebtDTO(debtRepository.findDebitsByBorrowerCpf(cpf));
    }

    public List<DebtDTO> debtToDebtDTO(List<Debt> debts) {
        List<DebtDTO> debtsDTO = new ArrayList<DebtDTO>();

        for (Debt debt : debts) {
            debtsDTO.add(new DebtDTO(debt.getBorrower().getName(),
                    debt.getCompany().getFantasyName(),
                    debt.getValue())
            );
        }

        return debtsDTO;
    }
}
