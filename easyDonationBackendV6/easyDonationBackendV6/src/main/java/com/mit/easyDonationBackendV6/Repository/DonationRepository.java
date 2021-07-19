package com.mit.easyDonationBackendV6.Repository;

import com.mit.easyDonationBackendV6.Model.Donation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DonationRepository extends MongoRepository<Donation,String> {
    List<Donation> findAll();

}
