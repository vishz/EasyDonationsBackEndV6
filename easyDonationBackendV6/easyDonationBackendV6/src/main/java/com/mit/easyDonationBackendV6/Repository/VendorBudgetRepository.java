package com.mit.easyDonationBackendV6.Repository;

import com.mit.easyDonationBackendV6.Model.HospitalRequirement;
import com.mit.easyDonationBackendV6.Model.Vendor;
import com.mit.easyDonationBackendV6.Model.VendorBudget;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VendorBudgetRepository extends MongoRepository<VendorBudget,String> {
    Optional<VendorBudget> findById(String id);
    List<VendorBudget> findAll();
    List<VendorBudget> findAllByAdminApproval(int adminApproval);
    Long countByVendor(Vendor vendor);
    List<VendorBudget> findByHospitalRequirement(HospitalRequirement hospitalRequirement);
    Long countByHospitalRequirement(HospitalRequirement hospitalRequirement);
}
