package org.openlab.web;

import java.util.List;
import java.util.UUID;

import org.openlab.dto.CustomerRequestDTO;
import org.openlab.dto.CustomerResponseDTO;
import org.openlab.services.CustomerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/api")
public class CustomerRestController {

	private CustomerService  customerService;
	
	public CustomerRestController( CustomerService  customerService) {
		
		this.customerService=customerService;
	}
	
		@GetMapping(path="/customers")		
	    public List<CustomerResponseDTO> customers(){
			
	        return customerService.getCustomers();
	    }

	
	
	@RequestMapping(path="/customers/{id}")
    public CustomerResponseDTO customerById(@PathVariable  String id ){
	
        return customerService.getCustomer(id);
        
    }

	
	
	@PostMapping(path="/customers")
    public CustomerResponseDTO save( @RequestBody CustomerRequestDTO  customerRequestDTO ){
		customerRequestDTO.setId(UUID.randomUUID());
        return customerService.save(customerRequestDTO);
        
    }
	
	@PutMapping(path="/customers/update/{id}")
    public CustomerResponseDTO update( @RequestBody CustomerRequestDTO  customerRequestDTO,@PathVariable  String id){
		
        return customerService.save(customerRequestDTO);
        
    }
	
	@DeleteMapping(path="/customers/update/{id}")
    public CustomerResponseDTO delete( @PathVariable  String id){
		
        return customerService.delete(id);
        
    }
	
}
