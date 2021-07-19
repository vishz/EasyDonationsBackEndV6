package com.mit.easyDonationBackendV6.Repository;

import com.mit.easyDonationBackendV6.Model.Donor;
import com.mit.easyDonationBackendV6.Model.HospitalCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface HospitalCategoryRepository extends MongoRepository<HospitalCategory,String> {
    Optional<HospitalCategory> findByCategoryName(String categoryName);
}
