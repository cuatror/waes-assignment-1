package com.waes.assigment.domain.dto;

import com.waes.assigment.domain.enums.DiffResultEnum;
import lombok.Data;

@Data
public class DiffResultDTO {

    private String equals = DiffResultEnum.NOT_EQUALS.getMessage();

    private String length = DiffResultEnum.DIFFERENT_LENGTH.getMessage();

    private Integer firstDiffIndex;

}