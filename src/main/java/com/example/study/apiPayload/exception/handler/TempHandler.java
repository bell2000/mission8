package com.example.study.apiPayload.exception.handler;

import com.example.study.apiPayload.code.BaseErrorCode;
import com.example.study.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
