package com.cat.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Note {
    private Integer id;

    private Integer man;

    private Date time;

    private String title;

    private String introduct;

    private String content;

    private Integer praiseNum;

}