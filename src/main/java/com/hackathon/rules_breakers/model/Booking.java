package com.hackathon.rules_breakers.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Booking implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String client;

  @Column(nullable = false)
  private String phone_number;

  @Column(nullable = false)
  private Date booking_date;

  @ManyToOne
  @JoinColumn(name = "id_type")
  private Type type;

}
