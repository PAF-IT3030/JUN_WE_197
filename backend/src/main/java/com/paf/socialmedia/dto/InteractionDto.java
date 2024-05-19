package com.pafnew.PAFassigment.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InteractionDto {

    private Long id;
    private String content;
    private Date date;
    private Time time;
}
