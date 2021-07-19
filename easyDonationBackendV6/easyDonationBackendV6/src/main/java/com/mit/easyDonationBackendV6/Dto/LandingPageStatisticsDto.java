package com.mit.easyDonationBackendV6.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LandingPageStatisticsDto {
    private int noOfDonors;
    private int noOfHospitals;
    private int noOfDonations;
    private int noOfRequirements;
    private int noOfOpenRequirements;
    private int noOfCloseRequirements;
}
