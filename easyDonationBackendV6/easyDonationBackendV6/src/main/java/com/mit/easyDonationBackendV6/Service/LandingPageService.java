package com.mit.easyDonationBackendV6.Service;

import com.mit.easyDonationBackendV6.Dto.LandingPageStatisticsDto;
import com.mit.easyDonationBackendV6.Dto.LandingPageViewRequirementDto;

import java.util.List;

public interface LandingPageService {
    LandingPageStatisticsDto getLandingPageStatistics();
    List<LandingPageViewRequirementDto> getAllRequirements();
    List<LandingPageViewRequirementDto> getAllCompletedRequirements();
}
