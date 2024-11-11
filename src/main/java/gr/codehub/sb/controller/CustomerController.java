package gr.codehub.sb.controller;

import gr.codehub.sb.domain.Customer;
import gr.codehub.sb.service.CustomerService;
import gr.codehub.sb.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("{customerId}")
    public Customer findCustomerById(@PathVariable long customerId){
        Customer response = customerService.findCustomerById(customerId);
        return response;
    }
}
