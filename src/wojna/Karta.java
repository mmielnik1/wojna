/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wojna;

import static java.lang.Integer.*;

/**
 *
 * @author admin
 */
public class Karta {
    private String kolor;
    private String figura;
    private int wartosc;
    Karta(String kolor, String figura)
    {
        this.kolor=kolor;
        this.figura=figura;
        switch (figura) {
            case "Walet":
                wartosc=11;
                break;
            case "Dama":
                wartosc=12;
                break;
            case "Król":
                wartosc=13;
                break;
            case "As":
                wartosc=14;
                break;
            default:
                wartosc=parseInt(figura);
                break;
        }
    }

    public void setFigura(String figura)
    {
        this.figura = figura;
        switch (figura) {
            case "Walet":
                wartosc=11;
                break;
            case "Dama":
                wartosc=12;
                break;
            case "Król":
                wartosc=13;
                break;
            case "As":
                wartosc=14;
                break;
            default:
                wartosc=parseInt(figura);
                break;
        }
    }

    public void setKolor(String kolor) 
    {
        this.kolor = kolor;
    }

    public String getFigura() 
    {
        return figura;
    }

    public String getKolor() 
    {
        return kolor;
    }

    public int getWartosc() 
    {
        return wartosc;
    }
    
    public String pokazKarte()
    {
        return figura+" "+kolor;
    }
    
}
