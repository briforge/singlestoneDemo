package com.singlestone.demo.service;

import com.singlestone.demo.model.Phone;
import com.singlestone.demo.repos.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    public List<Phone> getPhonesByType(Phone.PhoneType phoneType) {
        return phoneRepository.findByType(phoneType);
    }

    // convenience method
    public List<Phone> getHomePhones() {
        return getPhonesByType(Phone.PhoneType.home);
    }
}
