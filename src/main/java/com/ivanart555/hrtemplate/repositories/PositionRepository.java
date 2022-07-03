package com.ivanart555.hrtemplate.repositories;

import com.ivanart555.hrtemplate.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PositionRepository extends JpaRepository<Position, Integer> {

}
