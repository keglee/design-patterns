package com.iversonx.builder.model;

public class Footer {
    private String operator;
    private String OperatorDate;

    public Footer(String operator, String operatorDate) {
        this.operator = operator;
        OperatorDate = operatorDate;
    }

    public String getOperator() {
        return operator;
    }

    public String getOperatorDate() {
        return OperatorDate;
    }

}
