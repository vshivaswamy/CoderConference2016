package com.vinay.demo.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.demo.domain.customer.Customer;
import com.vinay.demo.service.customer.CustomerService;

/**
 * @author Vinay
 *
 */
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/customers", method = RequestMethod.GET, headers = { "Accept=application/json,application/xml" }, produces = {
			"application/json", "application/xml" })
	public List<Customer> getCustomers() throws Exception {
		List<Customer> customers = customerService.findAllCustomer();
		return customers;
	}
	
	@RequestMapping(value = "/customers/{criteria}", method = RequestMethod.GET, headers = { "Accept=application/json,application/xml" }, produces = {
			"application/json", "application/xml" })
	public Customer getCustomer(@PathVariable("criteria") String criteria) throws Exception {
		Customer customer = customerService.findCustomer(criteria);
		return customer;
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.POST, headers = { "Accept=application/json,application/xml" }, produces = {
			"application/json", "application/xml" })
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.POST, headers = { "Accept=application/json,application/xml" }, produces = {
			"application/json", "application/xml" })
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
}
