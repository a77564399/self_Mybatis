package com.class04.day01.mybatis.Mapper;

public class Mapper {
    private String QueryString;
    private String ResultType;

    public Mapper() {
    }

    public String getQueryString() {
        return QueryString;
    }

    public void setQueryString(String queryString) {
        QueryString = queryString;
    }

    public String getResultType() {
        return ResultType;
    }

    public void setResultType(String resultType) {
        ResultType = resultType;
    }
}
