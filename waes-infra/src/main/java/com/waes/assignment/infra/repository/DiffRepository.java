package com.waes.assignment.infra.repository;

import com.waes.assigment.domain.model.Diff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiffRepository  extends JpaRepository<Diff, Long> {

}
