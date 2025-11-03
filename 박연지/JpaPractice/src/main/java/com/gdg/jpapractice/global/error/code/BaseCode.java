package com.gdg.jpapractice.global.error.code;

public interface BaseCode {
    String getCode();
    String getMessage();
    ReasonDTO getReasonHttpStatus();
}
