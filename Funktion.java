import java.util.ArrayList;
import static java.lang.Math.pow;
/**
 * Klasse Funktion
 *
 * @author JKrier, JVogt
 * @version Ueb04
 */
public class Funktion
{   
    private static final String MSG_POSITIVE_GANZE_ZAHL = "Hier bitte eine positive ganze Zahl eingeben.";
    private static final String MSG_POSITIVE_NEUNSTELLIGE_ZAHL = "Hier bitte eine positive neunstellige Zahl eingeben.";
    private static final int ISBN_MAX = 999999999;
    private static final int ISBN_MIN = 0;
    private static final int LAENGE_ISBN = 9;
    /**
     * Standardkonstruktor der Klasse Funktionen
     */
    public Funktion()
    {  
    }
    
    /**
     * Ueb04: Vierte Funktion: Berechnen der Zahlentripel zu einer uebergebenen oberen Schranke max.
     * @param obere maximale Schranke max (>=0)
     * @return alle Zahlentrippel fuer die gilt: a*a*a+b*b*b=c*c mit a<=b und c<=max
     */
    public static String berechneZahlentripel(int max)
    {
        ArrayList<String> zahlentripel = new ArrayList<>();
        String tripel ="\nDie Zahlentripel zur oberen Schranke "+max+" sind: ";
        int a;
        int b;
        int c;
        
        for (a=1;a<max;a++)
        {
            for (b=a;b<max;b++)
            {
                for (c=1;c<max;c++)
                {
                    int summe =a*a*a + b*b*b;
                    if (c*c == summe)
                    {
                        zahlentripel.add ("("+a+","+b+","+c+")");
                    }
                }
            }
        }
        return tripel = tripel + "\n"+zahlentripel;
    }
    public static String berechneSumme(int n, double x) {
        
        
        int i;
        int ergebnis; 
        double teilA;
        double teilB;
        double teilC;
        double teilD;
        int summe;
        
        
        ergebnis = 0;
        teilA = 0;
        teilB = 0;
        teilC = 0;
        teilD = 0;
        summe = 0;
        
        for ( i = 1; i <= n; i++ ) {
        
        teilA = (x - 1);
        teilB = Math.pow(teilA, i);
        teilC = (i * x);
        teilD = Math.pow(teilC, i);
        summe += teilB / teilD;

        }
        return String.valueOf(summe);
    }
    

    /**
     * Erste Funktion: Berechnen der Teilersumme
     *
     * @param  natuerliche Zahl (>=0)
     * @return teilersumme
     */
    public static int berechneTeilersumme(int y)
    {
        check((y>=0),MSG_POSITIVE_GANZE_ZAHL);
        int i; 
        int teilersumme = 0;
        
        for(i =1;i*i<y;i++)
        {
            if (y % i == 0)
            {
                teilersumme+=i+y/i;
            } 
            
        }
        return teilersumme;
    }
    
    /**
     * Zweite Funktion: Pruefziffer fuer ISBN berechnen.
     *
     * @param  zu pruefende Zahl. in diesem Fall mit 9 Zeichen
     * @return isbn mit der pruefziffer
     */
    public static String berechnePruefziffer(long isbn)
    {
       String s = String.valueOf(isbn);
       
       check(((isbn > ISBN_MIN) && (isbn < ISBN_MAX) && (s.trim().length()==LAENGE_ISBN)),MSG_POSITIVE_NEUNSTELLIGE_ZAHL);
       
       long summe=0;
       for(int i=LAENGE_ISBN;i>ISBN_MIN;i--)
       {
           summe +=(isbn % 10) *i;
           isbn = isbn/10;
       }
         
       if (summe % 11 == 10)
         {
          return s+"-X";
         }
       else
         {
          return s+"-" + summe % 11;
         }
    }
    /**
     * Dritte Funktion: Nullstellen fue quadratische Gleichung berechnen mittels p-q Formel. 
     * Fallunterscheidung: D<0 = Komplexe Nullstelle, D>0: 2 Nullstellen oder D=0: Doppelte Nullstelle.
     * @param Variablen p und q. Beide sind vom Datentyp double
     */
    public static String berechneNullstellen (double p,double q)
    {
        double nullstelle1 = 0;
        double nullstelle2 = 0;
        double d;
        double a;
         a=(p/2.0);
         d=(a*a)-q;
         
         String ergebnis = new String();
         
         if (d > 0.0)
         {
             double berechnung = Math.sqrt(d);
             nullstelle1 = -a - berechnung;
             nullstelle2 = -a + berechnung;
                     
             ergebnis="Nullstellen sind: "+nullstelle1+" und "+nullstelle2;
         }
         else if (d ==0.0)
         {
             nullstelle1 = -a;
             
             ergebnis = "Doppelte Nullstelle bei: "+ nullstelle1;
         }
         else
         {
             ergebnis = "\nKomplexe Nullstelle!";
         }
         return ergebnis;
        }
    
    
    /**
     * Check-Methode um Fehler zu erkennen und als 
     * IllegalArgumentException auszuwerfen.
     */
    private static void check(boolean bedingung, String error)
    {
        if (!bedingung)
           throw new IllegalArgumentException(error);
    }
    
    
   
}
