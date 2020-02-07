package deneme;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


class Graphic  {




    public JButton giris,cikis,giris_2;
    public JPanel p,p_2;
    public JFrame f;
    public ImageIcon resm;
    public JLabel rsm,rsm_2;
    public ImageIcon[] kartlar;
    int[] x;
    int[] y;


    public Graphic(){

        f = new JFrame("POKEMON");
        f.setSize(1650,1250);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setUndecorated(true);
    }

    public void calistir(){

        p = new JPanel();
        p.setLayout(null);

        resm = new ImageIcon("pokemon1.jpg");
        rsm = new JLabel(resm);
        rsm.setSize(1600, 1000);
        giris = new JButton("PC vs Player");
        giris_2=new JButton("PC vs PC");
        cikis=new JButton("EXİT");
        giris.setBounds(1100, 300, 150, 50);
        giris.setBackground(Color.gray);
        giris_2.setBounds(1100, 200, 150, 50);
        giris_2.setBackground(Color.gray);
        cikis.setBounds(1100, 400, 150, 50);
        cikis.setBackground(Color.gray);
        f.setContentPane(p);
        f.setResizable(true);
        f.setVisible(true);
        p.add(giris_2);
        p.add(giris);
        p.add(cikis);
        p.add(rsm);

        giris.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                String isim=JOptionPane.showInputDialog("İsiminiz :");
                p.setVisible(false);
                f.setContentPane(new raphic(isim));
                f.setVisible(true);




            }
        });

        giris_2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {



                p.setVisible(false);
                f.setContentPane(new pc());
                f.setVisible(true);




            }
        });

        cikis.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);

            }
        });

    }

    }


class raphic extends JPanel implements MouseListener,ActionListener {

ArrayList<Pokemon>kartdestesi=new ArrayList<Pokemon>();
Kullanici gamer=new Kullanici();
Bilgisayar pc=new Bilgisayar();
int sayi=0;
int[] x_1=new int[10];
int[] x_2=new int[10];

int[] y_1=new int[10];
int[] y_2={600,600,600,600,600,600,600,600,600,600};

int[] a=new int[10];
int tutucu_1=0;
int tutucu_2=0;
int devam_sayaci=0;
JButton devam=new JButton("Devam et");
String kelime="\"Kart seçtikten sonra devam et butonuna basınız\"";
JLabel goster=new JLabel(kelime);
JLabel oyuncuskor=new JLabel();
JLabel bilgisayarskor=new JLabel();
JLabel destedencek=new JLabel("Desteden kart çekiniz");
JLabel kazanan=new JLabel();
JButton bitir=new JButton("Bitir");
int gecicisam=0;
int ikincitur=0;
int kart_1=0;
int kart_2=1;
int kart_3=2;
int sayac=0;
BufferedImage arka;

    public raphic(String isim){
gamer.setOyuncuAdi(isim);
kartdestesi.add(new Bulbasaur("Bulbasaur","hava"));
kartdestesi.add(new Butterfree("Butterfree","toprak"));
kartdestesi.add(new Charmander("Charmander","Ateş"));
        kartdestesi.add(new Jigglypuff("Jigglypuff","toprak"));
        kartdestesi.add(new Meowth("Meowth","toprak"));
        kartdestesi.add(new Pikachu("Pikachu","Elektrik"));
        kartdestesi.add(new Psyduck("Psyduck","Su"));
        kartdestesi.add(new Snorlax("Snorlax","toprak"));
        kartdestesi.add(new Squirtle("Squirtle","Su"));
        kartdestesi.add(new Zubat("Zubat","Hava"));

try{

    arka=ImageIO.read(new File("a4.jpg"));



}catch(IOException ex){
}



devam.addActionListener(this);
addMouseListener(this);
    }

    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        g.drawImage(arka,0,0,this);
        oyuncuskor.setText(gamer.getOyuncuAdi()+" skor:"+gamer.SkorGoster());
        oyuncuskor.setBounds(670,190,200,100);
        add(oyuncuskor);

      bilgisayarskor.setText("bilgisayar skor:"+pc.SkorGoster());
        bilgisayarskor.setBounds(820,190,200,100);
        add(bilgisayarskor);

        goster.setBounds(660,260,300,200);
        add(goster);
        devam.setBounds(800,400,100,50);
        add(devam);


        if(sayi<3){
            destedencek.setBounds(100,250,200,50);
            destedencek.setForeground(Color.lightGray);
            add(destedencek);
        }

        if(sayi>=3)
            remove(destedencek);


        for(int i=1;i<=kartdestesi.size();i++)
g.drawImage(kartdestesi.get(i-1).getResimArka(),(i-1)*30,300,this);


if(sayi>0){

    for(int i=0;i<sayi;i++){

        if(gamer.kartListesi[i].isKartKullanildimi()==false) {
            g.drawImage(gamer.kartListesi[i].getResimÖn(), x_1[i],y_1[i], this);
        }
      //  g.drawImage(gamer.kartListesi[i].getResimÖn(), x_1[i],y_1[i], this);

        if(pc.kartListesi[i].isKartKullanildimi()==false)
       g.drawImage(pc.kartListesi[i].getResimÖn(),x_2[i],y_2[i],this);
    }

if(gamer.kartListesi[tutucu_1].isKartKullanildimi()==true&&gecicisam==1)
    g.drawImage(gamer.kartListesi[tutucu_1].getResimÖn(),x_1[tutucu_1],y_1[tutucu_1],this);
if(pc.kartListesi[tutucu_2].isKartKullanildimi()==true&&gecicisam==1)
    g.drawImage(pc.kartListesi[tutucu_2].getResimÖn(),x_2[tutucu_2],y_2[tutucu_2],this);

    if(gecicisam==0&&gamer.kartListesi[tutucu_1].isKartKullanildimi()==true) {
        g.drawImage(gamer.kartListesi[0].getResimArka(),1000,270,this);
        g.drawImage(gamer.kartListesi[0].getResimArka(),1200,270,this);
    }


}


if(sayac==5&&gecicisam==1){
remove(devam);
    if(gamer.SkorGoster()>pc.SkorGoster()){

        bitir.setBounds(800,400,100,50);
        add(bitir);
        sayac++;
        bitir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,gamer.getOyuncuAdi()+"  KAZANDI:"+gamer.SkorGoster());
                System.exit(0);
            }
        });

    }

   else if(gamer.SkorGoster()<pc.SkorGoster()){
        bitir.setBounds(800,400,100,50);
        add(bitir);
        sayac++;
        bitir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Bilgisayar  KAZANDI:"+pc.SkorGoster());
                System.exit(0);
            }
        });


    }
else{

        bitir.setBounds(800,400,100,50);
        add(bitir);
        sayac++;
        bitir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Berabere");
                System.exit(0);
            }
        });

    }

}


    }


    @Override
    public void mouseClicked(MouseEvent e) {
//30 artio son kart 400 konumunda bitio ilk  kart 130
       if(e.getX()<130+(kartdestesi.size()-1)*30&&e.getY()>300&&e.getY()<(300+kartdestesi.get(0).getResimArka().getHeight())&&sayi<3) {
           gamer.kartSec(sayi,kartdestesi,gamer.kartListesi);
           pc.kartSec(sayi,kartdestesi,pc.kartListesi);
           x_1[sayi]=(sayi)*200;
           x_2[sayi]=(sayi)*200;

           sayi++;
           repaint();

       }


       if(sayi>=3&&devam_sayaci==0){

           if(e.getX()<(x_1[kart_1]+gamer.kartListesi[kart_1].getResimÖn().getWidth())&&e.getY()<gamer.kartListesi[kart_1].getResimÖn().getHeight()&&a[kart_1]==0){
               gamer.kartListesi[kart_1].setKartKullanildimi();
               gecicisam=0;
               tutucu_1=kart_1;
               devam_sayaci=1;
               sayac++;

               while(sayi<6) {
                   Random random = new Random();
                   int i=random.nextInt(sayi);
                   if(pc.kartListesi[i].isKartKullanildimi()==false){
                       tutucu_2=i;

                       pc.kartListesi[i].setKartKullanildimi();
                       if(gamer.kartListesi[kart_1].hasarPuaniGoster()>pc.kartListesi[i].hasarPuaniGoster())
                           gamer.setSkor(gamer.SkorGoster());
                       else if(gamer.kartListesi[kart_1].hasarPuaniGoster()<pc.kartListesi[i].hasarPuaniGoster())
                           pc.setSkor(pc.SkorGoster());
                       a[kart_1]=1;
                       if(kartdestesi.size()!=0) {
                           pc.kartSec(sayi, kartdestesi, pc.kartListesi);
                           x_2[sayi] = x_2[tutucu_2];
                           gamer.kartSec(sayi, kartdestesi, gamer.kartListesi);
                           x_1[sayi] = x_1[tutucu_1];
                           kart_1=sayi;
                           sayi++;

                       }
                       y_2[i]=270;
                       x_2[i]=1200;
                       break;

                   }
               }
               x_1[tutucu_1]=1000;
               y_1[tutucu_1]=270;


               repaint();
           }


    if (e.getX() > 200 && e.getX() < (200 + gamer.kartListesi[kart_2].getResimÖn().getWidth()) && e.getY() < gamer.kartListesi[kart_2].getResimÖn().getHeight()&&a[kart_2]==0) {
        gamer.kartListesi[kart_2].setKartKullanildimi();
        gecicisam=0;
        sayac++;
      tutucu_1=kart_2;
        devam_sayaci = 1;

        while (sayi<6) {
            Random random = new Random();
            int i = random.nextInt(sayi);
            if (pc.kartListesi[i].isKartKullanildimi() == false) {
              tutucu_2=i;

                pc.kartListesi[i].setKartKullanildimi();
                if (gamer.kartListesi[kart_2].hasarPuaniGoster() > pc.kartListesi[i].hasarPuaniGoster())
                    gamer.setSkor(gamer.SkorGoster());
                else if (gamer.kartListesi[kart_2].hasarPuaniGoster() < pc.kartListesi[i].hasarPuaniGoster())
                    pc.setSkor(pc.SkorGoster());
                a[kart_2]=1;
                if(kartdestesi.size()!=0) {
                    pc.kartSec(sayi, kartdestesi, pc.kartListesi);
                    x_2[sayi] = x_2[tutucu_2];
                    gamer.kartSec(sayi, kartdestesi, gamer.kartListesi);
                    x_1[sayi] = x_1[tutucu_1];
                    kart_2=sayi;
                    sayi++;

                }
                y_2[i] = 270;
                x_2[i] = 1200;
                break;

            }
        }

        x_1[tutucu_1] = 1000;
        y_1[tutucu_1] = 270;
repaint();

    }


    if (e.getX() > 400 && e.getX() < (400 + gamer.kartListesi[kart_3].getResimÖn().getWidth()) && e.getY() < gamer.kartListesi[kart_3].getResimÖn().getHeight()&&a[kart_3]==0) {
               gamer.kartListesi[kart_3].setKartKullanildimi();
               gecicisam=0;
               tutucu_1=kart_3;
               devam_sayaci = 1;
               sayac++;
               while (sayi<6) {
                   Random random = new Random();
                   int i = random.nextInt(sayi);
                   if (pc.kartListesi[i].isKartKullanildimi() == false) {
                       tutucu_2=i;
                       pc.kartListesi[i].setKartKullanildimi();
                       if (gamer.kartListesi[kart_3].hasarPuaniGoster() > pc.kartListesi[i].hasarPuaniGoster())
                           gamer.setSkor(gamer.SkorGoster());
                       else if (gamer.kartListesi[kart_3].hasarPuaniGoster() < pc.kartListesi[i].hasarPuaniGoster())
                           pc.setSkor(pc.SkorGoster());
                       a[kart_3]=1;
                       if(kartdestesi.size()!=0) {
                           pc.kartSec(sayi, kartdestesi, pc.kartListesi);
                           x_2[sayi] = x_2[tutucu_2];
                           gamer.kartSec(sayi, kartdestesi, gamer.kartListesi);
                           x_1[sayi] = x_1[tutucu_1];
                           kart_3=sayi;
                           sayi++;

                       }
                       y_2[i] = 270;
                       x_2[i] = 1200;
                       break;


                   }
               }

               x_1[tutucu_1] = 1000;
               y_1[tutucu_1] = 270;
               repaint();

           }

       }

System.out.println(e.getX());
    System.out.println(e.getY());

repaint();
        }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==devam){

            if(devam_sayaci==1) {
                gecicisam = 1;
             //   ikincitur++;

            }
            devam_sayaci=0;


        }
repaint();
    }
}

class pc extends JPanel implements ActionListener {

    ArrayList<Pokemon>kartdestesi=new ArrayList<Pokemon>();
    Bilgisayar pc_1=new Bilgisayar();
    Bilgisayar pc_2=new Bilgisayar();
    int sayi=0;
    int[] x_1=new int[10];
    int[] x_2=new int[10];
BufferedImage arka;
    int[] y_1=new int[10];
    int[] y_2={600,600,600,600,600,600,600,600,600,600};
    JButton devam=new JButton("Devam ediyor");
    int sayac=0;
    int tutucu_1;
    int tutucu_2;
    int gecicisam=0;
    int devam_et=0;
    JLabel bilgisayarskor1=new JLabel();
    JLabel bilgisayarskor2=new JLabel();
    JButton bitir=new JButton("bitir");
    Timer zamanlama=new Timer(2000,this);

    public pc(){

        kartdestesi.add(new Bulbasaur("Bulbasaur","hava"));
        kartdestesi.add(new Butterfree("Butterfree","toprak"));
        kartdestesi.add(new Charmander("Charmander","Ateş"));
        kartdestesi.add(new Jigglypuff("Jigglypuff","toprak"));
        kartdestesi.add(new Meowth("Meowth","toprak"));
        kartdestesi.add(new Pikachu("Pikachu","Elektrik"));
        kartdestesi.add(new Psyduck("Psyduck","Su"));
        kartdestesi.add(new Snorlax("Snorlax","toprak"));
        kartdestesi.add(new Squirtle("Squirtle","Su"));
        kartdestesi.add(new Zubat("Zubat","Hava"));

        try{

            arka=ImageIO.read(new File("a4.jpg"));



        }catch(IOException ex){
        }


devam.addActionListener(this);
    zamanlama.start();
    }

    protected void paintComponent(Graphics g){
super.paintComponent(g);
       bilgisayarskor1.setText("bilgisayar_1 skor:"+pc_1.SkorGoster());
        bilgisayarskor1.setBounds(670,190,200,100);
        add(bilgisayarskor1);

        bilgisayarskor2.setText("bilgisayar_2 skor:"+pc_2.SkorGoster());
        bilgisayarskor2.setBounds(820,190,200,100);
        add(bilgisayarskor2);
            devam.setBounds(800, 400, 200, 50);
            //add(devam);
       // if(sayac==6)
           // remove(devam);
       g.drawImage(arka,0,0,this);
        for(int i=1;i<=kartdestesi.size();i++)
            g.drawImage(kartdestesi.get(i-1).getResimArka(),(i-1)*30,300,this);

        if(sayi>0){

            for(int i=0;i<sayi;i++){

                if(pc_1.kartListesi[i].isKartKullanildimi()==false) {
                    g.drawImage(pc_1.kartListesi[i].getResimÖn(), x_1[i],y_1[i], this);
                }
                //  g.drawImage(gamer.kartListesi[i].getResimÖn(), x_1[i],y_1[i], this);

               if(pc_2.kartListesi[i].isKartKullanildimi()==false)
                    g.drawImage(pc_2.kartListesi[i].getResimÖn(),x_2[i],y_2[i],this);
            }

            if(pc_1.kartListesi[tutucu_1].isKartKullanildimi()==true&&gecicisam==0)
                g.drawImage(pc_1.kartListesi[tutucu_1].getResimÖn(),x_1[tutucu_1],y_1[tutucu_1],this);
            if(pc_2.kartListesi[tutucu_2].isKartKullanildimi()==true&&gecicisam==0)
                g.drawImage(pc_2.kartListesi[tutucu_2].getResimÖn(),x_2[tutucu_2],y_2[tutucu_2],this);

            if(gecicisam==1) {
                g.drawImage(pc_1.kartListesi[0].getResimArka(),1000,270,this);
                g.drawImage(pc_2.kartListesi[0].getResimArka(),1200,270,this);
            }



        }

        if(sayac==6){

            if(pc_1.SkorGoster()>pc_2.SkorGoster()){
             bitir.setBounds(800,400,100,50);
                     add(bitir);
             bitir.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     JOptionPane.showMessageDialog(null,"Bilgisayar_1 Kazandı:"+pc_1.SkorGoster());
                     System.exit(0);
                 }
             });


            }

            else if(pc_2.SkorGoster()>pc_1.SkorGoster()){
                bitir.setBounds(800,400,100,50);
                add(bitir);
                bitir.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JOptionPane.showMessageDialog(null,"Bilgisayar_2 Kazandı:"+pc_2.SkorGoster());
                        System.exit(0);

                    }
                });

            }
            else{

                bitir.setBounds(800,400,100,50);
                add(bitir);
                bitir.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JOptionPane.showMessageDialog(null,"Berabere");
                        System.exit(0);


                    }
                });

            }

        }


}


    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==zamanlama){
            devam_et=0;

        }



        if(e.getSource()==zamanlama&&sayi==0){

            for(int i=0;i<=2;i++) {
                pc_1.kartSec(sayi, kartdestesi, pc_1.kartListesi);
                pc_2.kartSec(sayi, kartdestesi, pc_2.kartListesi);
                x_1[sayi]=(sayi)*200;
                x_2[sayi]=(sayi)*200;
                sayi++;
            }
           sayac++;
devam_et=1;

        }


        if(sayac>0&&sayac<6&&devam_et==0){

            while(sayi<6){

                Random random=new Random();
                int i=random.nextInt(sayi);
                if(pc_1.kartListesi[i].isKartKullanildimi()==false){

                    tutucu_1=i;
                    pc_1.kartListesi[i].setKartKullanildimi();
                    if(kartdestesi.size()!=0){

                        pc_1.kartSec(sayi,kartdestesi,pc_1.kartListesi);
                        x_1[sayi]=x_1[tutucu_1];

                    }
                    x_1[i]=1000;
                    y_1[i]=270;
                    break;

                }



            }

            while(sayi<6){
                Random random=new Random();
                int i=random.nextInt(sayi);
                if(pc_2.kartListesi[i].isKartKullanildimi()==false){

                    tutucu_2=i;
                    pc_2.kartListesi[i].setKartKullanildimi();
                    if(kartdestesi.size()!=0){

                        pc_2.kartSec(sayi,kartdestesi,pc_2.kartListesi);
                        x_2[sayi]=x_2[tutucu_2];
                        sayi++;


                    }

                    x_2[i]=1200;
                    y_2[i]=270;
                    break;
                }
            }

if(pc_1.kartListesi[tutucu_1].hasarPuaniGoster()>pc_2.kartListesi[tutucu_2].hasarPuaniGoster())
    pc_1.setSkor(pc_1.SkorGoster());
if(pc_1.kartListesi[tutucu_1].hasarPuaniGoster()<pc_2.kartListesi[tutucu_2].hasarPuaniGoster())
    pc_2.setSkor(pc_2.SkorGoster());

            sayac++;
            System.out.println(sayac);
        }


repaint();
    }
}