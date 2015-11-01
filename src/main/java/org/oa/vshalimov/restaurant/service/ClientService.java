package org.oa.vshalimov.restaurant.service;

import org.oa.vshalimov.restaurant.model.Client;
import org.oa.vshalimov.restaurant.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("clients")
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody
    List<Client> loadAll() {
        return clientRepository.loadAll();
    }

    @RequestMapping(value = "{id}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody Client findById(@PathVariable("id") String id) {
        return clientRepository.findById(Integer.parseInt(id));
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.POST)
    public @ResponseBody Client create(@RequestBody Client client) {
        if (clientRepository.create(client)) {
            return client;
        } else {
            return null;
        }
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.PUT)
    public @ResponseBody Client update(@RequestBody Client client) {
        if (clientRepository.update(client)) {
            return client;
        } else {
            return null;
        }
    }

    @RequestMapping(produces = "application/json", consumes = "application/json" ,method = RequestMethod.DELETE)
    public @ResponseBody Client delete(@RequestBody Client client) {
        if (clientRepository.delete(client)) {
            return client;
        } else {
            return null;
        }
    }

}
