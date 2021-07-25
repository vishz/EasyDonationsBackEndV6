package com.mit.easyDonationBackendV6.Dto;

import com.mit.easyDonationBackendV6.Model.Donor;
import com.mit.easyDonationBackendV6.Model.HospitalRequirement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonationDto {
    private String donationType;
    private String donationAmount;
    private Donor donor;
    private HospitalRequirement hospitalRequirement;

    public DonationDto( String donationType, String donationAmount,  HospitalRequirement hospitalRequirement) {
        this.donationType = donationType;
        this.donationAmount = donationAmount;
        this.hospitalRequirement = hospitalRequirement;
    }
}
