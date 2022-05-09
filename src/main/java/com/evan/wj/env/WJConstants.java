package com.evan.wj.env;

public class WJConstants {
    // 采用MD5加密
    public static final String ALGORITHMNAME_MD5 = "md5";
    // 加密次数
    public static final int HASHITERATIONS = 2;

    public enum ResultCode {
        SUCCESS("200"),
        FAIL("400"),
        UNAUTHORIZED("401"),
        NOT_FOUND("404"),
        INTERNAL_SERVER_ERROR("500");
        private String code;

        ResultCode(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return this.code;
        }
    }
}
