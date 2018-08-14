package com.cat.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 13:27 2018/8/14
 * @Modified By:
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Praise {

    private Integer id;

    private Integer manId;

    private Integer contentId;

    private Date createTime;


    public void setManId(Integer id) {
    }
}
