package com.api.restapi.RestServices;

import com.api.restapi.RestIServicer.Iservices;
import com.api.restapi.RestOutput.OutPutDetails;
import com.api.restapi.RestOutput.OutPutResponseBeen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("RestApiService")
public class Services implements Iservices {
    //WebClient
    @Autowired
    RestTemplate restTemplate ;

    @Override
    public List<OutPutResponseBeen> GetPostOfficeDetailsByCity(String city) {
        //api url
        String url="https://api.postalpincode.in/postoffice/{city}" ;
        url=url.replace("{city}",city);
        System.out.println(url);
        //bech n7ot feha kol mahou status ou header ou matab3ou eli bech ijin ml resultat
        //na3teha el entity eli tmathel el resultat ou fl cas hethi 3andi el resultat tmathel array of outputresponsebeen
        ResponseEntity<OutPutResponseBeen[]> outputresponse;
        outputresponse= restTemplate.getForEntity(url,OutPutResponseBeen[].class);
        System.out.println(outputresponse.getStatusCode()+"***");
        //System.out.println(outputresponse.getBody());
        //read the body of the response
        List <OutPutResponseBeen> res = List.of(outputresponse.getBody());
        //n7ot el postoffice fi array of outputdetails
        for(OutPutResponseBeen o:res){
            for(OutPutDetails d :o.getPostoffice()){
                System.out.println(d.getName());
            }
        }
        return res;
    }

    public List<String> GetPostOfficeNamesByCity(String city){
        //api url
        String url="https://api.postalpincode.in/postoffice/{city}" ;
        url=url.replace("{city}",city);

        ResponseEntity<OutPutResponseBeen[]> outputresponse;
        outputresponse= restTemplate.getForEntity(url,OutPutResponseBeen[].class);
        //put the body in a list of outputBeen object
        List <OutPutResponseBeen> res = List.of(outputresponse.getBody());
        List<String> resultat = new ArrayList<>();
        //n7ot el postoffice fi array of outputdetails
        for(OutPutResponseBeen o:res){
            for(OutPutDetails d :o.getPostoffice()){
                resultat.add(d.getName());
            }
        }
        return resultat;
    }
}
