package org.openlab.mapper;

import org.mapstruct.Mapper;
import org.openlab.dto.CustomerRequestDTO;
import org.openlab.dto.CustomerResponseDTO;
import org.openlab.entities.Customer;

@Mapper(componentModel="spring")
public interface CustomerMapper {
	
	CustomerResponseDTO customerTocustomerDTO(Customer customer);
	Customer  customerDTOTocustomer(CustomerRequestDTO customerRequestDTO);

}
