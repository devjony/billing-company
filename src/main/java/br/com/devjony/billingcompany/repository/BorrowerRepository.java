package br.com.devjony.billingcompany.repository;

import br.com.devjony.billingcompany.entity.BorrowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<BorrowerEntity, Integer> {

    BorrowerEntity findByCpf(String cpf);

}
