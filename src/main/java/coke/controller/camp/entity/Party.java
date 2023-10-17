package coke.controller.camp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"board", "member"})
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    private String location;

    private String appointment;

    private int person;

    public void changeDDay(String appointment){
        this.appointment = appointment;
    }

    public void changeLocation(String location){
        this.location = location;
    }



}
