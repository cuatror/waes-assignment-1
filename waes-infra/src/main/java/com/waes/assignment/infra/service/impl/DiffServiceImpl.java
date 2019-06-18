package com.waes.assignment.infra.service.impl;


import com.waes.assigment.domain.dto.DiffDTO;
import com.waes.assigment.domain.dto.DiffResultDTO;
import com.waes.assigment.domain.enums.DiffEnum;
import com.waes.assigment.domain.enums.DiffResultEnum;
import com.waes.assigment.domain.enums.MessageCodeEnum;
import com.waes.assigment.domain.exception.BusinessException;
import com.waes.assigment.domain.model.Diff;
import com.waes.assignment.infra.repository.DiffRepository;
import com.waes.assignment.infra.service.DiffService;
import com.waes.assignment.infra.utils.DecoderBase64Util;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;


@Service
public class DiffServiceImpl implements DiffService {

    private final DiffRepository repository;

    public DiffServiceImpl(DiffRepository repository) {
        this.repository = repository;
    }

    public Diff findById(@NotNull Long id) {
        return repository.findById(id).orElse(new Diff(id));
    }

    /**
     * Generic save method
     * Check if data is base64
     * Set data to side Diff left or write by DiffEnum
     * @param  diffDTO
     */
    @Override
    @Transactional
    public Diff save(DiffDTO diffDTO) {
        this.isDataInBASE64(diffDTO.getData());
        Diff diff = this.findById(diffDTO.getId());
        this.setDataToDiffSide(diff, diffDTO);

        return repository.save(diff);
    }

    /**
     *  Build DiffResult from Diff information and calculates indexOfDifference
     * @param  data
     * @throws BusinessException  When data is not in Base64
     */
    private void isDataInBASE64(String data){
        if (!Base64.isBase64(data.getBytes()))
            throw new BusinessException(MessageCodeEnum.DATA_NOT_BASE64);
    }

    /**
     * Set data to side Diff left or write by DiffEnum
     * @param  diffDTO
     * * @param  diff
     */
    private void setDataToDiffSide(Diff diff, DiffDTO diffDTO) {
        String dataDecode = DecoderBase64Util.decode(diffDTO.getData());
        if (DiffEnum.LEFT.equals(diffDTO.getSide()))
            diff.setLeft(dataDecode);
        else diff.setRight(dataDecode);
    }

    /**
     * Get Diffresult from id
     *
     * @param id Diff ID
     * @return DiffResultDTO
     * @throws BusinessException     When a Diff is not found by  ID
     */

    @Override
    public DiffResultDTO getDiffResult(Long id){
        Diff diff = repository.findById(id)
                .orElseThrow(() -> new BusinessException(MessageCodeEnum.DIFF_DATA_NOT_FOUND));
        return this.getDiffFromStrings(diff);
    }

    /**
     *  Build DiffResult from Diff information and calculates indexOfDifference
     * @param  diff
     * @return DiffResultDTO
     */
    private DiffResultDTO getDiffFromStrings(Diff diff) {

        this.checkDataSide(diff);

        DiffResultDTO diffResultDTO = new DiffResultDTO();

        if (diff.getLeft().equals(diff.getRight()))
            diffResultDTO.setEquals(DiffResultEnum.EQUALS.getMessage());

        if (diff.getLeft().length() == (diff.getRight().length()))
            diffResultDTO.setLength(DiffResultEnum.SAME_LENGTH.getMessage());

        diffResultDTO.setFirstDiffIndex(StringUtils.indexOfDifference(diff.getLeft(), diff.getRight()));

        return diffResultDTO;
    }

    /**
     *  Check Diff from Diff
     *
     * @param  diff
     * @throws BusinessException     When a Diff left is empty
     * @throws BusinessException     When a Diff right is empty
     */
    public void checkDataSide(Diff diff) {

        if (StringUtils.isEmpty(diff.getLeft())) {
            throw new BusinessException(MessageCodeEnum.MISSING_LEFT_DATA);
        }

        if (StringUtils.isEmpty(diff.getRight())) {
            throw new BusinessException(MessageCodeEnum.MISSING_RIGHT_DATA);
        }
    }

}
