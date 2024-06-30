package com.dbh.restapi.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "LSBANINF" ,schema = "DBH_USER")
public class BranchEntity implements Serializable  {

   @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private  Long ID;
    @Column(name="BRANCD")
    private String BRANCD;
    @Column(name="BRANNM")
    private String BRANNM;
    @Column(name="ADRES1")
    private String ADRES1;
    @Column(name="ROUTNO")
    private String ROUTNO;
    @Column(name="SWIFTCD")
    private String SWIFTCD;


}
