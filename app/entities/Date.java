package entities;

import java.io.Serializable;

public class Date implements Serializable {
    private int year;
    private int month;
    private int day;

    public Date() {
    }

    public Date(int day, int month, int year) {
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
    }

    //getters to get the day , month and year
    public int getYear() { return year; }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }

    //setters to set the day , month and year
    public void setYear(int year) { this.year = year; }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return day+"/"+month+"/"+year;
    }
}
