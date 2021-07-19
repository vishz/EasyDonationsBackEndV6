package com.mit.easyDonationBackendV6.Dto;

public class CommonResponse<T> {

    private boolean success;
    private T body;

    public CommonResponse() {
    }

    public CommonResponse(boolean success, T body) {
        this.success = success;
        this.body = body;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "success=" + success +
                ", body=" + body +
                '}';
    }
}
