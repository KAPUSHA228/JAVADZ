package com.example.demo;

public class Clock  implements Time{
    protected int hour, min, cost;
    protected String mark;
    Clock(){hour=0;
        min=0;
        mark=null;
        cost=0;}
    public Clock(String ma, int c) {
        hour=0;
        min=0;
        mark=ma;
        cost=c;
    }
    @Override
    public int toGet_Cost(){return cost;}
    @Override
    public String toGet_Mark(){return mark;}
    @Override
    public String toGet_Type(){
         return "HM";
    }
    @Override
    public void toSet(TYPES type, int h)throws TimeExcept {
        if(type== TYPES.HOUR){
            hour=h;
            if(hour>=24)
                throw  new TimeExcept("ERROR: Диапазон часов от 0 до 23, исправьте");}
        else if(type== TYPES.MIN){
            min=h;
            if (min>=60)
                throw  new TimeExcept("ERROR: Диапазон минут от 0 до 59, исправьте");}
        else throw  new TimeExcept("Заданное время не соотвествует истине");
        System.out.println ("Часы "+mark+" за "+cost+" были переведены на время "+h+" "+type);

    }
    @Override
    public void toMove(TYPES type, int h)throws TimeExcept
    {
        if(type== TYPES.HOUR){
            hour+=h;
            if(hour>=24)
                throw  new TimeExcept("ERROR: Диапазон часов от 0 до 23, исправьте");}
        else if(type== TYPES.MIN){
            min+=h;
            if (min>=60)
                throw  new TimeExcept("ERROR: Диапазон минут от 0 до 59, исправьте");}
        else throw  new TimeExcept("Заданное время не соотвествует истине");
        System.out.println ("Часы "+mark+" за "+cost+" были переведены на  "+h+" "+type);

    }


}
