package com.api.fisher.dto;

import com.api.fisher.domain.Domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
public class Response {
    private Long id;
    private String fshlcNm;
    private String fshlcType;
    private String rdnmadr;
    private String lnmadr;
    private String latitude;
    private String longitude;
    private String fshlcPhoneNumber;
    private String waterAr;
    private String kdfsh;
    private String aceptncCo;
    private String wtrcFcltyType;
    private String useCharge;
    private String mainPoint;
    private String safentl;
    private String cvntl;
    private String cfrTrrsrt;
    private String phoneNumber;
    private String institutionNm;
    private String referenceDate;
    private String instt_code;
    private String istt_nm;

    public Response(Domain domain){
        this.id=domain.getId();
        this.fshlcNm =domain.getFshlcNm();
        this.fshlcType =domain.getFshlcType();
        this.rdnmadr =domain.getRdnmadr();
        this.lnmadr =domain.getLnmadr();
        this.latitude =domain.getLatitude();
        this.longitude =domain.getLongitude();
        this.fshlcPhoneNumber =domain.getFshlcPhoneNumber();
        this.waterAr =domain.getWaterAr();
        this.kdfsh =domain.getKdfsh();
        this.aceptncCo =domain.getAceptncCo();
        this.wtrcFcltyType =domain.getWtrcFcltyType();
        this.useCharge =domain.getUseCharge();
        this.mainPoint =domain.getMainPoint();
        this.safentl =domain.getSafentl();
        this.cvntl =domain.getCvntl();
        this.cfrTrrsrt =domain.getCfrTrrsrt();
        this.phoneNumber =domain.getPhoneNumber();
        this.institutionNm =domain.getInstitutionNm();
        this.referenceDate =domain.getReferenceDate();
        this.instt_code =domain.getInsttCode();
        this.istt_nm =domain.getFshlcNm();
    }

    @Data
    @AllArgsConstructor
    public static class Result<T>{
        private T data;
    }

}
