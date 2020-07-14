package guru.springframework.msscbrewery.services;

import java.util.UUID;

import guru.springframework.msscbrewery.web.model.CustomerDTO;

public interface CustomerService {

	CustomerDTO getCustomerById(UUID customerId);

}
