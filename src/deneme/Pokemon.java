package deneme;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Pokemon {


    BufferedImage resim;
     private String pokemonTip;
     private String pokemonAdi;
     private int pokemonID;
     boolean kartKullanildimi;

    public Pokemon(){

         pokemonTip="rastegele";
         pokemonAdi="rastgele";
         pokemonID=0;

     }



     public Pokemon(String pokemonAdi,String pokemonTip){

         this.pokemonAdi=pokemonAdi;
         this.pokemonTip=pokemonTip;

     }

     public String getPokemonTip() {

         return pokemonTip;
     }

     public void setPokemonTip(String pokemonTip) {

         this.pokemonTip = pokemonTip;
     }

     public int getPokemonID()
     {
         return pokemonID;
     }

     public void setPokemonID(int pokemonID)
     {

         this.pokemonID = pokemonID;
     }

     public String getPokemonAdi() {

         return pokemonAdi;
     }

     public void setPokemonAdi(String pokemonAdi) {
         this.pokemonAdi = pokemonAdi;
     }

     public int hasarPuaniGoster(){

         return 0;

     }

     public boolean isKartKullanildimi() {
         return kartKullanildimi;
     }

     public void setKartKullanildimi() {


     }
     public void setKartKullanildimiFalse(){


     }

    public BufferedImage getResimÖn(){

        try{

            resim= ImageIO.read(new File("kart1.png"));

        }catch(IOException ex){

        }

        return resim;

    }


    public BufferedImage getResimArka(){

        try{

            resim=ImageIO.read(new File("yok.png"));

        }catch(IOException ex){


        }

        return resim;

    }

 }
