package com.mit.easyDonationBackendV6.Service.ServiceImpl;

import com.mit.easyDonationBackendV6.Dto.VendorBudgetDto;
import com.mit.easyDonationBackendV6.Dto.VendorRequirementViewDto;
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
    public List<VendorRequirementViewDto> viewRequirements() {
        return null;
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
}
