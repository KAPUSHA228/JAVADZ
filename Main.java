package org.example;
import java.util.*;
import java.util.Collections;



class Main {
    public static void main(String[] args) throws TimeExcept {


//FIBONACCI
       /*Scanner sc =new Scanner (System.in) ;
        System.out.print("Введите количество чисел в последовательности Фибоначчи: ");
        int n=sc.nextInt () ;
        int[] mas = new int [n];
        mas[0]=1;
        mas[1]=1;
        for (int i=2; i<n;++i){
            mas[i]=mas[i-1]+mas [i-2]; }
        for (int i=0; i<n;++i){
            System.out.print(mas [i]+" "); }*/

//MONSTERS
      /* Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество монстров: ");
        int N = sc.nextInt();
        int[] health = new int[N];
        System.out.print("Введите размер здоровья каждого монстра: ");
        for (int i = 0; i < N; ++i)
            health[i] = sc.nextInt();
        System.out.print("Введите урон от ружья охотника: ");
        int k = sc.nextInt();
        int number = -1;
        int maxHP=100;
        for (int i = 0; i < N; ++i)
            health[i]=health[i]%k;
        for (int i = 0; i < N; ++i){
            if(health[i]==0) { System.out.print(health[i]+1+" "); }  }
        while(maxHP>0) {
            maxHP=0;
            for (int i = 0; i < N; ++i) {
                if (health[i] > maxHP) {
                    maxHP=health[i];
                    number = i;
                }
            }
            health[number]=0;
            if(health[number]<1 && maxHP>0)
            {
                System.out.print(number+1+" ");
            }
            else break;
        }*/
        //ANIMAL
        /*Animal an= new Animal ("Meat" , "Tiger" , "predator" , "mlec" , "RRRRRRR" ) ;
        an.toGet_Voice();
        an.toGet_FormOfEat();
        an.toGet_Klass();
        an.toGet_Name();
        an.toGet_Type();
        Zooland z= new Zooland();
        z.toSetKletka(an);
        z.WalkZoo();*/
        //CLOCK
        //RATIONAL
        /* Rational r1= new Rational(2,-3);
        Rational r2 = new Rational (-4,2);
        r2.reduce(r2);
        r1.toSum(r1,r2);
        r1.toSub(r1,r2);
        r1.toMulti(r1,r2);
        r1.toDiv(r1,r2);*/
        Clock c =new Clock ("CASIO",5600);
        Clock2 c2= new Clock2("CASIO", 7800);

        // c.toSet(12,50);
        // c.toMove (1,20);
        // c.toGet_Cost();
        // c.toGet_Mark();
        // c2.toMove(30,5,60);
        Clock c3 =new Clock ("ROLFO",5600);
        Clock c4 =new Clock ("ROLFO",6800);
        Clock c5 =new Clock ("ROLFO",5600);
        Clock2 c6 =new Clock2 ("ROLFO",7400);
        ClockShop sh= new ClockShop();
        sh.add(c);
        sh.add(c2);
        sh.add(c3);
        sh.add(c4);
        sh.add(c5);
        sh.add(c6);
        sh.PopCost();
        sh.Sorted();
        sh.PopMark();
        try{sh.MegaSet(TYPES.HOUR,24,TYPES.MIN, 78, TYPES.SEC ,65);}
        catch(TimeExcept ex){ System.out.println(ex.getMessage());}
        try{sh.MegaSet(TYPES.MIN,24,TYPES.HOUR, 78, TYPES.SEC ,65);}
        catch(TimeExcept ex){ System.out.println(ex.getMessage());}
        try{sh.MegaSet(TYPES.HOUR,18,TYPES.MIN, 78, TYPES.SEC ,65);}
        catch(TimeExcept ex){ System.out.println(ex.getMessage());}
        try{c2.toMove(TYPES.HOUR,23,TYPES.MIN, 59, TYPES.SEC ,65);}
        catch(TimeExcept ex){ System.out.println(ex.getMessage());}

        try{sh.MegaSet(TYPES.HOUR,18,TYPES.MIN, 45, TYPES.SEC ,25);}
        catch(TimeExcept ex){ System.out.println(ex.getMessage());}

        try{c2.toSet(TYPES.HOUR,23,TYPES.MIN, 59, TYPES.SEC ,102);}
        catch(TimeExcept ex){ System.out.println(ex.getMessage());}
        try{c2.toSet(TYPES.HOUR,23,TYPES.MIN, 59, TYPES.SEC ,240);}
        catch(TimeExcept ex){ System.out.println(ex.getMessage());}
    }
}

class Animal{
    private String FormOfEat, name, type, klass, voice;
    Animal(String f, String n, String  t, String k, String v) {
        FormOfEat=f;
        name=n;
        type=t;
        klass=k;
        voice=v;
    }
    public void toGet_Voice()
    {System.out.println (name+" издаёт звук "+voice) ;}
    public void toGet_Klass()
    {System.out.println (name+" относится к классу "+klass) ;}
    public  void toGet_Type()
    {System.out.println (name+" относится к типу "+type) ;}
    public  void toGet_Name()
    {System.out.println ("У "+name+" есть имя  "+name) ;}
    public  void toGet_FormOfEat()
    {System.out.println (name+" питается "+FormOfEat) ;}
}
class Zooland {
    private
    Animal[] Kletka= new Animal[4];
    public
    Zooland(){
        for (int i = 0; i < Kletka.length; i++)
            Kletka[i]=null;


    }
    public void toSetKletka(Animal a)
    {
        for (int i = 0; i < Kletka.length; i++)
        {
            if (Kletka[i] != null) continue;
            else
            { Kletka[i] = a; break;  }
        }
    }
    public void WalkZoo(){
        for (int i = 0; i < Kletka.length; i++){
            if (Kletka[i] != null)
                Kletka[i].toGet_Voice();
            else
                System.out.println("Клетка "+(i+1)+" пустая");
        }
    }
}
class Rational{
    private int a, b;
    Rational() {a=1; b=1;}
    Rational (int r1, int r2)
    {
        a=r1; b=r2;
        if(r2<0){
            a= -a;
            b=Math.abs(b);
        }
    }
    public void reduce(Rational c)
    {
        if  ((c.a<0) && (c.b<0))
        {
            c.a=Math.abs(c.a);
            c.b=Math.abs(c.b);
        }
        if (c.a == c.b)
        {c.a = c.b = 1;}
        while ((c.a % 2 == 0) && (c.b % 2 == 0))
        {
            c.a = c.a / 2;
            c.b = c.b / 2;
        }
        while ((c.a > 1) && (c.b > 1))
        {
            if (c.a < c.b)
            {
                for (int i = 2; i <= c.a; i++)
                {
                    if ((c.a % i == 0) && (c.b % i == 0))
                    {
                        c.a = c.a / i;
                        c.b = c.b / i;
                    }
                }
            }
            else
            {
                for (int i = 2; i <= c.b; i++)
                {
                    if ((c.a % i == 0) && (c.b % i == 0))
                    {
                        c.a = c.a / i;
                        c.b = c.b / i;
                    }
                }
            }
            break;
        }
        if(c.b==1){System.out.println (c.a);}
        else {System.out.println(c.a+"/"+c.b) ;}
    }

    public void toSum(Rational r1, Rational r2)
    {
        System.out.println ("Арифметические действия над дробями: "+r1.a+"/"+r1.b +" и " + r2.a+"/"+r2.b+": ");
        System.out.print ("Результат сложения: ");
        Rational r3 =new Rational();
        r3.a= r1.a*r2.b+r2.a*r1.b;
        r3.b=r1.b*r2.b;
        r3.reduce(r3);
    }
    public void toSub(Rational r1, Rational r2)
    {
        System.out.print ("Результат вычитания: ");
        Rational r3 =new Rational();
        r3.a= r1.a*r2.b -r2.a*r1.b ;
        r3.b=r1.b*r2.b;
        r3.reduce(r3);

    }
    public void toMulti(Rational r1, Rational r2)
    {
        System.out.print ("Результат умножения: ");
        Rational r3 =new Rational();
        r3.a= r1.a*r2.a;
        r3.b=r1.b*r2.b;
        r3.reduce(r3);
    }
    public void toDiv(Rational r1, Rational r2)
    {
        System.out.print ("Результат деления: ");
        Rational r3 =new Rational();
        r3.a= r1.a*r2.b;
        r3.b=r1.b*r2.a;
        r3.reduce(r3);

    }
}
class MathPred extends Rational{

}
class Fabric {
    static Clock build(int count, String name){
        return new Clock(name, count);
    }
    static Clock2 build2(int count, String name){
        return new Clock2(name, count);
    }
}
interface Time{
    public int toGet_Cost();
    public  String toGet_Mark();
    public void toSet(TYPES type1, int h,TYPES type2, int m) throws TimeExcept;
    public void toMove(TYPES type1, int h,TYPES type2, int m) throws TimeExcept;


}
class TimeExcept extends Exception{
    public TimeExcept(String message) {
        super(message);
    }
}

class Clock implements Time{
    protected int hour, min, cost;
    protected String mark;
    Clock(){}
    public Clock(String ma, int c) {
        hour=0;
        min=0;
        mark=ma;
        cost=c;
    }
    public int toGet_Cost()
    {System.out.println ("Текущая стоимость этих часов: "+cost) ; return cost;}
    public String toGet_Mark()
    {System.out.println ("Марка часов - "+mark) ; return mark;}
    @Override
    public void toSet(TYPES type1, int h, TYPES type2, int m)throws TimeExcept{
        if((type1== TYPES.HOUR) && (type2==TYPES.MIN))
        {
            hour=h;
            min=m;
            if(hour>=24) throw  new TimeExcept("ERROR: Диапазон часов от 0 до 23, исправьте");
            if (min>=60) throw  new TimeExcept("ERROR: Диапазон минут от 0 до 59, исправьте");
            System.out.println ("Текущее время часов "+mark+" за "+cost+" ("+hour+":"+min+")") ;}
        else throw  new TimeExcept("Заданное время не соотвествует истине");
    }
   @Override
    public void toMove(TYPES type1, int h,TYPES type2, int m)throws TimeExcept
    {
        if((type1== TYPES.HOUR) && (type2==TYPES.MIN))
        {
            hour+=h;
            min+=m;
            if(hour>=24) throw  new TimeExcept("ERROR: Диапазон часов от 0 до 23, исправьте");
            if (min>=60) throw  new TimeExcept("ERROR: Диапазон минут от 0 до 59, исправьте");

            System.out.println ("Текущее время было переставлено на "+hour+":"+min);}
        else throw  new TimeExcept("Заданное время не соотвествует истине");
    }


}
class Clock2 extends Clock implements Time{
    int sec;
    public Clock2(String ma, int c){ super (ma,c); sec=0;}
    public void toSet(TYPES type1, int h,TYPES type2, int m,TYPES type3, int s) throws TimeExcept
    {
        if((type1== TYPES.HOUR) && (type2==TYPES.MIN) && (type3==TYPES.SEC))
        {
            hour=h;
            min=m;
            sec=s;
            if(hour>=24) throw  new TimeExcept("ERROR: Диапазон часов от 0 до 23, исправьте");
            if (min>=60) throw  new TimeExcept("ERROR: Диапазон минут от 0 до 59, исправьте");
            if (sec>=60) throw  new TimeExcept("ERROR: Диапазон секунд от 0 до 59, исправьте");

            System.out.println ("Текущее время часов "+mark+" за "+cost+" ("+hour+":"+min+":"+sec+")");
        }
        else throw  new TimeExcept("Заданное время не соотвествует истине");
    }
    public void toMove(TYPES type1, int h,TYPES type2, int m, TYPES type3 ,int s) throws TimeExcept
    {
        if((type1== TYPES.HOUR) && (type2==TYPES.MIN) && (type3==TYPES.SEC))
        {
            hour+=h;
            min+=m;
            sec+=s;
            if(hour>=24) throw  new TimeExcept("ERROR: Диапазон часов от 0 до 23, исправьте");
            if (min>=60) throw  new TimeExcept("ERROR: Диапазон минут от 0 до 59, исправьте");
            if (sec>=60) throw  new TimeExcept("ERROR: Диапазон секунд от 0 до 59, исправьте");

            System.out.println ("Текущее время было переставлено на "+hour+":"+min+":"+sec);}
        else throw  new TimeExcept("Заданное время не соотвествует истине");
    }
}
class ClockShop{
    List<Integer> costs;
    List<String> marks;
    List<Clock> clocks;
    ClockShop(){
        costs =new ArrayList<>();
        marks =new ArrayList<>();
        clocks= new ArrayList<>();
    }

    public void add(Clock c){
        clocks.add(c);
        costs.add(c.cost);
        marks.add(c.mark);}

    public void add(Clock2 c){
        clocks.add(c);
        costs.add(c.cost);
        marks.add(c.mark);

    }
    public void PopCost(){
        Collections.sort(costs);
        /*for (Integer i: list){
            System.out.println(i);}*/
        System.out.println("Самые дорoгие часы имеют цену "+ costs.get(costs.size()-1));
    }
    public void PopMark(){
        int maxCount = 0;
        String mostFrequentMark = null;
        for (String mark : marks) {
            int count = Collections.frequency(marks, mark);
            if (count > maxCount) {
                maxCount = count;
                mostFrequentMark = mark;
            }
        } System.out.println("Наиболее часто встречающаяся марка часов: " + mostFrequentMark);
    }

    public void  Sorted(){
        List<String> uniqueMarks = new ArrayList<>();
        for (String s : marks)
        { if (!uniqueMarks.contains(s)) { uniqueMarks.add(s); } }
        Collections.sort(uniqueMarks);
        System.out.println("Марки часов без повторений в упорядоченном виде:");
        for (String s: uniqueMarks) {System.out.println(s);}
    }
    public void MegaSet(TYPES type1, int h,TYPES type2, int m) throws TimeExcept{
        if((type1== TYPES.HOUR) && (type2==TYPES.MIN))
        {for (Clock i: clocks)
            i.toSet(type1,h,type2,m);
        }

    }
    public void MegaSet(TYPES type1, int h,TYPES type2, int m, TYPES type3, int s)  throws TimeExcept{
        if((type1== TYPES.HOUR) && (type2==TYPES.MIN) && (type3==TYPES.SEC)) {
            for (Clock i : clocks) {
                if (i instanceof Clock) i.toSet(type1, h, type2, m + s / 60);
                if (i instanceof Clock2) {
                    Clock2 i2 = (Clock2) i;
                    i2.toSet(type1, h, type2, m, type3, s);
                }
            }
            System.out.println("Пользователь задал начальное время часов: "+h+":"+m+":"+s);
        }
        else System.out.println("Пользователь задал невалидное начальное время часов: "+h+":"+m+":"+s);

    }


}
