package deneme;

import java.util.ArrayList;
import java.util.Random;

public class Bilgisayar extends Oyuncu {

    private String oyuncuAdi;
    private int Skor;
    Pokemon[] kartListesi=new Pokemon[10];


    public Bilgisayar(){


    }

    public Bilgisayar(String oyuncuAdi,int Skor){

        super(oyuncuAdi,Skor);

    }

    int kartSec(int i,ArrayList<Pokemon> kartdestesi, Pokemon[] kullanıcıdestesi){

        Random random=new Random();
        int sayi=random.nextInt(kartdestesi.size());
        kullanıcıdestesi[i]=kartdestesi.get(sayi);
        kartdestesi.remove(sayi);
        return 0;

    }

    public int SkorGoster(){

        return Skor;


    }

    public void setSkor(int skor) {
        Skor = skor+5;
    }


}
