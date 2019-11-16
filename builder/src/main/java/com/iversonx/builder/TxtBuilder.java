package com.iversonx.builder;

import com.iversonx.builder.model.Body;
import com.iversonx.builder.model.Footer;
import com.iversonx.builder.model.Header;

import java.util.List;

public class TxtBuilder implements Builder{
    private StringBuffer file;
    public TxtBuilder() {
        file = new StringBuffer();
    }

    @Override
    public void buildHeader(Header header) {
        file.append(header.getUuid()).append(", ");
        file.append(header.getSource()).append("\n");

    }

    @Override
    public void buildBody(List<Body> data) {
        for(Body body : data) {
            file.append(body.getName()).append(",");
            file.append(body.getAmount()).append(",");
            file.append(body.getPrice()).append("\n");
        }
    }

    @Override
    public void buildFooter(Footer footer) {
        file.append(footer.getOperator()).append(",");
        file.append(footer.getOperatorDate());
    }

    @Override
    public String getExportFile() {
        return file.toString();
    }
}
