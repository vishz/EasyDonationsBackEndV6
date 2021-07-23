package com.mit.easyDonationBackendV6.Repository;

import com.mit.easyDonationBackendV6.Model.Donor;
import com.mit.easyDonationBackendV6.Model.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DonorRepository extends MongoRepository<Donor, String> {
    Optional<Donor> findByUserName(String userName);
    Long countAllByIdExists();
}
