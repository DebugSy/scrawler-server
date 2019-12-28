package com.shiy.practice.scrawler.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class HousePriceAvg {

    private String community;

    private long houseCount;

    private double avgPrice;

}
