/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wojna;

import java.util.*;

/**
 *
 * @author admin
 */
public class Gracz {
    public LinkedList<Karta> deck;
    private String imie;

    public Gracz(String imie)
    {
        this.imie=imie;
        deck=new LinkedList();
    }

    public String getImie() 
    {
        return imie;
    }

    public void setImie(String imie)
    {
        this.imie = imie;
    }
    
}
