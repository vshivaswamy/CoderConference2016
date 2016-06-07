package com.vinay.demo.service.customer;

import java.util.List;

import com.vinay.demo.domain.customer.Customer;

/**
 * @author Vinay
 *
 */
public interface CustomerService {
	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	Customer findCustomer(String criteria);

	List<Customer> findAllCustomer();
}
