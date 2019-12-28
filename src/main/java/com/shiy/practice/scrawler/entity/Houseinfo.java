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
@Table(name = "houseinfo")
public class Houseinfo {

  @Id
  private String houseId;

  private String title;

  private String link;

  private String community;

  private String years;

  private String housetype;

  private String square;

  private String direction;

  private String floor;

  private String taxtype;

  private String totalPrice;

  private String unitPrice;

  private String followInfo;

  private String decoration;

  private java.sql.Timestamp validdate;
}
