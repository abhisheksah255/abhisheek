package com.abhisheksah.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abhisheksah.model.Owner;

public interface OwnerRepository extends MongoRepository<Owner, String> {

	
	Owner findByEmail(String email);
}
