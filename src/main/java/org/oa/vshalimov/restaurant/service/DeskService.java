package org.oa.vshalimov.restaurant.service;

import org.oa.vshalimov.restaurant.model.Desk;
import org.oa.vshalimov.restaurant.model.repository.DeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/desks")
public class DeskService {

    @Autowired
    private DeskRepository deskRepository;


    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody List<Desk> loadAll() {
        return deskRepository.loadAll();
    }

    @RequestMapping(value = "{id}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody Desk findById(@PathVariable("id") String id) {
        return deskRepository.findById(Integer.parseInt(id));
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.POST)
    public @ResponseBody Desk create(@RequestBody Desk desk) {
        if (deskRepository.create(desk)) {
            return desk;
        } else {
            return null;
        }
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.PUT)
    public @ResponseBody Desk update(@RequestBody Desk desk) {
        if (deskRepository.update(desk)) {
            return desk;
        } else {
            return null;
        }
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.DELETE)
    public @ResponseBody Desk delete(@RequestBody Desk desk) {
        if (deskRepository.delete(desk)) {
            return desk;
        } else {
            return null;
        }
    }

}