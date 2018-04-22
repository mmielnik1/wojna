/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wojna;

import static java.lang.Integer.*;
import java.util.*;

/**
 *
 * @author admin
 */
public class Main {

    public static ArrayList stworzTalie()
    {
        String [] figury={"2", "3", "4", "5", "6", "7", "8", "9", "10", "Walet", "Dama", "Król", "As"};
        ArrayList<Karta> talia=new ArrayList();
        for(String figura: figury)
            {
                talia.add(new Karta("trefl",figura));
                talia.add(new Karta("karo",figura));
                talia.add(new Karta("kier",figura));
                talia.add(new Karta("pik",figura));
            }
        Collections.shuffle(talia);
        return talia;
    }
    
    public static void rozdajKarty(ArrayList<Karta> talia, Gracz gracz1, Gracz gracz2)
    {
        int i=0;
        for(Karta k: talia)
        {
            if(i%2==0)gracz1.deck.add(k);
            else gracz2.deck.add(k);
            i++;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Karta> talia=stworzTalie();
        Scanner czytaj=new Scanner(System.in);
        System.out.print("Podaj imie 1. gracza: ");
        Gracz gracz1=new Gracz(czytaj.nextLine());
        System.out.print("Podaj imie 2. gracza: ");
        Gracz gracz2=new Gracz(czytaj.nextLine());
        rozdajKarty(talia,gracz1,gracz2);
        int wCiemno=1;
        System.out.print("Ile kart ma być grane w ciemno w czasie wojny? <1,10> ");
        String t=czytaj.nextLine();
        try
        {
            wCiemno=parseInt(t);
            if(wCiemno<1||wCiemno>10)
            {
                System.out.println("Podano złą liczbę, ustalam licze kart do zagrania w ciemno na 1");
                wCiemno=1;
            }
        }
        catch(java.lang.NumberFormatException a)
        {
            System.out.println("Nalezy podac liczbe, ustalam licze kart do zagrania w ciemno na 1");
            wCiemno=1;
        }
        boolean auto=false;
        System.out.print("Czy gra ma przebiec automatycznie? (t/n) ");
        if(czytaj.nextLine().equals("t")) auto=true;
        
        ArrayList<Karta> runda=new ArrayList();
        int i=1;
        System.out.println();
        
        while(gracz1.deck.size()>0 && gracz2.deck.size()>0)
        {
            System.out.println("RUNDA "+i);
            Karta k1=gracz1.deck.pop();
            System.out.println(gracz1.getImie()+" zagrał "+k1.pokazKarte());
            Karta k2=gracz2.deck.pop();
            System.out.println(gracz2.getImie()+" zagrał "+k2.pokazKarte());
            runda.add(k1);
            runda.add(k2);
            while(k1.getWartosc()==k2.getWartosc() && gracz1.deck.size()>wCiemno && gracz2.deck.size()>wCiemno)
            {
                System.out.println("Remis! Wojna!");
                for(int j=0;j<wCiemno;j++)
                {
                    runda.add(gracz1.deck.pop());
                    runda.add(gracz2.deck.pop());
                }
                k1=gracz1.deck.pop();
                k2=gracz2.deck.pop();
                runda.add(k1);
                runda.add(k2);
                System.out.println(gracz1.getImie()+" zagrał "+k1.pokazKarte());
                System.out.println(gracz2.getImie()+" zagrał "+k2.pokazKarte());
            }
            if((gracz1.deck.isEmpty() || gracz2.deck.isEmpty())&&(k1.getWartosc()==k2.getWartosc()))
            {
                if(gracz1.deck.isEmpty())
                {
                    System.out.println("Runde wygrał "+gracz2.getImie());
                    gracz2.deck.addAll(runda);
                }
                else
                {
                    System.out.println("Runde wygrał "+gracz1.getImie());
                    gracz1.deck.addAll(runda);
                }
            }
            else
            {
                if(k1.getWartosc()>k2.getWartosc())
                {
                    System.out.println("Runde wygrał "+gracz1.getImie());
                    gracz1.deck.addAll(runda);
                }
                else
                {
                    System.out.println("Runde wygrał "+gracz2.getImie());
                    gracz2.deck.addAll(runda);
                }
            }
            runda.clear();
            System.out.println("Graczowi "+gracz1.getImie()+" pozostalo "+gracz1.deck.size()+" kart");
            System.out.println("Graczowi "+gracz2.getImie()+" pozostalo "+gracz2.deck.size()+" kart\n");
            if(auto==false)
            {
                System.out.println("Aby przejść w tyb automatyczny napisz 'a'.");
                System.out.println("Wpisz dowolny inny znak, aby przejść do kolejnej rundy.");
                switch(czytaj.nextLine())
                {
                    case "a":
                        auto=true;
                        break;
                }
                System.out.println();
            }
            i++;
        }
        System.out.println();
        if(gracz1.deck.isEmpty()) System.out.println("Grę wygrał gracz "+gracz2.getImie());
        else System.out.println("Grę wygrał gracz "+gracz1.getImie());
        System.out.println("GRATULACJE!\n");
        czytaj.close();
    }
    
}
