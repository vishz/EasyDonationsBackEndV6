package com.mit.easyDonationBackendV6.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonateDto {

    private String requirementId;
    private String userName;
    private String bankName;
    private String cardNumber;
    private String expireDate;
    private String cvvNumber;
    private String donationAmount;
    private String donationType;

}
