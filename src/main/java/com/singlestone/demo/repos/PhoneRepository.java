package com.singlestone.demo.repos;

import com.singlestone.demo.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    List<Phone> findByType(Phone.PhoneType phoneType);
}
