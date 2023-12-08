package com.example.demo;

import java.util.*;
import java.util.function.Consumer;
import java.lang.Iterable;
public class ClockShop implements Iterable<Clock> {
        ArrayList<Clock> clocks;
        ArrayList<Server> servers;
        ClockShop(){
        clocks= new ArrayList<>();
        servers=new ArrayList<>();   }
        public void add(Clock c){
            clocks.add(c);
                events();  }
        public void remove(Clock c){
                clocks.remove(c);
                events();    }
        public void add(Clock2 c){
                clocks.add(c);
                events();    }
        public void remove(Clock2 c){
                clocks.remove(c);
                events(); }

    public void events(){servers.forEach( (o)->{o.event(this);});}
        public void sub (Server s){servers.add(s);}
        public Integer HighCost(){
        ArrayList<Integer> costs= new ArrayList<>();
        for(Clock c: clocks){costs.add(c.cost);}
        return Collections.max(costs);}
        public String PopMark(){
        int maxCount = 0;
        ArrayList<String> marks= new ArrayList<>();
        for(Clock c: clocks){marks.add(c.mark);}
        String mostFrequentMark = null;
        for (String mark : marks) {
                int count = Collections.frequency(marks, mark);
                if (count > maxCount) {
                        maxCount = count;
                        mostFrequentMark = mark;
                }} System.out.println("Наиболее часто встречающаяся марка часов: " + mostFrequentMark);
                System.out.println();
                return mostFrequentMark;
        }
        public ArrayList<String>  Sorted(){
        ArrayList<String> uniqueMarks = new ArrayList<>();
        for (Clock s : clocks)
        { if (!uniqueMarks.contains(s.mark)) { uniqueMarks.add(s.mark); } }
        Collections.sort(uniqueMarks);
        System.out.println("Марки часов без повторений в упорядоченном виде:");
        for (String s: uniqueMarks) {System.out.println(s);}
                System.out.println();
        return uniqueMarks;
        }
        public void print(){
                for(Clock c: clocks){
                        System.out.println(c.mark);
                }
                System.out.println();
        }
        public boolean MegaSet(TYPES type, int h) throws TimeExcept
        {
        if(type== TYPES.SEC){
                for (Clock i: clocks){
                        if (i instanceof Clock)
                                System.out.println("Этот тип часов не поддерживает настройку секунд");
                        if (i instanceof Clock2)
                                i.toSet(type, h);
                }
        }
        if(type== TYPES.MIN)  {
                for (Clock i: clocks)  {i.toSet(type, h); } }
        if(type== TYPES.HOUR) {
                for (Clock i: clocks) { i.toSet(type, h); } }
        return true;
        }

       @Override
        public void forEach(Consumer<? super Clock> action) {
                Iterable.super.forEach(action);
        }
        @Override
        public Iterator<Clock> iterator(){return clocks.iterator();}

        @Override
        public Spliterator<Clock> spliterator() {
                return Iterable.super.spliterator();
        }

}
