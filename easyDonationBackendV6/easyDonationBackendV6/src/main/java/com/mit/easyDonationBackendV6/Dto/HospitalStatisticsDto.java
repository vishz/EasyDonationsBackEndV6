package com.mit.easyDonationBackendV6.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalStatisticsDto {

    private long numberOfAllRequirements;
    private long numberOfCompletedRequirements;
    private long numberOfPendingRequirements;

}
