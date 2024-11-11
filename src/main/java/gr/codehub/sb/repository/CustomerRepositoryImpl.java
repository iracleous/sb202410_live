package gr.codehub.sb.repository;

import gr.codehub.sb.domain.Customer;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerRepositoryImpl implements CustomerRepository {

    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1L, "Thomas Varsamidis", "tv@codehub.gr", new Date(120, 0, 1)));
        customers.add(new Customer(2L, "Panos Varsamidis", "pv@cosmote.gr",new Date(120, 1, 1)));
        customers.add(new Customer(1_000_003L, "Alexis Tsipras", "alex@tsipras.com",new Date(100, 0, 1)));
    }


    public Customer findCustomerById(long id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return new ArrayList<>(customers);
    }

}
