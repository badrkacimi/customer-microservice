package org.openlab.services;

import java.util.List;
import java.util.stream.Collectors;

import org.openlab.dto.CustomerRequestDTO;
import org.openlab.dto.CustomerResponseDTO;
import org.openlab.entities.Customer;
import org.openlab.mapper.CustomerMapper;
import org.openlab.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	private CustomerMapper customerMapper;

	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {

		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;

	}

	@Override
	public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {

		Customer cusomer = customerMapper.customerDTOTocustomer(customerRequestDTO);
		Customer cusomerToSave = customerRepository.save(cusomer);
		CustomerResponseDTO customerResponseDTO = customerMapper.customerTocustomerDTO(cusomerToSave);

		return customerResponseDTO;
	}

	@Override
	public CustomerResponseDTO getCustomer(String id) {

		Customer cusomer = customerRepository.findById(id).get();
		CustomerResponseDTO customerResponseDTO = customerMapper.customerTocustomerDTO(cusomer);

		return customerResponseDTO;
	}

	@Override
	public List<CustomerResponseDTO> getCustomers() {

		List<Customer> listCustomers = customerRepository.findAll();

		List<CustomerResponseDTO> listCustomersDTO = 
				listCustomers.stream()
				.map(cust -> customerMapper.customerTocustomerDTO(cust))
				.collect(Collectors.toList());

		return listCustomersDTO;
	}

	@Override
	public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {

		Customer cusomer = customerMapper.customerDTOTocustomer(customerRequestDTO);
		Customer cusomerToUpdate = customerRepository.save(cusomer);
		CustomerResponseDTO customerResponseDTO = customerMapper.customerTocustomerDTO(cusomerToUpdate);

		return customerResponseDTO;
	}

	@Override
	public CustomerResponseDTO delete(String id) {

		Customer cusomer = customerRepository.findById(id).get();
		 customerRepository.delete(cusomer);
		CustomerResponseDTO customerResponseDTO = customerMapper.customerTocustomerDTO(cusomer);

		return customerResponseDTO;
	}

}
