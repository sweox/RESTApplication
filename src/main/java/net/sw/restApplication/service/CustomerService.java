package net.sw.restApplication.service;

import net.sw.restApplication.model.Customer;

import java.util.List;

/**
 * Created by BELSHINA on 23.05.2018.
 */
public interface CustomerService {
    Customer getById(Long id);
    void save(Customer customer);
    void delete(Long id);
    List<Customer> getAll();
}
