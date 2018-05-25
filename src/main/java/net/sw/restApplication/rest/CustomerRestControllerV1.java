package net.sw.restApplication.rest;

import net.sw.restApplication.model.Customer;
import net.sw.restApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;


@Component
@RestController
@RequestMapping("/api/v1/customers/")
public class CustomerRestControllerV1 {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> getCustomer(
            @PathVariable("id") Long customerId) {
        if(customerId == null) {
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }

        Customer customer = this.customerService.getById(customerId);
        if(customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> saveCustomer(
            @RequestBody @Valid Customer customer) {
        HttpHeaders headers = new HttpHeaders();

        if(customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }

        this.customerService.save(customer);
        return new ResponseEntity<Customer>(customer, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> updateCustomer(
            @RequestBody @Valid Customer customer, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if(customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }

        this.customerService.save(customer);

        return new ResponseEntity<Customer>(customer, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id) {
        Customer customer = this.customerService.getById(id);
        if(customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        this.customerService.delete(id);

        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = this.customerService.getAll();

        if(customers.isEmpty()) {
            return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }
}
