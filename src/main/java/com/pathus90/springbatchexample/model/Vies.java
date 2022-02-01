package com.pathus90.springbatchexample.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Vies")
public class Vies {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "C_I_IDF")
    private String idVies;

    @Column(name = "T_PAYS_ISO_CODE")
    private String isoCode;

    @Column(name = "T_I_TVA_NUM")
    private String vatNumber;


}
