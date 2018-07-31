package com.cat.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 19:59 2018/7/30
 * @Modified By:
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Diary {

    private Integer id;

    private Integer cat;

    private Integer man;

    private Date time;

    private String title;

    private String introduct;

    private String content;
}
