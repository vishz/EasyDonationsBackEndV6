package com.mit.easyDonationBackendV6.Repository;

import com.mit.easyDonationBackendV6.Model.VendorBudget;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VendorBudgetRepository extends MongoRepository<VendorBudget,String> {
    Optional<VendorBudget> findById(String id);
}