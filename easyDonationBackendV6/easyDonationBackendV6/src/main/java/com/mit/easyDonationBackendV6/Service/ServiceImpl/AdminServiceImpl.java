package com.mit.easyDonationBackendV6.Service.ServiceImpl;

import com.mit.easyDonationBackendV6.Dto.*;
import com.mit.easyDonationBackendV6.Exception.CustomServiceException;
import com.mit.easyDonationBackendV6.Model.Donation;
import com.mit.easyDonationBackendV6.Model.HospitalRequirement;
import com.mit.easyDonationBackendV6.Model.VendorBudget;
import com.mit.easyDonationBackendV6.Repository.DonationRepository;
import com.mit.easyDonationBackendV6.Repository.HospitalRequirementRepository;
import com.mit.easyDonationBackendV6.Repository.VendorBudgetRepository;
import com.mit.easyDonationBackendV6.Service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final HospitalRequirementRepository hospitalRequirementRepository;
    private final VendorBudgetRepository vendorBudgetRepository;
    private final DonationRepository donationRepository;

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

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<LandingPageViewRequirementDto> getPendingRequirements() {
        List<HospitalRequirement> hospitalRequirementList = hospitalRequirementRepository.findAllByAdminApprovalAndDonationStatusAndRequirementStatus(0,0,1);
        List<LandingPageViewRequirementDto> landingPageViewRequirementDtoList = new ArrayList<>();
        for (HospitalRequirement hospitalRequirement:hospitalRequirementList) {
            landingPageViewRequirementDtoList.add(new LandingPageViewRequirementDto(hospitalRequirement.getId(),hospitalRequirement.getRequirementDescription(),
                    hospitalRequirement.getQuantity(),hospitalRequirement.getRequirementItem(),hospitalRequirement.getEstimatedCost(),
                    hospitalRequirement.getBrand(),hospitalRequirement.getHospital()));

        }
        return landingPageViewRequirementDtoList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<DonationDto> viewAllDonations() {
       List<Donation> donation = donationRepository.findAll();
       System.out.print(donation);
       List<DonationDto> donationDtoList = new ArrayList<>();
        for (Donation donation1: donation) {

            donationDtoList.add(new DonationDto(donation1.getDonationType(),donation1.getDonationAmount(),donation1.getDonor(),
                    donation1.getHospitalRequirement()));

        }
        return donationDtoList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<BudgetDetailsDto> viewAllBudgetDetails() {
        List<VendorBudget>  vendorBudgetList= vendorBudgetRepository.findAll();
        List<BudgetDetailsDto> budgetDetailsDtoList = new ArrayList<>();
        for (VendorBudget vendorBudget: vendorBudgetList) {
            budgetDetailsDtoList.add(new BudgetDetailsDto(vendorBudget.getPricePerOneItem(),vendorBudget.getQuantity(),
                    vendorBudget.getAdminApproval(),vendorBudget.getHospitalRequirement(),vendorBudget.getVendor()));

        }
        return budgetDetailsDtoList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<BudgetDetailsDto> viewPendingBudgetDetails() {
        List<VendorBudget>  vendorBudgetList= vendorBudgetRepository.findAllByAdminApproval(0);
        List<BudgetDetailsDto> budgetDetailsDtoList = new ArrayList<>();
        for (VendorBudget vendorBudget: vendorBudgetList) {
            budgetDetailsDtoList.add(new BudgetDetailsDto(vendorBudget.getId(),vendorBudget.getPricePerOneItem(),vendorBudget.getQuantity(),
                    vendorBudget.getAdminApproval(),vendorBudget.getHospitalRequirement(),vendorBudget.getVendor()));

        }
        return budgetDetailsDtoList;
    }
}
