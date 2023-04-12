package com.study.bean;

public class QueueBean {
    private String name;
    private Long AppsSubmitted;
    private Long AppsCompleted;
    private Long AppsKilled;
    private Long AppsFailed;

    public QueueBean() {
    }

    public QueueBean(String name, Long appsSubmitted, Long appsCompleted, Long appsKilled, Long appsFailed) {
        this.name = name;
        AppsSubmitted = appsSubmitted;
        AppsCompleted = appsCompleted;
        AppsKilled = appsKilled;
        AppsFailed = appsFailed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAppsSubmitted() {
        return AppsSubmitted;
    }

    public void setAppsSubmitted(Long appsSubmitted) {
        AppsSubmitted = appsSubmitted;
    }

    public Long getAppsCompleted() {
        return AppsCompleted;
    }

    public void setAppsCompleted(Long appsCompleted) {
        AppsCompleted = appsCompleted;
    }

    public Long getAppsKilled() {
        return AppsKilled;
    }

    public void setAppsKilled(Long appsKilled) {
        AppsKilled = appsKilled;
    }

    public Long getAppsFailed() {
        return AppsFailed;
    }

    public void setAppsFailed(Long appsFailed) {
        AppsFailed = appsFailed;
    }
}
