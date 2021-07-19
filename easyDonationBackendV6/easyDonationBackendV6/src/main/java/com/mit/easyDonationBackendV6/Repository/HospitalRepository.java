package com.mit.easyDonationBackendV6.Repository;

import com.mit.easyDonationBackendV6.Model.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface HospitalRepository extends MongoRepository<Hospital, String> {
    Optional<Hospital> findByUserName(String userName);
}
