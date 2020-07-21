package guru.springframework.msscbrewery.web.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDTO;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping({ "/{customerId}" })
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("customerId") UUID customerId) {
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping
	public ResponseEntity createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
		CustomerDTO saveDto = customerService.saveNewCustomer(customerDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/customer/" + saveDto.getId().toString() );
		
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping({ "/{customerId}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCustomer(@Valid @RequestBody CustomerDTO customerDTO, @PathVariable("customerId") UUID customerId) {
		customerService.updateCustomer(customerId, customerDTO);
	}
	
	@DeleteMapping({ "/{customerId}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
		customerService.deleteCustomerById(customerId);
	}
}
