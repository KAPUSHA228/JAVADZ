package com.example.demo;

public class Clock2 extends Clock implements Time {
    protected int sec;
    Clock2(){super (); sec=0; }
    public Clock2(String ma, int c){ super (ma,c); sec=0;}
    @Override
    public String toGet_Type(){
        return "HMS";
    }
    @Override
    public void toSet(TYPES type, int h) throws TimeExcept
    {
       if(type== TYPES.HOUR){
            hour=h;
            if(hour>=24)
                throw  new TimeExcept("ERROR: Диапазон часов от 0 до 23, исправьте");}
        else if(type== TYPES.MIN){
            min=h;
            if (min>=60)
                throw  new TimeExcept("ERROR: Диапазон минут от 0 до 59, исправьте");}
        //super.toSet(type,h);
        else if(type== TYPES.SEC){
            sec=h;
            if (sec>=60)
                throw  new TimeExcept("ERROR: Диапазон секунд от 0 до 59, исправьте");}
        else throw  new TimeExcept("Заданное время не соотвествует истине");
        System.out.println ("Часы "+mark+" за "+cost+" были переведены на время "+h+" "+type);


    }
    @Override
    public void toMove(TYPES type, int h) throws TimeExcept
    {
        if(type== TYPES.HOUR){
            hour+=h;
            if(hour>=24)
                throw  new TimeExcept("ERROR: Диапазон часов от 0 до 23, исправьте");}
        else if(type== TYPES.MIN){
            min+=h;
            if (min>=60)
                throw  new TimeExcept("ERROR: Диапазон минут от 0 до 59, исправьте");}

        else if(type== TYPES.SEC){
            sec+=h;
            if (sec>=60)
                throw  new TimeExcept("ERROR: Диапазон секунд от 0 до 59, исправьте");}
        else throw  new TimeExcept("Заданное время не соотвествует истине");
        System.out.println ("Часы "+mark+" за "+cost+" были переведены на "+h+" "+type);
    }
}
