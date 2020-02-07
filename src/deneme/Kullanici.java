package deneme;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class Kullanici extends Oyuncu {

    private String oyuncuAdi;
    private int Skor;
    Pokemon[] kartListesi=new Pokemon[10];


    public void setSkor(int skor) {
        Skor = skor+5;
    }

    public Kullanici(){


    }

    public Kullanici(String oyuncuAdi,int Skor){

        super(oyuncuAdi,Skor);

    }

     int kartSec(int i,ArrayList<Pokemon> kartdestesi,Pokemon[] kullanıcıdestesi){

        Random random=new Random();
        int sayi=random.nextInt(kartdestesi.size());
        kullanıcıdestesi[i]=kartdestesi.get(sayi);
        kartdestesi.remove(sayi);
        System.out.println(kartdestesi.size());



      return sayi;

    }

    public int SkorGoster(){

return Skor;


    }


}
