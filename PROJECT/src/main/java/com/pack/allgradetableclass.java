/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pack;

/**
 *
 * @author hp
 */
public class allgradetableclass {
    private int grade_id;
    private String grade_name;
    private String grade_short_name;
    private long grade_basic;
    private long grade_ta;
    private long grade_da;
    private long grade_hra;
    private long grade_ma;
    private long grade_bonus;
    private long grade_pf;
    private long grade_pt;

    @Override
    public String toString() {
        return "allgradetableclass{" + "grade_id=" + grade_id + ", grade_name=" + grade_name + ", grade_short_name=" + grade_short_name + ", grade_basic=" + grade_basic + ", grade_ta=" + grade_ta + ", grade_da=" + grade_da + ", grade_hra=" + grade_hra + ", grade_ma=" + grade_ma + ", grade_bonus=" + grade_bonus + ", grade_pf=" + grade_pf + ", grade_pt=" + grade_pt + '}';
    }

    public allgradetableclass(int grade_id, String grade_name, String grade_short_name, long grade_basic, long grade_ta, long grade_da, long grade_hra, long grade_ma, long grade_bonus, long grade_pf, long grade_pt) {
        this.grade_id = grade_id;
        this.grade_name = grade_name;
        this.grade_short_name = grade_short_name;
        this.grade_basic = grade_basic;
        this.grade_ta = grade_ta;
        this.grade_da = grade_da;
        this.grade_hra = grade_hra;
        this.grade_ma = grade_ma;
        this.grade_bonus = grade_bonus;
        this.grade_pf = grade_pf;
        this.grade_pt = grade_pt;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public String getGrade_name() {
        return grade_name;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }

    public String getGrade_short_name() {
        return grade_short_name;
    }

    public void setGrade_short_name(String grade_short_name) {
        this.grade_short_name = grade_short_name;
    }

    public long getGrade_basic() {
        return grade_basic;
    }

    public void setGrade_basic(long grade_basic) {
        this.grade_basic = grade_basic;
    }

    public long getGrade_ta() {
        return grade_ta;
    }

    public void setGrade_ta(long grade_ta) {
        this.grade_ta = grade_ta;
    }

    public long getGrade_da() {
        return grade_da;
    }

    public void setGrade_da(long grade_da) {
        this.grade_da = grade_da;
    }

    public long getGrade_hra() {
        return grade_hra;
    }

    public void setGrade_hra(long grade_hra) {
        this.grade_hra = grade_hra;
    }

    public long getGrade_ma() {
        return grade_ma;
    }

    public void setGrade_ma(long grade_ma) {
        this.grade_ma = grade_ma;
    }

    public long getGrade_bonus() {
        return grade_bonus;
    }

    public void setGrade_bonus(long grade_bonus) {
        this.grade_bonus = grade_bonus;
    }

    public long getGrade_pf() {
        return grade_pf;
    }

    public void setGrade_pf(long grade_pf) {
        this.grade_pf = grade_pf;
    }

    public long getGrade_pt() {
        return grade_pt;
    }

    public void setGrade_pt(long grade_pt) {
        this.grade_pt = grade_pt;
    }
}
