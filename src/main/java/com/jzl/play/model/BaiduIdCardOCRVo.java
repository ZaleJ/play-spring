package com.jzl.play.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：jizhaolun
 * @date ：Created in 2019/9/11 15:48
 * @description：BaiduOCR识别身份证实体类
 * @modified By：
 * @version: $
 */
@Data
@NoArgsConstructor
public class BaiduIdCardOCRVo {
    // 姓名
    private String personName;

    // 出生年月
    private Data personBirthday;

    // 性别
    private String personSex;

    // 民族
    private String personNation;

    // 住址
    private String personAddress;

    // 身份证号
    private String personId;

    // 异常信息
    private String riskType;

    // 识别状态
    private String imageStatus;

}
