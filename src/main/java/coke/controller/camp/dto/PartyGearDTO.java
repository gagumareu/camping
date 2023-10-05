package coke.controller.camp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartyGearDTO {

    private Long pgno;

    private Long gno;
    private String gname;
    private String brand;
    private String material;
    private String size;
    private String script;
    private String sort;
    private String state;
    private String s3URL;

    private Long bno;




}
