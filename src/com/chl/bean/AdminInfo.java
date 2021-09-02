package com.chl.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

//映射 adminName
public class AdminInfo {
    public String adminName;
    //因为前端传过来的参数是个 字符串，所以这里要 做个类型转换
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date adminTime;
    private String adminPwd;
//    public String adminSex;
//    public String adminHobby;
//    public String adminClose;
//    public String adminCountry;
    private List<Lover> loverList;
    private Integer[] aihao;  //1.写代码 2.看书 3.读报纸

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Date getAdminTime() {
        return adminTime;
    }

    public void setAdminTime(Date adminTime) {
        this.adminTime = adminTime;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public List<Lover> getLoverList() {
        return loverList;
    }

    public void setLoverList(List<Lover> loverList) {
        this.loverList = loverList;
    }

    public Integer[] getAihao() {
        return aihao;
    }

    public void setAihao(Integer[] aihao) {
        this.aihao = aihao;
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
                "adminName='" + adminName + '\'' +
                ", adminTime=" + adminTime +
                ", adminPwd='" + adminPwd + '\'' +
                ", loverList=" + loverList +
                ", aihao=" + Arrays.toString(aihao) +
                '}';
    }
}
