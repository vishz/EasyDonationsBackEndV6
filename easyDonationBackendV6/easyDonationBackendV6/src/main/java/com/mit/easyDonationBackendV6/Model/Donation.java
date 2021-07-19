package com.mit.easyDonationBackendV6.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "Donation")
public class Donation {
    @Id
    private String id;
    private String donationType;
    private String donationAmount;
    private Donor donor;
    private HospitalRequirement hospitalRequirement;

    public Donation(String donationType, String donationAmount, Donor donor, HospitalRequirement hospitalRequirement) {
        this.donationType = donationType;
        this.donationAmount = donationAmount;
        this.donor = donor;
        this.hospitalRequirement = hospitalRequirement;
    }
}
