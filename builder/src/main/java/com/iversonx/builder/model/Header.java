package com.iversonx.builder.model;

public class Header {
    private String source;
    private String uuid;

    public Header(String uuid, String source) {
        this.uuid = uuid;
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public String getUuid() {
        return uuid;
    }

}
