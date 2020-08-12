package br.com.devjony.billingcompany.service;

import br.com.devjony.billingcompany.entity.Debt;
import br.com.devjony.billingcompany.repository.DebtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebtService {

    @Autowired
    DebtRepository debtRepository;

    public Debt save(Debt debt) {
        return debtRepository.save(debt);
    }
}
