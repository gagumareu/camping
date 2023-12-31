package coke.controller.camp.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "board")
public class BoardImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ino;

    private String folderPath;

    private String uuid;

    private String fileName;

    private String s3Url;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
}
