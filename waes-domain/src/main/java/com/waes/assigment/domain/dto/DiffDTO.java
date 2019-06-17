package com.waes.assigment.domain.dto;

import com.waes.assigment.domain.enums.DiffEnum;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
public class DiffDTO {

    @NotNull
    private Long id;

    @NotBlank
    private DiffEnum side;

    @NotBlank
    private String data;

}