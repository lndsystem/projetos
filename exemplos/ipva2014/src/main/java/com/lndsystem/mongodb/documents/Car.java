package com.lndsystem.mongodb.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ipva2014")
public class Car {

	@Id
	@Field(value = "_id")
	private String id;

	@Field(value = "PLACA")
	private String placa;

	@Field(value = "CHASSI")
	private String chassi;

	public String getId() {
		return id;
	}

	public String getPlaca() {
		return placa;
	}

	public String getChassi() {
		return chassi;
	}

}
