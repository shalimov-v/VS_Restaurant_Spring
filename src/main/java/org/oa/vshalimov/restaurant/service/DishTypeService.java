package org.oa.vshalimov.restaurant.service;

import org.oa.vshalimov.restaurant.model.DishType;
import org.oa.vshalimov.restaurant.model.repository.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("dishTypes")
public class DishTypeService {

    @Autowired
    private DishTypeRepository dishTypeRepository;

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody List<DishType> loadAll() {
        return dishTypeRepository.loadAll();
    }

    @RequestMapping(value = "{id}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody DishType findById(@PathVariable("id") String id) {
        return dishTypeRepository.findById(Integer.parseInt(id));
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.POST)
    public @ResponseBody DishType create(@RequestBody DishType dishType) {
        if (dishTypeRepository.create(dishType)) {
            return dishType;
        } else {
            return null;
        }
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.PUT)
    public @ResponseBody DishType update(@RequestBody DishType dishType) {
        if (dishTypeRepository.update(dishType)) {
            return dishType;
        } else {
            return dishType;
        }
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.DELETE)
    public @ResponseBody DishType delete(@RequestBody DishType dishType) {
        if (dishTypeRepository.delete(dishType)) {
            return dishType;
        } else {
            return null;
        }
    }

}
