package com.mit.easyDonationBackendV6.Service;

import com.mit.easyDonationBackendV6.Dto.AdminApprovalBudgetDto;
import com.mit.easyDonationBackendV6.Dto.RequirementIdDto;

public interface AdminService {
    void acceptRequirement(RequirementIdDto requirementIdDto);
    void rejectRequirement(RequirementIdDto requirementIdDto);
    void approveBudget(AdminApprovalBudgetDto adminApprovalBudgetDto);
    void rejectBudget(AdminApprovalBudgetDto adminApprovalBudgetDto);
}
