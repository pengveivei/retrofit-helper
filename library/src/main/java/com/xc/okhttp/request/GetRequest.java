package com.xc.okhttp.request;

import com.xc.okhttp.utils.ParamHelper;

import okhttp3.Request;

/**
 * Created by chengxin on 2017/6/22.
 */

public class GetRequest extends OkRequest {

    protected GetRequest(Builder builder) {
        super(builder);
        setUrl(ParamHelper.appendParams(getUrl(), getParams()));
    }

    @Override
    public Request createRequest() {
        return new Request.Builder().url(getUrl()).headers(getHeaders().build()).tag(getTag()).build();
    }

    public static class Builder extends OkRequestBuilder<Builder> {
        @Override
        public GetRequest build() {
            return new GetRequest(this);
        }
    }
}