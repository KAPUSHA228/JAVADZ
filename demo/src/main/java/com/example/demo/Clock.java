package com.example.demo;
import java.io.Serializable;
public class Clock  implements Time,Serializable{
    protected int hour, min, cost,ID;
    protected String mark;
    Clock(){
        hour=0;
        min=0;
        mark=null;
        cost=0;}
    public Clock(String ma, int c, int h, int m, int i) {
        hour=h;
        min=m;
        mark=ma;
        cost=c;
        ID=i;}
    public Clock(String ma, int c, int h, int m) {
        hour=h;
        min=m;
        mark=ma;
        cost=c;}
    @Override
    public int toGet_Sec(){return 0;}
    @Override
    public int toGet_ID(){return ID;}
    @Override
    public void toSet_ID(int i){ID=i;}
    @Override
    public int toGet_Cost(){return cost;}
    @Override
    public int toGet_Hour(){return hour;}
    @Override
    public int toGet_Min(){return min;}
    @Override
    public String toGet_Mark(){return mark;}
    @Override
    public String toGet_Type(){
         return "HM";
    }

    @Override
    public void toSet(TYPES type, int h)throws TimeExcept {
        if(type== TYPES.HOUR){
            if(h>=24){throw  new TimeExcept("ERROR: Диапазон часов от 0 до 23, исправьте");}
            else{ hour=h;}}
        else if(type== TYPES.MIN){
            if (h>=60){throw  new TimeExcept("ERROR: Диапазон минут от 0 до 59, исправьте");}
            else {min=h;}}
        else throw  new TimeExcept("Заданное время не соотвествует истине");
        System.out.println ("Часы "+mark+" за "+cost+" были переведены на время "+h+" "+type);

    }
    @Override
    public void toMove(TYPES type, int h)throws TimeExcept
    {
        if(type== TYPES.HOUR){

            if(h>=24)
                throw  new TimeExcept("ERROR: Диапазон часов от 0 до 23, исправьте");
            else hour+=h;}
        else if(type== TYPES.MIN){
            if (h>=60)
                throw  new TimeExcept("ERROR: Диапазон минут от 0 до 59, исправьте");
            else min+=h;}
        else throw  new TimeExcept("Заданное время не соотвествует истине");
        System.out.println ("Часы "+mark+" за "+cost+" были переведены на  "+h+" "+type);

    }
    @Override
    public String toString() {return "| Time: " + String.format("%02d:%02d", hour, min) + "\n| Brand: " + toGet_Mark() + "\n| Price: " + toGet_Cost() + "\n"; }
    @Override
    public String toGet_Time(){return String.format("%02d:%02d", hour, min);}


}
