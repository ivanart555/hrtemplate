package com.ivanart555.hrtemplate.services;

import com.ivanart555.hrtemplate.entities.Country;
import com.ivanart555.hrtemplate.exceptions.ServiceException;
import com.ivanart555.hrtemplate.services.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountryService extends GenericService<Country, Integer> {

    Page<Country> findAll(Pageable pageable) throws ServiceException;

}
