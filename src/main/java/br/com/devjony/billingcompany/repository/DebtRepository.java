package br.com.devjony.billingcompany.repository;

import br.com.devjony.billingcompany.entity.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DebtRepository extends JpaRepository<Debt, Integer> {

    @Query("SELECT d FROM Debt d LEFT JOIN FETCH d.borrower WHERE d.borrower.cpf = :cpf")
    List<Debt> findDebtsByBorrowerCpf(@Param("cpf") String cpf);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Debt(company_id, borrower_id, price) VALUES(:companyId, :borrowerId, :value)", nativeQuery = true)
    void createDebt(@Param("companyId") Integer companyId, @Param("borrowerId") Integer borrowerId, @Param("value") BigDecimal value);
}