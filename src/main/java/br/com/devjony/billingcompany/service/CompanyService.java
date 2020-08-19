package br.com.devjony.billingcompany.service;

import br.com.devjony.billingcompany.dto.CompanyDTO;
import br.com.devjony.billingcompany.dto.DebtDTO;
import br.com.devjony.billingcompany.entity.Company;
import br.com.devjony.billingcompany.entity.Debt;
import br.com.devjony.billingcompany.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public List<CompanyDTO> getCompanies() {
        return companyToCompanyDTO(companyRepository.findAll());
    }

    public List<CompanyDTO> companyToCompanyDTO(List<Company> companies) {
        List<CompanyDTO> companyDTOS = new ArrayList<CompanyDTO>();

        for (Company company : companies) {
            companyDTOS.add(new CompanyDTO(company.getId(), company.getFantasyName()));
        }

        return companyDTOS;
    }
}
