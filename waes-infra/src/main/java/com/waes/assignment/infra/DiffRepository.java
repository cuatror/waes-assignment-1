package com.waes.assignment.infra;

import com.waes.assigment.domain.model.Diff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DiffRepository  extends JpaRepository<Diff, Long> {

}
