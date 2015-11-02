package org.oa.vshalimov.restaurant.service;

import org.oa.vshalimov.restaurant.model.Dish;
import org.oa.vshalimov.restaurant.model.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/dishes")
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody List<Dish> loadAll() {
        return dishRepository.loadAll();
    }

    @RequestMapping(value = "{id}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody Dish findById(@PathVariable("id") String id) {
        return dishRepository.findById(Integer.parseInt(id));
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.POST)
    public @ResponseBody Dish create(@RequestBody Dish dish) {
        if (dishRepository.create(dish)) {
            return dish;
        } else {
            return null;
        }
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.PUT)
    public @ResponseBody Dish update(@RequestBody Dish dish) {
        if (dishRepository.update(dish)) {
            return dish;
        } else {
            return null;
        }
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.DELETE)
    public @ResponseBody Dish delete(@RequestBody Dish dish) {
        if (dishRepository.delete(dish)) {
            return dish;
        } else {
            return null;
        }
    }

}