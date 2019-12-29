package com.shiy.practice.scrawler.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "community")
public class Community {

  @Id
  private long id;

  private String title;

  private String link;

  private String district;

  private String bizcircle;

  private String tagList;

  private String onsale;

  private String onrent;

  private String year;

  private String housetype;

  private String cost;

  private String service;

  private String company;

  @Column(name = "building_num")
  private String buildingNum;

  @Column(name = "house_num")
  private String houseNum;

  private String price;

  private String city;

  private java.sql.Timestamp validdate;
}
