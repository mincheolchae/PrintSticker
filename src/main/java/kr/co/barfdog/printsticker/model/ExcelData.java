package kr.co.barfdog.printsticker.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ExcelData {

    private int index;
    private String merchantUid;  //주문번호
    private String orderStatus;  //주문상태
    private String subscribeStatus;  //구독상태
    private String memberName;  //견주
    private String deliveryName;  //수령자
    private String dogType;  //견종
    private String dogName;  //견명
    private int numOfPacks;  //팩수
    private double starterPremium;  //SP
    private double turkeyAndBeef;  //TB
    private double duckAndLamb;  //DL
    private double lambAndBeef;  //LB
    private double premiumChicken;  //PC
    private double premiumTurkey;  //PT
    private double premiumLamb;  //PL
    private double premiumBeef;  //PB
    private int deliveryInterval;  //배송주기(일)
    private String dogGender;  //견 성별
    private int dogBirth;  //견 출생년월
    private String dogSize;  // 소,중,대
    private double dogWeight;  //견 무게
    private String dogNeutralization;  //중성화 여부
    private String dogActivityLevel;  //견 활동량
    private int dogWalkingCountPerWeek;  //견 산책량(1주당 몇 회)
    private double dogWalkingTimePerOneTime;  //견 산책량(1회당 몇 시간)
    private String dogStatus;  //견 현재상태
    private String dogSnackCountLevel;  //견 간식량
    private String dogInedibleFood;  //못먹는 음식
    private String dogInedibleFoodEtc;  //못먹는 음식 기타
    private String dogCaution; //기타 질병



}