package com.mit.easyDonationBackendV6.Service.ServiceImpl;

import com.mit.easyDonationBackendV6.Dto.*;
import com.mit.easyDonationBackendV6.Exception.CustomServiceException;
import com.mit.easyDonationBackendV6.Model.HospitalRequirement;
import com.mit.easyDonationBackendV6.Model.Vendor;
import com.mit.easyDonationBackendV6.Model.VendorBudget;
import com.mit.easyDonationBackendV6.Repository.HospitalRequirementRepository;
import com.mit.easyDonationBackendV6.Repository.VendorBudgetRepository;
import com.mit.easyDonationBackendV6.Repository.VendorRepository;
import com.mit.easyDonationBackendV6.Service.VendorService;
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
public class VendorServiceImpl implements VendorService {
    private final HospitalRequirementRepository hospitalRequirementRepository;
    private final VendorRepository vendorRepository;
    private final VendorBudgetRepository vendorBudgetRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<VendorViewRequirementsDto> viewRequirements() {
        List<HospitalRequirement> hospitalRequirementList = hospitalRequirementRepository.findAllByRequirementStatusAndDonationStatus(1,0);
        List<VendorViewRequirementsDto> vendorViewRequirementsDtoList = new ArrayList<>();
        for (HospitalRequirement hospitalRequirement:hospitalRequirementList) {
            vendorViewRequirementsDtoList.add(new VendorViewRequirementsDto(hospitalRequirement.getId(),hospitalRequirement.getRequirementDescription(),hospitalRequirement.getQuantity(),
                    hospitalRequirement.getRequirementItem(),hospitalRequirement.getEstimatedCost(),hospitalRequirement.getAdminApproval(),hospitalRequirement.getBrand(),
                    hospitalRequirement.getHospital()));

        }
        return vendorViewRequirementsDtoList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void submitBudgetDetails(VendorBudgetDto vendorBudgetDto) {
        HospitalRequirement hospitalRequirement = hospitalRequirementRepository.findById(vendorBudgetDto.getRequirementId()).orElseThrow(() -> new CustomServiceException("You have selected a Wrong requirement"));
        Vendor vendor = vendorRepository.findByUserName(vendorBudgetDto.getVendorUserName()).orElseThrow(() -> new CustomServiceException("userName is not valid"));

        VendorBudget vendorBudget = new VendorBudget(vendorBudgetDto.getPricePerOneItem(), vendorBudgetDto.getQuantity(), 0,
                hospitalRequirement, vendor);
        vendorBudgetRepository.save(vendorBudget);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public VendorStatisticsDto getStatistics(VendorUserNameDto vendorUserNameDto) {
        Vendor vendor = vendorRepository.findByUserName(vendorUserNameDto.getUserName()).orElseThrow(() -> new CustomServiceException("Vendor not found"));
        long vendorBudgetCount =  vendorBudgetRepository.countByVendor(vendor);
        int noOfBudgetSubmissions = (int) vendorBudgetCount;
        System.out.print("is"+noOfBudgetSubmissions);

        int noOfPurchases=1;

        return new VendorStatisticsDto(noOfBudgetSubmissions,noOfPurchases);
    }
}
