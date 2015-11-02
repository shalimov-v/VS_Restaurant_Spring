package org.oa.vshalimov.restaurant.service;

import org.oa.vshalimov.restaurant.model.Discount;
import org.oa.vshalimov.restaurant.model.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/discounts")
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;


    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody
    List<Discount> loadAll() {
        return discountRepository.loadAll();
    }

    @RequestMapping(value = "{id}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody Discount findById(@PathVariable("id") String id) {
        return discountRepository.findById(Integer.parseInt(id));
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.POST)
    public @ResponseBody Discount create(@RequestBody Discount discount) {
        if (discountRepository.create(discount)) {
            return discount;
        } else {
            return null;
        }
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.PUT)
    public @ResponseBody Discount update(@RequestBody Discount discount) {
        if (discountRepository.update(discount)) {
            return discount;
        } else {
            return null;
        }
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.DELETE)
    public @ResponseBody Discount delete(@RequestBody Discount discount) {
        if (discountRepository.delete(discount)) {
            return discount;
        } else {
            return null;
        }
    }
}
