package br.com.devjony.billingcompany.service;

import br.com.devjony.billingcompany.entity.Borrower;
import br.com.devjony.billingcompany.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerService {

    @Autowired
    BorrowerRepository borrowerRepository;

    public Borrower save(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    public Borrower findByCpf(String cpf) {
        return borrowerRepository.findByCpf(cpf);
    }

}
