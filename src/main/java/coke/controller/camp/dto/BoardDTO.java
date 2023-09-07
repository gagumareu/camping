package coke.controller.camp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardDTO {

    private Long bno;

    @NotEmpty
    @Size(min = 3, max = 500)
    private String title;

    @NotEmpty
    private String content;

    @NotEmpty
    private String category;

    private LocalDateTime regDate, modDate;

    @NotEmpty
    private String email;

    private String memberName;

    private String profileImg;

    private int replyCount;

    @Builder.Default
    private List<BoardImageDTO> boardImageDTOList = new ArrayList<>();

}
