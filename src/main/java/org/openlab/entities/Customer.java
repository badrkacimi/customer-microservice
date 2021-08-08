package org.openlab.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data  @AllArgsConstructor@NoArgsConstructor
public class Customer {
@Id
	private  String id;

	private String name;
	private String email;
}
