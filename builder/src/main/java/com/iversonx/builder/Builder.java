package com.iversonx.builder;

import com.iversonx.builder.model.Body;
import com.iversonx.builder.model.Footer;
import com.iversonx.builder.model.Header;

import java.util.List;

public interface Builder {
    void buildHeader(Header header);

    void buildBody(List<Body> data);

    void buildFooter(Footer footer);

    String getExportFile();
}
