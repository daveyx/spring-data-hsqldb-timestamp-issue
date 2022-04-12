package com.example.demo;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;


@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class DataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private Timestamp ts1;

    private Timestamp ts2;

}
