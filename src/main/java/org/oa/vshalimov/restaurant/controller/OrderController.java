package org.oa.vshalimov.restaurant.controller;

import org.oa.vshalimov.restaurant.model.Orders;
import org.oa.vshalimov.restaurant.model.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("orders")
@Controller
public class OrderController {

    @Autowired
    OrdersRepository ordersRepository;

    @RequestMapping(value = "{id}", produces = "text/html", method = RequestMethod.GET)
    public String findByBillId(@PathVariable("id") String id, Model model) {
        List<Orders> orders = ordersRepository.findByBillId(Integer.parseInt(id));
        model.addAttribute("orders", orders);
        return "order";
    }

}
