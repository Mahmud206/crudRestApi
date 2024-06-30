package com.dbh.restapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
public class BranchDto implements Serializable {

   @Serial
    private static final long serialVersionUID = 1L;


    private  Long ID;

    @NotEmpty
    private String BRANCD;
    @NotEmpty
   // @Size(min = 5,message = "Branch Name Al least 5 Character")
    @Size(min = 5, message = "Branch Name At least 5 Character")
    private String BRANNM;
    @NotEmpty
    private String ADRES1;
    private String ROUTNO;
    private String SWIFTCD;
}
