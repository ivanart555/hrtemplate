package com.ivanart555.hrtemplate.services;

import com.ivanart555.hrtemplate.entities.Position;
import com.ivanart555.hrtemplate.exceptions.ServiceException;
import com.ivanart555.hrtemplate.services.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PositionService extends GenericService<Position, Integer> {
    Page<Position> findAll(Pageable pageable) throws ServiceException;

}
