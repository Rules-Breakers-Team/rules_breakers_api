package com.hackathon.rules_breakers.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Booking implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String client;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private Date booking_date;

    @Column(nullable = false)

    @OneToOne
    @JoinColumn(name = "id_type")
    private Type type;

}
