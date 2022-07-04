package com.ivanart555.hrtemplate.repositories;

import com.ivanart555.hrtemplate.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
