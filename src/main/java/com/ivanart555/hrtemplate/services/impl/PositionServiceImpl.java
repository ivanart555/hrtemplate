package com.ivanart555.hrtemplate.services.impl;

import com.ivanart555.hrtemplate.entities.Position;
import com.ivanart555.hrtemplate.exceptions.ServiceException;
import com.ivanart555.hrtemplate.repositories.PositionRepository;
import com.ivanart555.hrtemplate.services.PositionService;
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
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    @Override
    public List<Position> findAll() throws ServiceException {
        List<Position> positions = positionRepository.findAll();
        log.info("All Positions received successfully.");
        return positions;
    }

    @Override
    public Page<Position> findAll(Pageable pageable) throws ServiceException {
        Page<Position> positions = positionRepository.findAll(pageable);
        log.info("All Positions received successfully.");
        return positions;
    }

    @Override
    public Position findById(Integer id) throws ServiceException {
        Position position = null;
        try {
            position = positionRepository.findById(id).orElseThrow(() -> new ServiceException(
                    String.format("Position with id %d not found!", id)));
        } catch (EntityNotFoundException e) {
            log.warn("Position with id {} not found!", id);
        }
        log.info("Position with id {} received successfully.", id);

        return position;
    }

    @Override
    public int save(Position position) {
        Position createdPosition = positionRepository.save(position);
        log.info("Position with id {} saved successfully.", createdPosition.getId());
        return createdPosition.getId();
    }

    @Override
    public void deleteById(Integer id) throws ServiceException {
        positionRepository.deleteById(id);
        log.info("Position with id {} deleted successfully.", id);
    }
}
