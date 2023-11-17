/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pack;

/**
 *
 * @author hp
 */
public class allgdetailclass {
    private long transaction_id;
    private int emp_id;
    private long emp_dept_id;
    private long emp_grade_id;
    private String emp_to_date;
    private String emp_from_date;

    @Override
    public String toString() {
        return "allgdetailclass{" + "transaction_id=" + transaction_id + ", emp_id=" + emp_id + ", emp_dept_id=" + emp_dept_id + ", emp_grade_id=" + emp_grade_id + ", emp_to_date=" + emp_to_date + ", emp_from_date=" + emp_from_date + '}';
    }

    public allgdetailclass(long transaction_id, int emp_id, long emp_dept_id, long emp_grade_id, String emp_to_date, String emp_from_date) {
        this.transaction_id = transaction_id;
        this.emp_id = emp_id;
        this.emp_dept_id = emp_dept_id;
        this.emp_grade_id = emp_grade_id;
        this.emp_to_date = emp_to_date;
        this.emp_from_date = emp_from_date;
    }

    public long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public long getEmp_dept_id() {
        return emp_dept_id;
    }

    public void setEmp_dept_id(long emp_dept_id) {
        this.emp_dept_id = emp_dept_id;
    }

    public long getEmp_grade_id() {
        return emp_grade_id;
    }

    public void setEmp_grade_id(long emp_grade_id) {
        this.emp_grade_id = emp_grade_id;
    }

    public String getEmp_to_date() {
        return emp_to_date;
    }

    public void setEmp_to_date(String emp_to_date) {
        this.emp_to_date = emp_to_date;
    }

    public String getEmp_from_date() {
        return emp_from_date;
    }

    public void setEmp_from_date(String emp_from_date) {
        this.emp_from_date = emp_from_date;
    }

}
