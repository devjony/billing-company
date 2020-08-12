package br.com.devjony.billingcompany.service;

import br.com.devjony.billingcompany.entity.Company;
import br.com.devjony.billingcompany.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company save(Company company) {
        return companyRepository.save(company);
    }
}
