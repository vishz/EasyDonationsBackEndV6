package com.mit.easyDonationBackendV6.Service.ServiceImpl;

import com.mit.easyDonationBackendV6.Dto.*;
import com.mit.easyDonationBackendV6.Exception.CustomServiceException;
import com.mit.easyDonationBackendV6.Model.*;
import com.mit.easyDonationBackendV6.Repository.*;
import com.mit.easyDonationBackendV6.Service.DonorService;
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
public class DonorServiceImpl implements DonorService {

    private final DonorRepository donorRepository;
    private final HospitalRequirementRepository hospitalRequirementRepository;
    private final DonationRepository donationRepository;
    private final AccountDetailRepository accountDetailRepository;
    private final VendorBudgetRepository vendorBudgetRepository;
    private final FeedBackRepository feedBackRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void donate(DonateDto donateDto) {
        Donor donor = donorRepository.findByUserName(donateDto.getUserName()).orElseThrow(() -> new CustomServiceException(" Donor not found"));
        HospitalRequirement hospitalRequirement = hospitalRequirementRepository.findById(donateDto.getRequirementId()).orElseThrow(() -> new CustomServiceException(" Requirement not found"));
        Donation donation = new Donation(donateDto.getDonationType(),donateDto.getDonationAmount(),donor,hospitalRequirement);
        donationRepository.save(donation);
        AccountDetail accountDetail = new AccountDetail(donateDto.getBankName(),donateDto.getCardNumber(),donateDto.getExpireDate(),donateDto.getCvvNumber(),donor);
        accountDetailRepository.save(accountDetail);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int donationsCount(DonorUserNameDto donorUserNameDto) {
        Donor donor = donorRepository.findByUserName(donorUserNameDto.getUserName()).orElseThrow(() -> new CustomServiceException(" Donor not found"));
        long count = donationRepository.countByDonor(donor);
//        int noOfTotalDonations =
        return (int) count;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<DonationDto> getRelevantDonationDetails(DonorUserNameDto donorUserNameDto) {
        Donor donor = donorRepository.findByUserName(donorUserNameDto.getUserName()).orElseThrow(() -> new CustomServiceException(" Donor not found"));
        List<Donation> donationList = donationRepository.findAllByDonor(donor);

        List<DonationDto> donationDtoList = new ArrayList<>();
        for (Donation donation:donationList) {
            donationDtoList.add(new DonationDto(donation.getDonationType(),donation.getDonationAmount(),donation.getHospitalRequirement()));

        }
        return donationDtoList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<BudgetVendorDetailsDto> getBudgetsRelatedToRequirements(RequirementIdDto requirementIdDto) {
        HospitalRequirement hospitalRequirement = hospitalRequirementRepository.findById(requirementIdDto.getId()).orElseThrow(() -> new CustomServiceException(" Requirement not found"));
        List<VendorBudget> vendorBudgetList = vendorBudgetRepository.findByHospitalRequirement(hospitalRequirement);
        List<BudgetVendorDetailsDto> budgetVendorDetailsDtoList = new ArrayList<>();
        for (VendorBudget vendorBudget:vendorBudgetList) {
            budgetVendorDetailsDtoList.add(new BudgetVendorDetailsDto(vendorBudget));

        }
        return budgetVendorDetailsDtoList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void giveFeedBack(FeedBackDto feedBackDto) {
        Donor donor = donorRepository.findByUserName(feedBackDto.getUserName()).orElseThrow(() -> new CustomServiceException(" Donor not found"));
        FeedBack feedBack = new FeedBack(feedBackDto.getContent(),donor);
         feedBackRepository.save(feedBack);

    }
}
