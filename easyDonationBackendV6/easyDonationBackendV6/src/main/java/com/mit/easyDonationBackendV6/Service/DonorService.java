package com.mit.easyDonationBackendV6.Service;

import com.mit.easyDonationBackendV6.Dto.*;
import com.mit.easyDonationBackendV6.Model.Donor;
import com.mit.easyDonationBackendV6.Model.HospitalRequirement;

import java.util.List;

public interface DonorService {

    void donate(DonateDto donateDto);
    int donationsCount(DonorUserNameDto donorUserNameDto);
    List<DonationDto> getRelevantDonationDetails(DonorUserNameDto donorUserNameDto);
    List<BudgetVendorDetailsDto> getBudgetsRelatedToRequirements(RequirementIdDto requirementIdDto);
    void giveFeedBack(FeedBackDto feedBackDto);



}
