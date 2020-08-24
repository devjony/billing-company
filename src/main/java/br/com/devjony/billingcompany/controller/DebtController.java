package br.com.devjony.billingcompany.controller;

import br.com.devjony.billingcompany.dto.FormDTO;
import br.com.devjony.billingcompany.service.CompanyService;
import br.com.devjony.billingcompany.service.DebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/debts")
public class DebtController {

    @Autowired
    DebtService debtService;

    @Autowired
    CompanyService companyService;

    @GetMapping
    public ModelAndView getCompanies() {
        ModelAndView mv = new ModelAndView("/home");
        mv.addObject("formDTO", new FormDTO());
        mv.addObject("companies", companyService.getCompanies());
        return mv;
    }

    @PostMapping
    public ModelAndView getDebtsByBorrowerCpf(FormDTO formDTO) {
        ModelAndView mv = new ModelAndView("/debt/list-debts");
        mv.addObject("debtsList", debtService.findDebitsByBorrowerCpf(formDTO.getCpf()));
        return mv;
    }

}