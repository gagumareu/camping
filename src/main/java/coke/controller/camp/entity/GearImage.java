package coke.controller.camp.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "gear")
public class GearImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ino;

    private String folderPath;

    private String uuid;

    private String fileName;

    private String s3Url;

    @ManyToOne(fetch = FetchType.LAZY)
    private Gear gear;
}
