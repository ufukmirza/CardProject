package deneme;

import java.util.ArrayList;

abstract class Oyuncu {

private String oyuncuAdi;
private int Skor;


public Oyuncu(){


}

public Oyuncu(String oyuncuAdi,int Skor){

 this.oyuncuAdi=oyuncuAdi;
 this.Skor=Skor;

}

public int SkorGoster(){

//System.out.println("Skor:"+Skor);

    return Skor;

}
     public void setSkor(int skor) {

     }

abstract int kartSec(int i,ArrayList<Pokemon> kartdestesi,Pokemon[] kullanıcıdestesi);

  public String getOyuncuAdi() {
   return oyuncuAdi;
  }

  public void setOyuncuAdi(String oyuncuAdi) {
   this.oyuncuAdi = oyuncuAdi;
  }


 }
