package com.deadk.awsproject.model;

import java.util.Date;

public class AWSFile {
    private String key;
    private long size;
    private Date lastMofidied;
    private String link;

    public AWSFile(String key, long size, Date lastMofidied, String link) {
        this.key = key;
        this.size = size;
        this.lastMofidied = lastMofidied;
        this.link = link;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Date getLastMofidied() {
        return lastMofidied;
    }

    public void setLastMofidied(Date lastMofidied) {
        this.lastMofidied = lastMofidied;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
