package br.com.devjony.billingcompany.controller;

import br.com.devjony.billingcompany.entity.Company;
import br.com.devjony.billingcompany.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    public ModelAndView getCompanies() {
        ModelAndView mv = new ModelAndView("/company/list-companies");
        mv.addObject("companies", companyService.getCompanies());
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView createCompany() {
        ModelAndView mv = new ModelAndView("/company/create-company");
        mv.addObject("company", new Company());
        return mv;
    }
}
