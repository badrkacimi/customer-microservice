package org.openlab.mapper;

import javax.annotation.Generated;
import org.openlab.dto.CustomerRequestDTO;
import org.openlab.dto.CustomerResponseDTO;
import org.openlab.entities.Customer;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-08T15:58:51+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_172 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponseDTO customerTocustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();

        customerResponseDTO.setId( customer.getId() );
        customerResponseDTO.setName( customer.getName() );
        customerResponseDTO.setEmail( customer.getEmail() );

        return customerResponseDTO;
    }

    @Override
    public Customer customerDTOTocustomer(CustomerRequestDTO customerRequestDTO) {
        if ( customerRequestDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerRequestDTO.getId() );
        customer.setName( customerRequestDTO.getName() );
        customer.setEmail( customerRequestDTO.getEmail() );

        return customer;
    }
}
