package com.waes.assignment.infra.service;


import com.waes.assigment.domain.dto.DiffDTO;
import com.waes.assigment.domain.dto.DiffResultDTO;
import com.waes.assigment.domain.model.Diff;

public interface DiffService {

    Diff save(DiffDTO diffDTO);


    DiffResultDTO getDiffResult(Long id);
}
