package com.mit.easyDonationBackendV6.Service.ServiceImpl;

import com.mit.easyDonationBackendV6.Dto.LoginDto;
import com.mit.easyDonationBackendV6.Dto.RegistrationDto;
import com.mit.easyDonationBackendV6.Exception.CustomServiceException;
import com.mit.easyDonationBackendV6.Model.*;
import com.mit.easyDonationBackendV6.Repository.*;
import com.mit.easyDonationBackendV6.Service.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



@Log4j2
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@RequiredArgsConstructor
@Service
public class CommonServiceImpl implements CommonService {

    private final AdminRepository adminRepository;
    private final DonorRepository donorRepository;
    private final HospitalRepository hospitalRepository;
    private final VendorRepository vendorRepository;
    private final HospitalCategoryRepository hospitalCategoryRepository;
    private final VendorCategoryRepository vendorCategoryRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void signIn(LoginDto loginDto) {
        if(loginDto.getRole().equals("ADMIN")){
            Optional<Admin> admin= adminRepository.findByUserName(loginDto.getUserName());
            if(!admin.isPresent()){
                throw new CustomServiceException("you are not signed up as an admin");
            }
        }
        if(loginDto.getRole().equals("DONOR")){
            Optional<Donor> donor= donorRepository.findByUserName(loginDto.getUserName());
            if(!donor.isPresent()){
                throw new CustomServiceException("you are not signed up as a donor");
            }
        }
        if(loginDto.getRole().equals("VENDOR")){
            Optional<Vendor> vendor= vendorRepository.findByUserName(loginDto.getUserName());
            if(!vendor.isPresent()){
                throw new CustomServiceException("you are not signed up as a vendor");
            }
        }
        if(loginDto.getRole().equals("HOSPITAL")){
            Optional<Hospital> hospital= hospitalRepository.findByUserName(loginDto.getUserName());
            if(!hospital.isPresent()){
                throw new CustomServiceException("you are not signed up as a hospital");
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void signUp(RegistrationDto registrationDto) {
        System.out.print(registrationDto);
        if(registrationDto.getRole().equals("ADMIN")){
            Optional<Admin> admin= adminRepository.findByUserName(registrationDto.getUserName());
            if(!admin.isPresent()){;
                Admin admin1 = new Admin(registrationDto.getName(), registrationDto.getUserName(),registrationDto.getAddress()
                        ,registrationDto.getEmail(), registrationDto.getMobileNumber(), registrationDto.getPassword());
                adminRepository.save(admin1);
            }else {
                throw new CustomServiceException("you already signed up as an admin");
            }
        }
        if(registrationDto.getRole().equals("DONOR")){
            Optional<Donor> donor= donorRepository.findByUserName(registrationDto.getUserName());
            if(!donor.isPresent()){
                Donor donor1 = new Donor(registrationDto.getName(), registrationDto.getUserName(),registrationDto.getAddress()
                        ,registrationDto.getEmail(), registrationDto.getMobileNumber(), registrationDto.getPassword());
                donorRepository.save(donor1);
            }else {
                throw new CustomServiceException("you already signed up as a donor");
            }
        }
        if(registrationDto.getRole().equals("VENDOR")){
            Optional<Vendor> vendor= vendorRepository.findByUserName(registrationDto.getUserName());
            if(!vendor.isPresent()){
                VendorCategory vendorCategory = vendorCategoryRepository.findByCategoryName(registrationDto.getCategoryName()).orElseThrow(() -> new CustomServiceException(" Category not entered"));
                Vendor vendor1 = new Vendor(registrationDto.getName(), registrationDto.getUserName(),registrationDto.getAddress()
                        ,registrationDto.getEmail(), registrationDto.getMobileNumber(), registrationDto.getPassword(),vendorCategory);
                vendorRepository.save(vendor1);
            }else {
                throw new CustomServiceException("you already signed up as a vendor");
            }
        }
        if(registrationDto.getRole().equals("HOSPITAL")){
            Optional<Hospital> hospital= hospitalRepository.findByUserName(registrationDto.getUserName());
            if(!hospital.isPresent()){
                HospitalCategory hospitalCategory = hospitalCategoryRepository.findByCategoryName(registrationDto.getCategoryName()).orElseThrow(() -> new CustomServiceException(" Category not entered"));
                Hospital hospital1 = new Hospital(registrationDto.getName(), registrationDto.getUserName(),registrationDto.getAddress()
                        ,registrationDto.getEmail(), registrationDto.getMobileNumber(), registrationDto.getPassword(),hospitalCategory);
                hospitalRepository.save(hospital1);
            }else {
                throw new CustomServiceException("you already signed up as a hospital");
            }
        }
    }


}
