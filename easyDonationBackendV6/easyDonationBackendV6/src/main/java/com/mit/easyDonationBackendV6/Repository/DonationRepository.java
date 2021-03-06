package com.mit.easyDonationBackendV6.Repository;

import com.mit.easyDonationBackendV6.Model.Donation;
import com.mit.easyDonationBackendV6.Model.Donor;
import com.mit.easyDonationBackendV6.Model.HospitalRequirement;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DonationRepository extends MongoRepository<Donation,String> {
    List<Donation> findAll();
    Long countByDonor(Donor donor);
    List<Donation> findAllByDonor(Donor donor);
    List<Donation> findAllByHospitalRequirement(HospitalRequirement hospitalRequirement);


}
