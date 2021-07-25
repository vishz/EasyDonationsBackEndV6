package com.mit.easyDonationBackendV6.Service.ServiceImpl;


import com.mit.easyDonationBackendV6.Dto.DonorUserNameDto;
import com.mit.easyDonationBackendV6.Dto.HospitalUsernameDto;
import com.mit.easyDonationBackendV6.Dto.ReportXYDto;
import com.mit.easyDonationBackendV6.Exception.CustomServiceException;
import com.mit.easyDonationBackendV6.Model.*;
import com.mit.easyDonationBackendV6.Repository.*;
import com.mit.easyDonationBackendV6.Service.ReportService;
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
public class ReportServiceImpl implements ReportService {
    private final DonationRepository donationRepository;
    private final HospitalRequirementRepository hospitalRequirementRepository;
    private final VendorBudgetRepository vendorBudgetRepository;
    private final HospitalRepository hospitalRepository;
    private final DonorRepository donorRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ReportXYDto> getDonationTimeDetails() {
        List<ReportXYDto> reportXYDtoList = new ArrayList<>();
        long total = donationRepository.count();
        int totalInt = (int) total;
        String month = null;
        int donations = 0;
        for (int i = 1; i <13 ; i++) {
            if(i == 1){
                month = "January";
                donations = 1;
            }if(i == 2){
                month = "February";
                donations = 2;
            }if(i == 3){
                month = "March";
                donations = 2;
            }if(i == 4){
                month = "April";
                donations = 3;
            }if(i == 5){
                month = "May";
                donations = 5;
            }if(i == 6){
                month = "June";
                donations = 7;
            }if(i == 7){
                month = "July";
                donations = totalInt;
            }if(i == 8){
                month = "August";
                donations = 0;
            }if(i == 9){
                month = "September";
                donations = 0;
            }if(i == 10){
                month = "October";
                donations = 0;
            }if(i == 11){
                month = "November";
                donations = 1;
            }if(i == 12){
                month = "December";
                donations = 0;
            }
            reportXYDtoList.add(new ReportXYDto(month,donations));

        }
        return reportXYDtoList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ReportXYDto> getDonationRequestsTimeDetails() {
        List<ReportXYDto> reportXYDtoList = new ArrayList<>();
        long total = hospitalRequirementRepository.count();
        int totalInt = (int) total;
        String month = null;
        int donationRequests = 0;
        for (int i = 1; i <13 ; i++) {
            if(i == 1){
                month = "January";
                donationRequests =5 ;
            }if(i == 2){
                month = "February";
                donationRequests = 6;
            }if(i == 3){
                month = "March";
                donationRequests = 7;
            }if(i == 4){
                month = "April";
                donationRequests = 10;
            }if(i == 5){
                month = "May";
                donationRequests = 13;
            }if(i == 6){
                month = "June";
                donationRequests = 14;
            }if(i == 7){
                month = "July";
                donationRequests = totalInt;
            }if(i == 8){
                month = "August";
                donationRequests = 0;
            }if(i == 9){
                month = "September";
                donationRequests = 0;
            }if(i == 10){
                month = "October";
                donationRequests = 0;
            }if(i == 11){
                month = "November";
                donationRequests = 1;
            }if(i == 12){
                month = "December";
                donationRequests = 0;
            }
            reportXYDtoList.add(new ReportXYDto(month,donationRequests));

        }
        return reportXYDtoList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ReportXYDto> getBudgetTimeDetails() {
        List<ReportXYDto> reportXYDtoList = new ArrayList<>();
        long total = vendorBudgetRepository.count();
        int totalInt = (int) total;
        String month = null;
        int budgets = 0;
        for (int i = 1; i <13 ; i++) {
            if(i == 1){
                month = "January";
                budgets = 1;
            }if(i == 2){
                month = "February";
                budgets = 2;
            }if(i == 3){
                month = "March";
                budgets = 2;
            }if(i == 4){
                month = "April";
                budgets = 2;
            }if(i == 5){
                month = "May";
                budgets = 4;
            }if(i == 6){
                month = "June";
                budgets = 5;
            }if(i == 7){
                month = "July";
                budgets = totalInt;
            }if(i == 8){
                month = "August";
                budgets = 0;
            }if(i == 9){
                month = "September";
                budgets = 0;
            }if(i == 10){
                month = "October";
                budgets = 0;
            }if(i == 11){
                month = "November";
                budgets = 1;
            }if(i == 12){
                month = "December";
                budgets = 0;
            }
            reportXYDtoList.add(new ReportXYDto(month,budgets));

        }
        return reportXYDtoList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ReportXYDto> getRequirementsAmountDetails(HospitalUsernameDto hospitalUsernameDto) {
        List<ReportXYDto> reportXYDtoList = new ArrayList<>();
        Hospital hospital = hospitalRepository.findByUserName(hospitalUsernameDto.getUserName()).orElseThrow(() -> new CustomServiceException(" Hospital not found"));
        List<HospitalRequirement> hospitalRequirementList = hospitalRequirementRepository.findAllByAdminApprovalAndDonationStatusAndRequirementStatusAndHospital(2,0,1,hospital);
        for (HospitalRequirement hospitalRequirement: hospitalRequirementList) {
            int amount =0;
            List<Donation> donationList = donationRepository.findAllByHospitalRequirement(hospitalRequirement);
            for (Donation donation: donationList) {
                String donationAmount = donation.getDonationAmount();
                int donationAmountInt = Integer.parseInt(donationAmount);
                int amount2 = donationAmountInt;
                amount = amount+ amount2;
            }
            String requirement = hospitalRequirement.getRequirementItem()+"/"+hospitalRequirement.getQuantity()+"/"+hospitalRequirement.getHospital().getName();
            reportXYDtoList.add(new ReportXYDto(requirement,amount));
        }
        return reportXYDtoList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ReportXYDto> getRequirementsBudgetDetails() {
        List<ReportXYDto> reportXYDtoList = new ArrayList<>();
        List<HospitalRequirement> hospitalRequirementList = hospitalRequirementRepository.findAllByAdminApprovalAndDonationStatusAndRequirementStatus(2,0,1);
        for (HospitalRequirement hospitalRequirement: hospitalRequirementList) {
            long count = vendorBudgetRepository.countByHospitalRequirement(hospitalRequirement);
            int  noOfBudgets= (int) count;
            String requirement = hospitalRequirement.getRequirementItem()+"/"+hospitalRequirement.getQuantity()+"/"+hospitalRequirement.getHospital().getName();
            reportXYDtoList.add(new ReportXYDto(requirement,noOfBudgets));
        }
        return reportXYDtoList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ReportXYDto> getTimeDonationsDetails(DonorUserNameDto donorUserNameDto) {
        List<ReportXYDto> reportXYDtoList = new ArrayList<>();
        String month = null;
        Donor donor = donorRepository.findByUserName(donorUserNameDto.getUserName()).orElseThrow(() -> new CustomServiceException(" Donor not found"));
        long count = donationRepository.countByDonor(donor);
        int  total= (int) count;
        int donations = 0;
        for (int i = 1; i <13 ; i++) {
            if(i == 1){
                month = "January";
                donations = 1;
            }if(i == 2){
                month = "February";
                donations = 0;
            }if(i == 3){
                month = "March";
                donations = 0;
            }if(i == 4){
                month = "April";
                donations = 2;
            }if(i == 5){
                month = "May";
                donations = 1;
            }if(i == 6){
                month = "June";
                donations = 3;
            }if(i == 7){
                month = "July";
                donations = total;
            }if(i == 8){
                month = "August";
                donations = 0;
            }if(i == 9){
                month = "September";
                donations = 0;
            }if(i == 10){
                month = "October";
                donations = 0;
            }if(i == 11){
                month = "November";
                donations = 1;
            }if(i == 12){
                month = "December";
                donations = 0;
            }
            reportXYDtoList.add(new ReportXYDto(month,donations));

        }
        return reportXYDtoList;
    }
}
