package com.cat.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 11:33 2018/7/18
 * @Modified By:
 **/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CatVo {

    private String name;

    private String catPic;

    private Integer healthyStatus;

    private Integer gender;

    private Date brith;

}
