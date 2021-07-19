package com.mit.easyDonationBackendV6.Repository;

import com.mit.easyDonationBackendV6.Model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AdminRepository extends MongoRepository<Admin, String> {
    Optional<Admin> findByUserName(String userName);
}
