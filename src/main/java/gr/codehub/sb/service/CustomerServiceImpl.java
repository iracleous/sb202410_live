package gr.codehub.sb.service;

import gr.codehub.sb.domain.Customer;
import gr.codehub.sb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Customer findCustomerById(long id){
        Customer response = customerRepository.findCustomerById(id);
        if (isHiddenCustomer(response)) {
            return null;
        }
        return response;
    }

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> listOfCustomersFromDb = customerRepository.findAllCustomers();
        List<Customer> listOfCustomersToShow = new ArrayList<>();
        for (Customer c: listOfCustomersFromDb) {
            if (!isHiddenCustomer(c)) {
                listOfCustomersToShow.add(c);
            }
        }
        return listOfCustomersToShow;
    }

    public boolean isHiddenCustomer(Customer customer) {
        return customer.getId() >= 1_000_000;
    }
}
