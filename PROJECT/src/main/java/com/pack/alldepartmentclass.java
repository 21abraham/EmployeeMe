/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pack;

/**
 *
 * @author hp
 */
public class alldepartmentclass {

    @Override
    public String toString() {
        return "alldepartmentclass{" + "dept_id=" + dept_id + ", dept_name=" + dept_name + '}';
    }
    private int dept_id;
    private String dept_name;
    public alldepartmentclass(int dept_id,String dept_name){
        this.dept_id=dept_id;
        this.dept_name=dept_name;
    }
    public long getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
}
