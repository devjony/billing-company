package br.com.devjony.billingcompany.service;

import br.com.devjony.billingcompany.dto.DebtDTO;
import br.com.devjony.billingcompany.entity.Debt;
import br.com.devjony.billingcompany.repository.DebtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DebtService {

    @Autowired
    DebtRepository debtRepository;

    public Debt save(Debt debt) {
        return debtRepository.save(debt);
    }

    public DebtDTO findDebitById(Integer id) {
        Optional<Debt> deb = debtRepository.findById(id);
        return debtToDebtDTO(deb);
    }

    public List<DebtDTO> findDebitsByBorrowerCpf(String cpf) {
        return debtsToDebtsDTO(debtRepository.findDebtsByBorrowerCpf(cpf));
    }

    public void createDebt(Integer companyId, Integer borrowerId, BigDecimal value) {
        debtRepository.createDebt(companyId, borrowerId, value);
    }

    public DebtDTO debtToDebtDTO(Optional<Debt> debt) {
        return (new DebtDTO(debt.get().getId(),
                debt.get().getBorrower().getName(),
                debt.get().getCompany().getFantasyName(),
                debt.get().getValue()));
    }

    public List<DebtDTO> debtsToDebtsDTO(List<Debt> debts) {
        List<DebtDTO> debtsDTO = new ArrayList<DebtDTO>();

        for (Debt debt : debts) {
            debtsDTO.add(new DebtDTO(debt.getId(),
                    debt.getBorrower().getName(),
                    debt.getCompany().getFantasyName(),
                    debt.getValue()
            ));
        }

        return debtsDTO;
    }
}
