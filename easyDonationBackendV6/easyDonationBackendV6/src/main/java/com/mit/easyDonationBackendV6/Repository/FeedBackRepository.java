package com.mit.easyDonationBackendV6.Repository;

import com.mit.easyDonationBackendV6.Model.Donation;
import com.mit.easyDonationBackendV6.Model.FeedBack;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedBackRepository extends MongoRepository<FeedBack,String> {
}
