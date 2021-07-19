package com.mit.easyDonationBackendV6.Service.ServiceImpl;

import com.mit.easyDonationBackendV6.Dto.AdminApprovalBudgetDto;
import com.mit.easyDonationBackendV6.Dto.RequirementIdDto;
import com.mit.easyDonationBackendV6.Exception.CustomServiceException;
import com.mit.easyDonationBackendV6.Model.HospitalRequirement;
import com.mit.easyDonationBackendV6.Model.VendorBudget;
import com.mit.easyDonationBackendV6.Repository.HospitalRequirementRepository;
import com.mit.easyDonationBackendV6.Repository.VendorBudgetRepository;
import com.mit.easyDonationBackendV6.Service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final HospitalRequirementRepository hospitalRequirementRepository;
    private final VendorBudgetRepository vendorBudgetRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void acceptRequirement(RequirementIdDto requirementIdDto) {
        HospitalRequirement hospitalRequirement = hospitalRequirementRepository.findById(requirementIdDto.getId()).orElseThrow(() -> new CustomServiceException("You have not selected the requirement properly "));
        hospitalRequirement.setAdminApproval(2);
        hospitalRequirementRepository.save(hospitalRequirement);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void rejectRequirement(RequirementIdDto requirementIdDto) {
        HospitalRequirement hospitalRequirement = hospitalRequirementRepository.findById(requirementIdDto.getId()).orElseThrow(() -> new CustomServiceException("You have not selected the requirement properly "));
        hospitalRequirement.setAdminApproval(1);
        hospitalRequirementRepository.save(hospitalRequirement);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void approveBudget(AdminApprovalBudgetDto adminApprovalBudgetDto) {
        VendorBudget vendorBudget = vendorBudgetRepository.findById(adminApprovalBudgetDto.getBudgetId()).orElseThrow(() -> new CustomServiceException("You have not selected the budget properly "));
        vendorBudget.setAdminApproval(2);
        vendorBudgetRepository.save(vendorBudget);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void rejectBudget(AdminApprovalBudgetDto adminApprovalBudgetDto) {
        VendorBudget vendorBudget = vendorBudgetRepository.findById(adminApprovalBudgetDto.getBudgetId()).orElseThrow(() -> new CustomServiceException("You have not selected the budget properly "));
        vendorBudget.setAdminApproval(1);
        vendorBudgetRepository.save(vendorBudget);
    }
}
