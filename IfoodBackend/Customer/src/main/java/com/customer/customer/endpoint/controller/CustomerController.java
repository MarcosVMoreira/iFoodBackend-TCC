package com.customer.customer.endpoint.controller;

import com.customer.customer.endpoint.error.ResourceNotFoundException;
import com.customer.customer.endpoint.model.DTO.CustomerDTO;
import com.customer.customer.endpoint.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> listAll () {
        return customerService.listAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerById (@PathVariable String id) {
        verifyIfCustomerExistsById(id);
        return customerService.getCustomerById(id);
    }

    @GetMapping("findByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getCustomerByName (@PathVariable String name) {
        verifyIfCustomerExistsByName(name);
        return customerService.findCustomerByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public CustomerDTO save (@Valid @RequestBody CustomerDTO customerDTO) {
        return customerService.save(customerDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public CustomerDTO update (@Valid @RequestBody CustomerDTO customerDTO) {
        verifyIfCustomerExistsById(customerDTO.getId());
        return customerService.update(customerDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void delete (@PathVariable String id) {
        verifyIfCustomerExistsById(id);
        customerService.delete(id);
    }

    private void verifyIfCustomerExistsById(String id) {
        if (customerService.getCustomerById(id) == null) {
            throw new ResourceNotFoundException("Customer not found for ID: "+id);
        }
    }

    private void verifyIfCustomerExistsByName(String name) {
        if (customerService.findCustomerByName(name) == null) {
            throw new ResourceNotFoundException("Customer not found for name: "+name);
        }
    }

}
