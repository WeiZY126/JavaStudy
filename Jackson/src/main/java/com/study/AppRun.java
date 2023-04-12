package com.study;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.service.impl.GetQueueAppsHistoryImpl;

import java.io.*;

public class AppRun {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(new GetQueueAppsHistoryImpl().getAppInfo(mapper,args));
    }
}
