package com.mit.easyDonationBackendV6.Service;

import com.mit.easyDonationBackendV6.Dto.*;

import java.util.List;

public interface HospitalService {
    void submitRequirement(HospitalRequirementSubmittingDto hospitalRequirementSubmittingDto);
    void updateRequirementSubmission(HospitalViewSubmissionsDto hospitalViewAllSubmissionsDto);
    void deleteRequirement(RequirementIdDto requirementIdDto);
    HospitalStatisticsDto getHospitalStatistics(HospitalUsernameDto hospitalUsernameDto);
    List<ViewHospitalRequirementDto> viewHospitalRequirements(HospitalUsernameDto hospitalUsernameDto);
}
