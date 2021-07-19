package com.mit.easyDonationBackendV6.Service.ServiceImpl;

import com.mit.easyDonationBackendV6.Dto.*;
import com.mit.easyDonationBackendV6.Exception.CustomServiceException;
import com.mit.easyDonationBackendV6.Model.Hospital;
import com.mit.easyDonationBackendV6.Model.HospitalRequirement;
import com.mit.easyDonationBackendV6.Repository.HospitalRepository;
import com.mit.easyDonationBackendV6.Repository.HospitalRequirementRepository;
import com.mit.easyDonationBackendV6.Service.HospitalService;
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
public class HospitalServiceImplementation implements HospitalService {
    private final HospitalRequirementRepository hospitalRequirementRepository;
    private final HospitalRepository hospitalRepository;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void submitRequirement(HospitalRequirementSubmittingDto hospitalRequirementSubmittingDto) {
        Hospital hospital = hospitalRepository.findByUserName(hospitalRequirementSubmittingDto.getHospitalUserName()).orElseThrow(() -> new CustomServiceException(" Hospital not found"));
        HospitalRequirement hospitalRequirement = new HospitalRequirement(hospitalRequirementSubmittingDto.getRequirementDescription()
                , hospitalRequirementSubmittingDto.getQuantity(), hospitalRequirementSubmittingDto.getRequirementItem(), hospitalRequirementSubmittingDto.getEstimatedCost(), hospitalRequirementSubmittingDto.getBrand(),
                1,0, 0,
                hospital);
        hospitalRequirementRepository.save(hospitalRequirement);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateRequirementSubmission(HospitalViewSubmissionsDto hospitalViewSubmissionsDto) {
    HospitalRequirement hospitalRequirement = hospitalRequirementRepository.findById(hospitalViewSubmissionsDto.getId()).orElseThrow(() -> new CustomServiceException("You have not selected the requirement properly "));
    hospitalRequirement.setRequirementDescription(hospitalViewSubmissionsDto.getRequirementDescription());
    hospitalRequirement.setQuantity(hospitalViewSubmissionsDto.getQuantity());
    hospitalRequirement.setRequirementItem(hospitalViewSubmissionsDto.getRequirementItem());
    hospitalRequirement.setEstimatedCost(hospitalViewSubmissionsDto.getEstimatedCost());
    hospitalRequirement.setBrand(hospitalRequirement.getBrand());
    hospitalRequirementRepository.save(hospitalRequirement);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteRequirement(RequirementIdDto requirementIdDto) {
        HospitalRequirement hospitalRequirement = hospitalRequirementRepository.findById(requirementIdDto.getId()).orElseThrow(() -> new CustomServiceException("You have not selected the requirement properly "));
        hospitalRequirement.setRequirementStatus(0);
        hospitalRequirementRepository.save(hospitalRequirement);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public HospitalStatisticsDto getHospitalStatistics(HospitalUsernameDto hospitalUsernameDto) {
        Hospital hospital = hospitalRepository.findByUserName(hospitalUsernameDto.getUserName()).orElseThrow(() -> new CustomServiceException(" Hospital not found"));
        Long numberOfAllRequirements = hospitalRequirementRepository.countByHospital(hospital);
        Long numberOfCompletedRequirements = hospitalRequirementRepository.countByHospitalAndDonationStatus(hospital,1);
        Long numberOfPendingRequirements = hospitalRequirementRepository.countByHospitalAndDonationStatus(hospital,0);
        return new HospitalStatisticsDto(numberOfAllRequirements,numberOfCompletedRequirements,numberOfPendingRequirements);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<ViewHospitalRequirementDto> viewHospitalRequirements(HospitalUsernameDto hospitalUsernameDto) {
        Hospital hospital = hospitalRepository.findByUserName(hospitalUsernameDto.getUserName()).orElseThrow(() -> new CustomServiceException(" Hospital not found"));
        List<HospitalRequirement> hospitalRequirementList = hospitalRequirementRepository.findAllByHospitalAndRequirementStatus(hospital,1);
        List<ViewHospitalRequirementDto> hospitalRequirementDtoList = new ArrayList<>();
        for (HospitalRequirement hospitalRequirement:hospitalRequirementList) {
            hospitalRequirementDtoList.add(new ViewHospitalRequirementDto(hospitalRequirement.getId(),hospitalRequirement.getRequirementDescription(),hospitalRequirement.getQuantity(),
                    hospitalRequirement.getRequirementItem(),hospitalRequirement.getEstimatedCost(),hospitalRequirement.getBrand(),hospitalRequirement.getAdminApproval(),
                    hospitalRequirement.getDonationStatus(),hospital));
            
        }
        return hospitalRequirementDtoList;
    }
}
