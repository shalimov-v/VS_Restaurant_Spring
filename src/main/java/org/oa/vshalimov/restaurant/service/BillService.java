package org.oa.vshalimov.restaurant.service;

import org.oa.vshalimov.restaurant.model.Bill;
import org.oa.vshalimov.restaurant.model.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/bills")
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody
    List<Bill> loadAll() {
        return billRepository.loadAll();
    }

    @RequestMapping(value = "{id}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody Bill findById(@PathVariable("id") String id) {
        return billRepository.findById(Integer.parseInt(id));
    }

    @RequestMapping(produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody Bill create(@RequestBody Bill bill) {
        if (billRepository.create(bill)) {
            return bill;
        } else {
            return null;
        }
    }

    @RequestMapping(produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
    public @ResponseBody Bill update(@RequestBody Bill bill) {
        if (billRepository.update(bill)) {
            return bill;
        } else {
            return null;
        }
    }

    @RequestMapping(produces = "application/json", consumes = "application/json", method = RequestMethod.DELETE)
    public @ResponseBody Bill delete(@RequestBody Bill bill) {
        if (billRepository.delete(bill)) {
            return bill;
        } else {
            return null;
        }
    }

}
