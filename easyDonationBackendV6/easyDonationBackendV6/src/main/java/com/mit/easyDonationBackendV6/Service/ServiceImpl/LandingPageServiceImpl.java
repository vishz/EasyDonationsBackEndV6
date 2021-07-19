package com.mit.easyDonationBackendV6.Service.ServiceImpl;

import com.mit.easyDonationBackendV6.Dto.LandingPageStatisticsDto;
import com.mit.easyDonationBackendV6.Dto.LandingPageViewRequirementDto;
import com.mit.easyDonationBackendV6.Dto.ViewHospitalRequirementDto;
import com.mit.easyDonationBackendV6.Model.HospitalRequirement;
import com.mit.easyDonationBackendV6.Repository.DonorRepository;
import com.mit.easyDonationBackendV6.Repository.HospitalRepository;
import com.mit.easyDonationBackendV6.Repository.HospitalRequirementRepository;
import com.mit.easyDonationBackendV6.Service.LandingPageService;
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
public class LandingPageServiceImpl implements LandingPageService {
    private final DonorRepository donorRepository;
    private final HospitalRepository hospitalRepository;
    private final HospitalRequirementRepository hospitalRequirementRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public LandingPageStatisticsDto getLandingPageStatistics() {
       int noOfDonors = 2;
       int noOfHospitals = 3;
       int noOfDonations = 5;
       int noOfRequirements = 10;
       int noOfOpenRequirements = 5;
       int noOfCloseRequirements = 5;
        return new LandingPageStatisticsDto(noOfDonors,noOfHospitals,
                noOfDonations,noOfRequirements,noOfOpenRequirements,noOfCloseRequirements);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<LandingPageViewRequirementDto> getAllRequirements() {
        List<HospitalRequirement> hospitalRequirementList = hospitalRequirementRepository.findAllByAdminApprovalAndDonationStatusAndRequirementStatus(2,0,1);
        List<LandingPageViewRequirementDto> landingPageViewRequirementDtoList = new ArrayList<>();
        for (HospitalRequirement hospitalRequirement:hospitalRequirementList) {
            landingPageViewRequirementDtoList.add(new LandingPageViewRequirementDto(hospitalRequirement.getRequirementDescription(),
                    hospitalRequirement.getQuantity(),hospitalRequirement.getRequirementItem(),hospitalRequirement.getEstimatedCost(),
                    hospitalRequirement.getBrand(),hospitalRequirement.getHospital()));

        }
        return landingPageViewRequirementDtoList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<LandingPageViewRequirementDto> getAllCompletedRequirements() {
        List<HospitalRequirement> hospitalRequirementList = hospitalRequirementRepository.findAllByAdminApprovalAndDonationStatusAndRequirementStatus(2,1,1);
        List<LandingPageViewRequirementDto> landingPageViewRequirementDtoList = new ArrayList<>();
        for (HospitalRequirement hospitalRequirement:hospitalRequirementList) {
            landingPageViewRequirementDtoList.add(new LandingPageViewRequirementDto(hospitalRequirement.getRequirementDescription(),
                    hospitalRequirement.getQuantity(),hospitalRequirement.getRequirementItem(),hospitalRequirement.getEstimatedCost(),
                    hospitalRequirement.getBrand(),hospitalRequirement.getHospital()));

        }
        return landingPageViewRequirementDtoList;
    }
}
