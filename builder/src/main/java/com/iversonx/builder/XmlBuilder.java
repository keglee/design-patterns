package com.iversonx.builder;

import com.iversonx.builder.model.Body;
import com.iversonx.builder.model.Footer;
import com.iversonx.builder.model.Header;

import java.util.List;

public class XmlBuilder implements Builder {
    private StringBuffer buffer;

    public XmlBuilder() {
        buffer = new StringBuffer("<?xml version='1.0' encoding='uft-8'?>\n");
    }

    @Override
    public void buildHeader(Header header) {

        buffer.append("<header>\n");
        buffer.append("\t<uuid>").append(header.getUuid()).append("</uuid>\n");
        buffer.append("\t<source>").append(header.getSource()).append("</source>\n");
        buffer.append("</header>\n");
    }

    @Override
    public void buildBody(List<Body> data) {
        buffer.append("<body>\n");
        for(Body body : data) {
            buffer.append("\t<data>\n");
            buffer.append("\t\t<name>").append(body.getName()).append("</name>\n");
            buffer.append("\t\t<amount>").append(body.getAmount()).append("</amount>\n");
            buffer.append("\t\t<price>").append(body.getPrice()).append("</price>\n");
            buffer.append("\t</data>\n");
        }
        buffer.append("</body>\n");
    }

    @Override
    public void buildFooter(Footer footer) {
        buffer.append("<footer>\n");
        buffer.append("\t<operator>").append(footer.getOperator()).append("</operator>\n");
        buffer.append("\t<date>").append(footer.getOperatorDate()).append("</date>\n");
        buffer.append("</footer>\n");
    }

    @Override
    public String getExportFile() {
        return buffer.toString();
    }
}
