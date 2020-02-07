
package deneme;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bulbasaur extends Pokemon {


       boolean KartKullanildimi;
        private String tip;
        private String isim;
        private int hasarPuani=50;
        private BufferedImage resim;


    public Bulbasaur(){

super();

    }

    public Bulbasaur (String isim,String tip) {

            super(isim,tip);


        }

    public int hasarPuaniGoster(){

      return hasarPuani;

    }

    public boolean isKartKullanildimi() {
        return KartKullanildimi;
    }

    public void setKartKullanildimi() {
        KartKullanildimi = true;
    }

    public void setKartKullanildimiFalse(){

        KartKullanildimi = false;
    }

    public BufferedImage getResimÖn(){

       try{

           resim= ImageIO.read(new File("kart11.jpg"));

       }catch(IOException ex){

       }

return resim;

    }


    public BufferedImage getResimArka(){

        try{

            resim=ImageIO.read(new File("yok4.png"));

        }catch(IOException ex){


        }

        return resim;

    }

}
