package com.ivanart555.hrtemplate.services.impl;

import com.ivanart555.hrtemplate.entities.Country;
import com.ivanart555.hrtemplate.exceptions.ServiceException;
import com.ivanart555.hrtemplate.repositories.CountryRepository;
import com.ivanart555.hrtemplate.services.CountryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Override
    public List<Country> findAll() throws ServiceException {
        List<Country> countries = countryRepository.findAll();
        log.info("All Countries received successfully.");
        return countries;
    }

    @Override
    public Page<Country> findAll(Pageable pageable) throws ServiceException {
        Page<Country> countries = countryRepository.findAll(pageable);
        log.info("All Countries received successfully.");
        return countries;
    }

    @Override
    public Country findById(Integer id) throws ServiceException {
        Country country = null;
        try {
            country = countryRepository.findById(id).orElseThrow(() -> new ServiceException(
                    String.format("Country with id %d not found!", id)));
        } catch (EntityNotFoundException e) {
            log.warn("Country with id {} not found!", id);
        }
        log.info("Country with id {} received successfully.", id);

        return country;
    }

    @Override
    public int save(Country country) {
        Country createdCountry = countryRepository.save(country);
        log.info("Country with id {} saved successfully.", createdCountry.getId());
        return createdCountry.getId();
    }

    @Override
    public void deleteById(Integer id) throws ServiceException {
        countryRepository.deleteById(id);
        log.info("Country with id {} deleted successfully.", id);
    }
}
