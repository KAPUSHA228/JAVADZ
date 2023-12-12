package com.example.demo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);
        stage.setTitle("Добро пожаловать в магазин часов");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {launch();}
}

 /*public class Main {

    public static void main(String[] args) {
     Clock c =new Clock ("CASIO",5600);
     Clock2 c2= new Clock2("CASIO", 7800);
     Clock c3 =new Clock ("ROLFO",5600);
     Clock c4 =new Clock ("ROLFO",6800);
     Clock c5 =new Clock ("ROLFO",5600);
     Clock2 c6 =new Clock2 ("ROLFO",7400);
     ClockShop sh= new ClockShop();
     sh.add(c);  sh.add(c2); sh.add(c3);
     sh.add(c4); sh.add(c5); sh.add(c6);

     sh.HighCost();
     sh.Sorted();
     sh.PopMark();
     sh.print();

     try{sh.MegaSet(TYPES.HOUR, 85);}
     catch(TimeExcept ex){ System.out.println(ex.getMessage());}
     System.out.println();



     try{sh.MegaSet(TYPES.MIN,24);}
     catch(TimeExcept ex){ System.out.println(ex.getMessage());}
     System.out.println();



     try{sh.MegaSet(TYPES.SEC ,78);}
     catch(TimeExcept ex){ System.out.println(ex.getMessage());}
        /*JFrame frame = new JFrame();
        frame.setSize(500,400);
        frame.setLocation(500,300);
        frame.setTitle("Hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new BorderLayout());
        JButton btn = new JButton();
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        frame.add(panel,BorderLayout.SOUTH);
        btn.setSize(90,30);
        btn.setText("Добавить");
       // frame.add(btn,BorderLayout.SOUTH);
        panel.add(btn);
        frame.setVisible(true);*/
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
  /*

    }
}*/