package com.cat.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 20:20 2018/7/30
 * @Modified By:
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiaryListVo {

    private Integer gender;

    private Integer healthyStatus;

    private String title;

    private Date time;

    private String introduct;

    private String content;

    private List<String> pic;

}
