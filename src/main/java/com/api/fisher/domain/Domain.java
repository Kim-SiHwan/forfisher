package com.api.fisher.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
    private String insttCode;

    @Builder(builderMethodName = "init")
    public Domain(Long id, String fshlcNm, String fshlcType, String rdnmadr, String lnmadr, String latitude, String longitude, String fshlcPhoneNumber, String waterAr, String kdfsh, String aceptncCo, String wtrcFcltyType, String useCharge, String mainPoint, String safentl, String cvntl, String cfrTrrsrt, String phoneNumber, String institutionNm, String referenceDate, String insttCode) {
        this.id = id;
        this.fshlcNm = fshlcNm;
        this.fshlcType = fshlcType;
        this.rdnmadr = rdnmadr;
        this.lnmadr = lnmadr;
        this.latitude = latitude;
        this.longitude = longitude;
        this.fshlcPhoneNumber = fshlcPhoneNumber;
        this.waterAr = waterAr;
        this.kdfsh = kdfsh;
        this.aceptncCo = aceptncCo;
        this.wtrcFcltyType = wtrcFcltyType;
        this.useCharge = useCharge;
        this.mainPoint = mainPoint;
        this.safentl = safentl;
        this.cvntl = cvntl;
        this.cfrTrrsrt = cfrTrrsrt;
        this.phoneNumber = phoneNumber;
        this.institutionNm = institutionNm;
        this.referenceDate = referenceDate;
        this.insttCode = insttCode;
    }
}
