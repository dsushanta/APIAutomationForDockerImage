package com.bravo.johny.jsonserver.builders.common;

import com.bravo.johny.jsonserver.dtos.request.BaseRequest;

public class RequestBuilder<T extends BaseRequest> implements IRequestBuilder{
    protected T request;

    public T build() {
        return request;
    }
}
