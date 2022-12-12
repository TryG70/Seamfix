package com.bvn.bvnvalidationservice.repository;

import com.bvn.bvnvalidationservice.entity.Bvn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BVNRepository extends MongoRepository<Bvn, UUID> {
}
