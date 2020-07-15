package guru.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDTO getCustomerById(UUID customerId) {
		return CustomerDTO.builder().id(UUID.randomUUID())
				.customerName("Marcos Oliveira")
				.build();
	}

	@Override
	public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
		return CustomerDTO.builder().id(UUID.randomUUID())
				.customerName("Rodolfo")
				.build();
	}

	@Override
	public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		log.debug("Update Customer");
	}

	@Override
	public void deleteCustomerById(UUID customerId) {
		// TODO Auto-generated method stub
		log.debug("Delete customer");
	}

}
