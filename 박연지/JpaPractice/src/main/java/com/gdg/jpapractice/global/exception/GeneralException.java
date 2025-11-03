package com.gdg.jpapractice.global.exception;

import com.gdg.jpapractice.global.error.code.BaseCode;
import com.gdg.jpapractice.global.error.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseCode code;
    public ReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }

    public GeneralException(BaseCode code, Throwable cause) {
        super(code.getReasonHttpStatus().getMessage(), cause);
        this.code = code;
    }
}
