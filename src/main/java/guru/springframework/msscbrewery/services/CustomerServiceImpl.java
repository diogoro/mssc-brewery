package guru.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.CustomerDTO;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDTO getCustomerById(UUID customerId) {
		return CustomerDTO.builder().id(UUID.randomUUID())
				.customerName("Marcos Oliveira")
				.build();
	}

}
