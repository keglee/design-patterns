package com.iversonx.builder;

import com.iversonx.builder.model.Body;
import com.iversonx.builder.model.Footer;
import com.iversonx.builder.model.Header;

import java.util.List;

public class Director {
    public Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(Header header, List<Body> data, Footer footer) {
        builder.buildHeader(header);
        builder.buildBody(data);
        builder.buildFooter(footer);
    }
}
