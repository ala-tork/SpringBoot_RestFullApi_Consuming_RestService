package com.api.restapi.RestIServicer;

import com.api.restapi.RestOutput.OutPutResponseBeen;

import java.util.List;

public interface Iservices {
    public List<OutPutResponseBeen> GetPostOfficeDetailsByCity(String city);
    public List<String> GetPostOfficeNamesByCity(String city);

}
