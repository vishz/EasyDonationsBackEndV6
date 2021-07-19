package com.mit.easyDonationBackendV6.Service;

import com.mit.easyDonationBackendV6.Dto.AdminApprovalBudgetDto;
import com.mit.easyDonationBackendV6.Dto.LandingPageViewRequirementDto;
import com.mit.easyDonationBackendV6.Dto.RequirementIdDto;
import com.mit.easyDonationBackendV6.Model.HospitalRequirement;

import java.util.List;

public interface AdminService {
    void acceptRequirement(RequirementIdDto requirementIdDto);
    void rejectRequirement(RequirementIdDto requirementIdDto);
    void approveBudget(AdminApprovalBudgetDto adminApprovalBudgetDto);
    void rejectBudget(AdminApprovalBudgetDto adminApprovalBudgetDto);
    List<LandingPageViewRequirementDto> getPendingRequirements();
}
