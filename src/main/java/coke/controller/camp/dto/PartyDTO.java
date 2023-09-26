package coke.controller.camp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartyDTO {

    private Long pno;

    private Long bno;

    private String location;

    private String email;
    private String userName;
    private String profileImg;

    private Long gno;
    private String gname;
    private int state;
    private String sort;

    private Long ino;
    private String fileName;
    private String s3Url;


}
