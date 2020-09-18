package br.com.devjony.billingcompany.controller;

import br.com.devjony.billingcompany.entity.BorrowerEntity;
import br.com.devjony.billingcompany.entity.Debt;
import br.com.devjony.billingcompany.service.BorrowerService;
import br.com.devjony.billingcompany.service.CompanyService;
import br.com.devjony.billingcompany.service.DebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
@RequestMapping("/debts")
public class DebtController {

    @Autowired
    BorrowerService borrowerService;

    @Autowired
    DebtService debtService;

    @Autowired
    CompanyService companyService;

    @GetMapping("/create/{cpf}")
    public ModelAndView createDebt(@PathVariable("cpf") String cpf) {
        ModelAndView mv = new ModelAndView("/debt/create-debt");
        mv.addObject("borrower", borrowerService.findByCpf(cpf));
        mv.addObject("debt", new Debt());
        mv.addObject("companies", companyService.getCompanies());
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView getDebtPaymentTypes(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("/debt/list-debts-payment-types");
        mv.addObject("debt", debtService.findDebitById(id));
        return mv;
    }

    @GetMapping
    public ModelAndView getDebtsByBorrowerCpf(@RequestParam String cpf) {
        ModelAndView mv = new ModelAndView("/debt/list-debts");
        mv.addObject("debtsList", debtService.findDebitsByBorrowerCpf(cpf));
        mv.addObject("cpf", cpf);
        return mv;
    }

    @PostMapping
    public String saveDebt(@RequestParam Integer id, Integer company, BigDecimal value) {
        debtService.createDebt(company, id, value);
        return "redirect:/";
    }
}
