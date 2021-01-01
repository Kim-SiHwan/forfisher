package com.api.fisher.service;

import com.api.fisher.domain.Domain;
import com.api.fisher.dto.Response;
import com.api.fisher.repository.ApiRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional (readOnly = true)
public class ApiService {
    private final ApiRepository repository;

    public List<Response> findAll(){
        List<Domain> domains = repository.findAll();
        List<Response> list = domains.stream()
                .map(m -> new Response(m))
                .collect(Collectors.toList());
        return list;
    }

    public void init(String jsonData) {
        try {
            //JSON 객체를 생성.
            JSONObject jObj;
            //JSON 파싱 객체를 생성.
            JSONParser jsonParser = new JSONParser();
            //파싱할 String (Controller에서 호출해 값이 저장된 StringBuilder result)을
            //JSON객체로 파서를 통해 저장.
            JSONObject jsonObj = (JSONObject) jsonParser.parse(jsonData);
            //데이터 분해 단계

            //response를 받아옴.
            JSONObject parseResponse = (JSONObject) jsonObj.get("response");
            //parseResponse에는 response 내부의 데이터들이 들어있음

            //body를 받아옴
            JSONObject parseBody = (JSONObject) parseResponse.get("body");
            //parseBody에는 body 내부의 데이터들이 들어있음.

            //items 안쪽의 데이터는 [] 즉 배열의 형태이기에 제이슨 배열로 받아온다.
            JSONArray array = (JSONArray) parseBody.get("items");

            //생성해놓은 도메인에 매핑
            for (int i = 0; i < array.size(); i++) {
                jObj = (JSONObject) array.get(i);

                //도메인클래스 빌더패턴으로 값 삽입하기
                Domain domain = Domain.init()
                        .fshlcNm(jObj.get("fshlcNm").toString())
                        .aceptncCo(jObj.get("aceptncCo").toString())
                        .cfrTrrsrt(jObj.get("cfrTrrsrt").toString())
                        .cvntl(jObj.get("cvntl").toString())
                        .fshlcPhoneNumber(jObj.get("fshlcPhoneNumber").toString())
                        .fshlcType(jObj.get("fshlcType").toString())
                        .institutionNm(jObj.get("institutionNm").toString())
                        .insttCode(jObj.get("insttCode").toString())
                        .kdfsh(jObj.get("kdfsh").toString())
                        .latitude(jObj.get("latitude").toString())
                        .lnmadr(jObj.get("lnmadr").toString())
                        .longitude(jObj.get("longitude").toString())
                        .mainPoint(jObj.get("mainPoint").toString())
                        .phoneNumber(jObj.get("phoneNumber").toString())
                        .rdnmadr(jObj.get("rdnmadr").toString())
                        .referenceDate(jObj.get("referenceDate").toString())
                        .safentl(jObj.get("safentl").toString())
                        .useCharge(jObj.get("useCharge").toString())
                        .waterAr(jObj.get("waterAr").toString())
                        .wtrcFcltyType(jObj.get("wtrcFcltyType").toString())
                        .build();
                System.out.println(domain.getFshlcNm());
                //Jpa로 H2에 Domain 삽입.
                repository.save(domain);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
