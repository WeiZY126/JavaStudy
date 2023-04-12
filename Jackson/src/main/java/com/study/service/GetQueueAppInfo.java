package com.study.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface GetQueueAppInfo {
    public String getAppInfo(ObjectMapper mapper,String... args);
}
