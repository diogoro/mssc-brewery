package guru.springframework.msscbrewery.web.mappers;

import org.mapstruct.Mapper;

import guru.springframework.msscbrewery.domain.Customer;
import guru.springframework.msscbrewery.web.model.CustomerDTO;

@Mapper
public interface CustomerMapper {

	CustomerDTO customerToCustomerDto(Customer customer);
	
	Customer customerDtoToCustomer(CustomerDTO customerDto); 
}
