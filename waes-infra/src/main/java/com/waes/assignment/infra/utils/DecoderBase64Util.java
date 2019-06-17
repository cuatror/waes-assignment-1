package com.waes.assignment.infra.utils;


import com.waes.assigment.domain.enums.MessageCodeEnum;
import com.waes.assigment.domain.exception.BusinessException;
import org.apache.commons.codec.binary.Base64;

public class DecoderBase64Util {

    public static String decode(String data){
        try {
            return new String(Base64.decodeBase64(data));
        } catch (Exception e) {
            throw new BusinessException(MessageCodeEnum.ERROR_DECODE_DATA);
        }
    }
}
