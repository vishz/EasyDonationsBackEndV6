package com.mit.easyDonationBackendV6.Repository;

import com.mit.easyDonationBackendV6.Model.Admin;
import com.mit.easyDonationBackendV6.Model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VendorRepository extends MongoRepository<Vendor, String> {
    Optional<Vendor> findByUserName(String userName);
}
