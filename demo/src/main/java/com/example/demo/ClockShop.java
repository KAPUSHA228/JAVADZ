package com.example.demo;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.util.function.Consumer;
import java.lang.Iterable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClockShop implements Iterable<Time>,Serializable {
        ArrayList<Time> clocks;
        transient ArrayList<Server> servers;
        transient Connection con;
       /* void connect(){
            try{Class.forName("org.sqlite.JDBC");
                  con= DriverManager.getConnection("jdbc:sqlite:глянь у Козинова лекцию по sql, там будет объяснение как создать свою и что тут писать");
                System.out.println("DataBase is open");
            }
            catch(ClassNotFoundException ex){
                System.out.println("Driver is not found");
            }
            catch(SQLException ex){
                System.out.println("DataBase is not connect");
            }
        }*/
        void selectAll(){
            clocks.clear();
            try{Statement st= con.createStatement();
                ResultSet res = st.executeQuery("select * from Clock_Table");
                while(res.next()){
                   if(res.getString("Type").equals("HM"))
                   { clocks.add(new Clock(res.getString("Mark"),
                                          res.getInt("Cost"),
                                          res.getInt("Hour"),
                                          res.getInt("Minute"),
                                          res.getInt("ID")));}
                   if(res.getString("Type").equals("HMS"))
                   { clocks.add(new Clock2(res.getString("Mark"),
                                            res.getInt("Cost"),
                                            res.getInt("Hour"),
                                            res.getInt("Minute"),
                                            res.getInt("Second"),
                                            res.getInt("ID")));}
                }
            }
            catch(SQLException ex){
                Logger.getLogger(ClockShop.class.getName()).log(Level.SEVERE,null,ex);
            }
            events();
        }
        public ClockShop(){
            // connect();
            clocks= new ArrayList<>();
            servers=new ArrayList<>();
           // selectAll();
        }
        public void add(Time c){

            /*try {
                PreparedStatement statement= con.prepareStatement("INSERT INTO Clock_Table(Mark, Cost, Type, Hour, Minute, Second) VALUES (?,?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
                statement.setString(1,c.toGet_Mark());
                statement.setInt(2,c.toGet_Cost());
                statement.setString(3,c.toGet_Type());
                statement.setInt(4,c.toGet_Hour());
                statement.setInt(5,c.toGet_Min());
                statement.setInt(6,c.toGet_Sec());

                int affectedRows = statement.executeUpdate();
                if(affectedRows==0){throw new SQLException("Creating user failed, no rows affected");}
                ResultSet genKeys =statement.getGeneratedKeys();
                if(genKeys.next()){
                    c.toSet_ID((int)genKeys.getLong(1));
                }
            } catch(SQLException ex){ Logger.getLogger(ClockShop.class.getName()).log(Level.SEVERE,null,ex);}*/
            clocks.add(c);
            events();
        }


        public void remove(Time c){
            /*try {
                PreparedStatement statement= con.prepareStatement("DELETE FROM INTO Clock_Table WHERE ID = ?");
                statement.setInt(1,c.toGet_ID());
                statement.executeUpdate();


            } catch(SQLException ex){ Logger.getLogger(ClockShop.class.getName()).log(Level.SEVERE,null,ex);}*/
                clocks.remove(c);
                events(); }

    public void events(){servers.forEach( (o)->{o.event(this);});}
        public void sub (Server s){
            servers.add(s);
           // events();
        }
        public Integer HighCost(){
            ArrayList<Integer> costs= new ArrayList<>();
            for(Time c: clocks){costs.add(c.toGet_Cost());}
            return Collections.max(costs);
        }

        public String PopMark(){
        int maxCount = 0;
        ArrayList<String> marks= new ArrayList<>();
        for(Time c: clocks){marks.add(c.toGet_Mark());}
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
        for (Time s : clocks)
        { if (!uniqueMarks.contains(s.toGet_Mark())) { uniqueMarks.add(s.toGet_Mark()); } }
        Collections.sort(uniqueMarks);
        System.out.println("Марки часов без повторений в упорядоченном виде:");
        for (String s: uniqueMarks) {System.out.println(s);}
                System.out.println();
        return uniqueMarks;
        }
        public void print(){
                for(Time c: clocks){
                        System.out.println(c.toGet_Mark());
                }
                System.out.println();
        }
        public void MegaSet(TYPES type, int h) throws TimeExcept
        {
            for (Time clock : clocks){
                clock.toSet(type, h);
            }
            events();
        }

       @Override
        public void forEach(Consumer<? super Time> action) {
                Iterable.super.forEach(action);
        }
        @Override
        public Iterator<Time> iterator(){return clocks.iterator();}

        @Override
        public Spliterator<Time> spliterator() {
                return Iterable.super.spliterator();
        }

}
