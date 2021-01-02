package com.api.fisher.controller;

import com.api.fisher.config.ApplicationYamlRead;
import com.api.fisher.dto.Request;
import com.api.fisher.dto.Response;
import com.api.fisher.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiController {
    private final ApiService service;
    private final ApplicationYamlRead read;
    @GetMapping("/api")
    public String callApi(){
        StringBuilder result = new StringBuilder();

        try{
            //page=1, rows=761== MAX
            String urlStr = "http://api.data.go.kr/openapi/tn_pubr_public_fshlc_api?" +
                    "serviceKey=" + read.getServiceKey()+""+
                    "&pageNo=1"+
                    "&numOfRows=761"+
                    "&type=json";
            URL url = new URL(urlStr);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader br;

            br= new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));

            String returnLine;

            //result = StringBuilder

            while((returnLine = br.readLine()) != null){
                result.append(returnLine+"\n\r");
            }

            urlConnection.disconnect();

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(result.toString());
        service.init(result.toString());
        return result.toString();
    }
    public List<Response> getList(){
        return service.findAll();
    }

    @GetMapping("/api/list")
    public ResponseEntity list(){
        return new ResponseEntity(getList(), HttpStatus.OK);
    }

    @GetMapping("/api/find")
    public ResponseEntity findList(Request request){
        return new ResponseEntity(service.findByFilters(request),HttpStatus.OK);
    }


}
