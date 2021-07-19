package com.mit.easyDonationBackendV6.Repository;

import com.mit.easyDonationBackendV6.Model.HospitalCategory;
import com.mit.easyDonationBackendV6.Model.VendorCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VendorCategoryRepository extends MongoRepository<VendorCategory,String> {
    Optional<VendorCategory> findByCategoryName(String categoryName);
}
