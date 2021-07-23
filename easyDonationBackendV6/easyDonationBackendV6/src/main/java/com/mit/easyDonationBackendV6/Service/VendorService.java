package com.mit.easyDonationBackendV6.Service;

import com.mit.easyDonationBackendV6.Dto.*;

import java.util.List;

public interface VendorService {
    //List<VendorRequirementViewDto> viewRequirements();
    void submitBudgetDetails(VendorBudgetDto vendorBudgetDto);
    VendorStatisticsDto getStatistics(VendorUserNameDto vendorUserNameDto);
    List<VendorViewRequirementsDto> viewRequirements();
}
