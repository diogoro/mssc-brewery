package guru.springframework.msscbrewery.services;

import java.util.UUID;

import guru.springframework.msscbrewery.web.model.CustomerDTO;

public interface CustomerService {

	CustomerDTO getCustomerById(UUID customerId);

	CustomerDTO saveNewCustomer(CustomerDTO customerDTO);

	void updateCustomer(UUID customerId, CustomerDTO customerDTO);

	void deleteCustomerById(UUID customerId);

}
