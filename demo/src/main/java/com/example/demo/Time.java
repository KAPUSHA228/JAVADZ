package com.example.demo;

public interface Time {
    public int toGet_Cost();
    public  String toGet_Mark();
    public String toGet_Type();
    public void toSet(TYPES type, int h) throws TimeExcept;
    public void toMove(TYPES type, int h) throws TimeExcept;


}
