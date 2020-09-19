package br.com.devjony.billingcompany.repository;

import br.com.devjony.billingcompany.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Integer> {

    Borrower findByCpf(String cpf);

}
