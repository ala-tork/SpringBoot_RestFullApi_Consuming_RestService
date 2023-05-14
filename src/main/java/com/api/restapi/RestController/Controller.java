package com.api.restapi.RestController;

import com.api.restapi.RestIServicer.Iservices;
import com.api.restapi.RestOutput.OutPutResponseBeen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RestApi")
public class Controller {

    @Autowired
    private Iservices services;
    /*
    @RequestMapping(value = "/bycity",method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)*/
    @GetMapping(path="/bycity",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OutPutResponseBeen> getPostalByCity(@RequestParam String city){
        List<OutPutResponseBeen> output;
        output=services.GetPostOfficeDetailsByCity(city);

        return output;
    }
    @GetMapping(path="/nameByCity/{city}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getPostalNameByCity(@PathVariable String city){
        List<String> resultat = services.GetPostOfficeNamesByCity(city);
        return resultat;
    }
}
