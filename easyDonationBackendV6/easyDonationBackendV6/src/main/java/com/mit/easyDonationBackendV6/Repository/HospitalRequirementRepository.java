package com.mit.easyDonationBackendV6.Repository;

import com.mit.easyDonationBackendV6.Model.Admin;
import com.mit.easyDonationBackendV6.Model.Hospital;
import com.mit.easyDonationBackendV6.Model.HospitalRequirement;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface HospitalRequirementRepository extends MongoRepository<HospitalRequirement, String> {

        Optional<HospitalRequirement> findById(String id);
        Long countByHospital(Hospital hospital);
        Long countByHospitalAndDonationStatus(Hospital hospital,int donationStatus);
        List<HospitalRequirement> findAllByHospitalAndRequirementStatus(Hospital hospital, int requirementStatus);
        List<HospitalRequirement> findAllByAdminApprovalAndDonationStatusAndRequirementStatus(int AdminApproval, int DonationStatus,int RequirementStatus );
}
