package com.waes.assignment.rest.controller;

import com.waes.assigment.domain.dto.DiffBase64;
import com.waes.assigment.domain.dto.DiffDTO;
import com.waes.assigment.domain.dto.DiffResultDTO;
import com.waes.assigment.domain.enums.DiffEnum;
import com.waes.assignment.infra.service.DiffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/diff/{id}")
@Api(value="Diff Management")
public class DiffController {

    private final DiffService diffService;

    public DiffController(DiffService diffService) {
        this.diffService = diffService;
    }

    @PostMapping(value = "/right", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveRightData(@PathVariable Long id, @RequestBody DiffBase64 data) throws IllegalAccessException {
        diffService.save(this.buildDiffDTO(id, data, DiffEnum.RIGHT));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/left", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveLeftData(@PathVariable Long id, @RequestBody DiffBase64 data) throws IllegalAccessException {
        diffService.save(this.buildDiffDTO(id, data, DiffEnum.LEFT));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "View diff result", response = DiffResultDTO.class)
    public ResponseEntity<DiffResultDTO> getDiff(@PathVariable Long id){
        return ResponseEntity.ok(diffService.getDiffResult(id));
    }

    private DiffDTO buildDiffDTO(Long id, DiffBase64 data, DiffEnum side){
       return DiffDTO.builder()
               .id(id)
               .data(data.getData())
               .side(side)
               .build();
    }


}
