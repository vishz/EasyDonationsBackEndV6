package com.mit.easyDonationBackendV6.Service.ServiceImpl;

import com.mit.easyDonationBackendV6.Dto.DonateDto;
import com.mit.easyDonationBackendV6.Dto.DonorUserNameDto;
import com.mit.easyDonationBackendV6.Exception.CustomServiceException;
import com.mit.easyDonationBackendV6.Model.*;
import com.mit.easyDonationBackendV6.Repository.AccountDetailRepository;
import com.mit.easyDonationBackendV6.Repository.DonationRepository;
import com.mit.easyDonationBackendV6.Repository.DonorRepository;
import com.mit.easyDonationBackendV6.Repository.HospitalRequirementRepository;
import com.mit.easyDonationBackendV6.Service.DonorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@RequiredArgsConstructor
@Service
public class DonorServiceImpl implements DonorService {

    private final DonorRepository donorRepository;
    private final HospitalRequirementRepository hospitalRequirementRepository;
    private final DonationRepository donationRepository;
    private final AccountDetailRepository accountDetailRepository;

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
        int noOfTotalDonations = (int) count;
        return noOfTotalDonations;
    }
}
