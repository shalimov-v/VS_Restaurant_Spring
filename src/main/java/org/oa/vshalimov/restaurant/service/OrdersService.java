package org.oa.vshalimov.restaurant.service;

import org.oa.vshalimov.restaurant.model.Orders;
import org.oa.vshalimov.restaurant.model.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/orders")
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody
    List<Orders> loadAll() {
        return ordersRepository.loadAll();
    }

    @RequestMapping(value = "{id}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody List<Orders> findByBillId(@PathVariable("id") String id) {
        return ordersRepository.findByBillId(Integer.parseInt(id));
    }

    @RequestMapping(value = "{billId}/{menuId}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody Orders findMenuItemInBill(@PathVariable("billId") String billId, @PathVariable("menuId") String menuId) {
        return ordersRepository.findMenuItemByBillId(Integer.parseInt(billId), Integer.parseInt(menuId));
    }

    @RequestMapping(produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody Orders create(@RequestBody Orders bill) {
        if (ordersRepository.create(bill)) {
            return bill;
        } else {
            return null;
        }
    }

}
