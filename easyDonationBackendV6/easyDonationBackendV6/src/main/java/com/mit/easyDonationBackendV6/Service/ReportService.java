package com.mit.easyDonationBackendV6.Service;

import com.mit.easyDonationBackendV6.Dto.DonorUserNameDto;
import com.mit.easyDonationBackendV6.Dto.HospitalUsernameDto;
import com.mit.easyDonationBackendV6.Dto.ReportXYDto;

import java.util.List;

public interface ReportService {
    List<ReportXYDto> getDonationTimeDetails();
    List<ReportXYDto> getDonationRequestsTimeDetails();
    List<ReportXYDto> getBudgetTimeDetails();
    List<ReportXYDto> getRequirementsAmountDetails(HospitalUsernameDto hospitalUsernameDto);
    List<ReportXYDto> getRequirementsBudgetDetails();
    List<ReportXYDto> getTimeDonationsDetails(DonorUserNameDto donorUserNameDto);
}
