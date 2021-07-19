package com.mit.easyDonationBackendV6.Service;

import com.mit.easyDonationBackendV6.Dto.VendorBudgetDto;
import com.mit.easyDonationBackendV6.Dto.VendorRequirementViewDto;
import com.mit.easyDonationBackendV6.Dto.VendorStatisticsDto;

import java.util.List;

public interface VendorService {
    List<VendorRequirementViewDto> viewRequirements();
    void submitBudgetDetails(VendorBudgetDto vendorBudgetDto);
    VendorStatisticsDto getStatistics();
}
