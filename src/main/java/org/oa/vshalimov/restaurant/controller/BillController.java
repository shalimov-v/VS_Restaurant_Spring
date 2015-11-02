package org.oa.vshalimov.restaurant.controller;

import org.oa.vshalimov.restaurant.model.Bill;
import org.oa.vshalimov.restaurant.model.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("bills")
@Controller
public class BillController {

    @Autowired
    BillRepository billRepository;

    @RequestMapping(produces = "text/html", method = RequestMethod.GET)
    public String loadAll(Model model) {
        List<Bill> bills = billRepository.loadAll();
        model.addAttribute("bills", bills);
        return "bills";
    }

}
