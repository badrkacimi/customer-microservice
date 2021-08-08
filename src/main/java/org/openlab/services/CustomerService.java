package org.openlab.services;

import java.util.List;

import org.openlab.dto.CustomerRequestDTO;
import org.openlab.dto.CustomerResponseDTO;

public interface  CustomerService {

	CustomerResponseDTO  save(CustomerRequestDTO  customerRequestDTO) ;
	
	CustomerResponseDTO  getCustomer(String  id) ;

	List<CustomerResponseDTO>  getCustomers() ;

	CustomerResponseDTO  update(CustomerRequestDTO  customerRequestDTO) ;

	CustomerResponseDTO  delete(String  id) ;

}
