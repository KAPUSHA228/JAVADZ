package com.example.demo;

public interface Time {
    public int toGet_Cost();
    public  String toGet_Mark();
    public String toGet_Type();
    public int toGet_Hour();
    public int toGet_Min();
    public int toGet_Sec();
    public void toSet_ID(int i);
    public void toSet(TYPES type, int h) throws TimeExcept;
    public void toMove(TYPES type, int h) throws TimeExcept;
    public int  toGet_ID();
    public String toGet_Time();

}
