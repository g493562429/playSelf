package com.gn.demo.factory;

import com.gn.demo.model.ResponseCode;
import com.gn.demo.model.ReturnJson;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.util.Assert;

/**
 * @Author: gn
 * @Date: 2021-1-18
 * @Description:
 */
public class ReturnJsonFactory {
    private static final String RETURN_JSON_DATA_KEY = "data";
    private static final String RETURN_JSON_RESULT_CODE = "resultCode";
    private static final String RETURN_JSON_RESULT_MESSAGE = "resultMsg";
    private static final Long TEN_THOUSAND = 10000L;

    public ReturnJsonFactory() {
    }

    public static ReturnJson success(Object data) {
        return new ReturnJson(data);
    }

    public static ReturnJson success() {
        return success(null);
    }

    public static ReturnJson fail(String resultCode) {
        return fail(resultCode, null);
    }

    public static ReturnJson fail(String resultCode, Object data) {
        checkVaild(resultCode);
        return new ReturnJson(resultCode, ResponseCode.getMessage(resultCode), data);
    }

    public static ReturnJson fail(String resultCode, String[] resultMsgParams) {
        return fail(resultCode, resultMsgParams, null);
    }

    public static ReturnJson fail(String resultCode, String[] resultMsgParams, Object data) {
        checkVaild(resultCode);
        return new ReturnJson(resultCode, ResponseCode.getMessage(resultCode, resultMsgParams), data);
    }

    public static ReturnJson json(String resultCode, String resultMsg, Object data) {
        if (!"0".equals(resultCode) && !"-1".equals(resultCode)) {
            checkVaild(resultCode);
        }

        return new ReturnJson(resultCode, resultMsg, data);
    }

    public static ReturnJson json(String jsonString) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(jsonString).getAsJsonObject();
        String resultCode = jsonObject.get("resultCode").getAsString();
        if (!"0".equals(resultCode) && !"-1".equals(resultCode)) {
            checkVaild(resultCode);
        }
        return (ReturnJson) (new Gson()).fromJson(jsonString, ReturnJson.class);
    }

    public static ReturnJson systemError() {
        return new ReturnJson("-1", ResponseCode.SYSTEM_FAIL_MSG, null);
    }

    public static ReturnJson result(boolean isSuccess, String failCode) {
        return isSuccess ? success() : fail(failCode);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static ReturnJson fail(String resultCode, String resultMsg, Object data) {
        checkVaild(resultCode);
        return new ReturnJson(resultCode, resultMsg, data);
    }

    private static void checkVaild(String resultCode) {
        boolean flag = Long.parseLong(resultCode) > TEN_THOUSAND;
        Assert.isTrue(flag, "resultCode必须大于10000,10000以内内部保留");
    }
}
