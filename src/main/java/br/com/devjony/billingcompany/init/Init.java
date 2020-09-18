package br.com.devjony.billingcompany.init;

import br.com.devjony.billingcompany.entity.BorrowerEntity;
import br.com.devjony.billingcompany.entity.Company;
import br.com.devjony.billingcompany.entity.Debt;
import br.com.devjony.billingcompany.service.BorrowerService;
import br.com.devjony.billingcompany.service.CompanyService;
import br.com.devjony.billingcompany.service.DebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    BorrowerService borrowerService;

    @Autowired
    CompanyService companyService;

    @Autowired
    DebtService debtService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

//        ###### BORROWER ######

        BorrowerEntity borrower = new BorrowerEntity();
        borrower.setName("Carla");
        borrower.setCpf("11111111111111");
        borrowerService.save(borrower);

        BorrowerEntity borrower2 = new BorrowerEntity();
        borrower2.setName("Luiz");
        borrower2.setCpf("2222222222222");
        borrowerService.save(borrower2);

        BorrowerEntity borrower3 = new BorrowerEntity();
        borrower3.setName("Carlos");
        borrower3.setCpf("333333333333333");
        borrowerService.save(borrower3);


//        ###### COMPANIES ######

        Company company = new Company();
        company.setFantasyName("Lojas Renner");
        companyService.save(company);

        Company company2 = new Company();
        company2.setFantasyName("Lojas Americanas");
        companyService.save(company2);

        Company company3 = new Company();
        company3.setFantasyName("Zizane");
        companyService.save(company3);

//        ###### DEBTS ######

        Debt debt = new Debt();
        debt.setBorrower(borrower);
        debt.setCompany(company);
        debt.setValue(new BigDecimal("1000"));
        debtService.save(debt);

        Debt debt2 = new Debt();
        debt2.setBorrower(borrower);
        debt2.setCompany(company2);
        debt2.setValue(new BigDecimal("1200"));
        debtService.save(debt2);

        Debt debt3 = new Debt();
        debt3.setBorrower(borrower2);
        debt3.setCompany(company2);
        debt3.setValue(new BigDecimal("1800"));
        debtService.save(debt3);

        Debt debt4 = new Debt();
        debt4.setBorrower(borrower3);
        debt4.setCompany(company3);
        debt4.setValue(new BigDecimal("1700"));
        debtService.save(debt4);
    }
}

