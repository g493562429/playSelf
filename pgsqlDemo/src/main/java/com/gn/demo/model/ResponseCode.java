package com.gn.demo.model;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.util.Assert;

import java.text.MessageFormat;

/**
 * @Author: gn
 * @Date: 2021-1-18
 * @Description:
 */
public class ResponseCode {
    public static final String SUCCESS_CODE = "0";
    public static final String SUCCESS_MSG = "请求处理成功";
    public static final String SYSTEM_FAIL_CODE = "-1";
    public static final String SYSTEM_FAIL_MSG = "系统异常,请联系管理员";
    public static final String ARGUMENT_INVALID_CODE = "10001";
    public static final String ARGUMENT_INVALID_MSG = "请求参数错误";
    public static final MessageSourceAccessor messages = ResponseCodeMessageSource.getAccessor();

    public ResponseCode() {
    }

    public static String getMessage(final String code) {
        return ResponseCode.ResponseMessage.getMessage(code, false);
    }

    public static String getMessage(final String code, final String[] resultMsgParams) {
        return ResponseCode.ResponseMessage.getMessage(code, false, resultMsgParams);
    }

    static final class ResponseMessage {
        private String code;
        private String msg;

        public ResponseMessage(final String code) {
            this.code = code;
            this.msg  = null;
        }

        public ResponseMessage(final String code, final String msg) {
            this.code = code;
            this.msg = msg;
        }

        public static String getMessage(final String code){
            return getMessage(code, false, new String[0]);
        }

        public static String getMessage(final String code, String[] params){
            return getMessage(code, false, params);
        }

        public static String getMessage(final String code, final boolean showCode){
            return getMessage(code, showCode, new String[0]);
        }

        public static String getMessage(final String code, final boolean showCode, String[] params){
            String msg = ResponseCode.messages.getMessage(code, "");
            if (params.length > 0){
                msg = MessageFormat.format(msg, params);
            }

            ResponseCode.ResponseMessage responseMessage = new ResponseCode.ResponseMessage(code, msg);
            Assert.hasText(msg, String.format("无效的错误码[%s]", code));
            return responseMessage.toString(showCode);
        }

        public String toString() {
            return this.toString(true);
        }

        public String toString(final boolean showCode) {
            String returnString = "";
            if (showCode) {
                returnString = "[" + this.code + "]" + this.msg;
            } else {
                returnString = this.msg;
            }

            return returnString;
        }
    }
}
