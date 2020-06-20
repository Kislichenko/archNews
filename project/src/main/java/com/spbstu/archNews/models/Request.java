package com.spbstu.archNews.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "requests")
@NoArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "ad_block_type")
    @Enumerated(EnumType.STRING)
    private AdBlockType adBlockType;

    @Column(name = "ad_duration")
    private Integer adDuration;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "legal_data")
    private String legalData;

    @Column(name = "status")
    private String status;

    @Column(name = "open_ad_date")
    private String openAdDate;

    @Column(name = "cost")
    private Integer cost;

    //@Column(name = "person")
    //private Person person;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    public Request(AdBlockType adBlockType,
                   Integer adDuration,
                   String startDate,
                   String legalData,
                   String status,
                   String openAdDate,
                   Integer cost,
                   String type,
                   String description){
        this.adBlockType = adBlockType;
        this.adDuration = adDuration;
        this.startDate = startDate;
        this.legalData = legalData;
        this.status=status;
        this.openAdDate = openAdDate;
        this.cost = cost;
        this.type = type;
        this.description = description;
    }

}
