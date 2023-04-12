package com.study.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.bean.QueueBean;
import com.study.service.GetQueueAppInfo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetQueueAppsHistoryImpl implements GetQueueAppInfo {

    @Override
    public String getAppInfo(ObjectMapper mapper,String... args) {
        JsonNode beforeNode = null;
        JsonNode afterNode = null;
        StringBuffer stringBuffer = new StringBuffer("队列"+"\t"+"提交数"+"\t"+"完成数"+"\t"+"被杀死数"+"\t"+"失败数"+"\t"+"成功率"+"\r\n");
        try {
            beforeNode = mapper.readTree(new File(args[0]));
            afterNode = mapper.readTree(new File(args[1]));

        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode beans = beforeNode.get("beans");
        JsonNode beans1 = afterNode.get("beans");
        List<QueueBean> beforeList = getBeansList(beans);
        List<QueueBean> afterList = getBeansList(beans1);
        for (QueueBean beforeQueue : beforeList) {
            for (QueueBean afterQueue : afterList) {
                if (afterQueue.getName().equals(beforeQueue.getName())){
                    stringBuffer
                            .append(afterQueue.getName())
                            .append("\t")
                            .append(afterQueue.getAppsSubmitted()-beforeQueue.getAppsSubmitted())
                            .append("\t")
                            .append(afterQueue.getAppsCompleted()-beforeQueue.getAppsCompleted())
                            .append("\t")
                            .append(afterQueue.getAppsKilled()-beforeQueue.getAppsKilled())
                            .append("\t")
                            .append(afterQueue.getAppsFailed()-beforeQueue.getAppsFailed())
                            .append("\t")
                            .append((double)(afterQueue.getAppsCompleted()-beforeQueue.getAppsCompleted())/(double)(afterQueue.getAppsSubmitted()-beforeQueue.getAppsSubmitted()))
                            .append("\r\n");
                }
            }
        }
        return stringBuffer.toString();
    }

    private List<QueueBean> getBeansList(JsonNode nodes) {
        ArrayList<QueueBean> queueBeans = new ArrayList<>();
        for (JsonNode node : nodes) {
            if (node.get("modelerType") != null) {
                String modelerType = node.get("modelerType").toString().toString();
                if (modelerType.contains("QueueMetrics") && modelerType.contains("q1=") && !modelerType.contains("user=")) {
                    String queueName = node.get("tag.Queue").toString();
                    long appsSubmitted = node.get("AppsSubmitted").asLong();
                    long appsKilled = node.get("AppsKilled").asLong();
                    long appsFailed = node.get("AppsFailed").asLong();
                    long appsCompleted=appsSubmitted-appsFailed-appsKilled;
                    queueBeans.add(new QueueBean(queueName,appsSubmitted,appsCompleted,appsKilled,appsFailed));
                }
            }
        }
        return queueBeans;
    }
}
