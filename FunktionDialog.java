import java.util.*;
/**
 * Klasse FunktionDialog: Interative Testklasse der Klasse Funktion.
 *
 * @author JKrier, JVogt
 * @version Ueb04
 */
public class FunktionDialog
{
    
    private Scanner input;
    
    private final        String MSG_Positive_Ganze_Zahl = "\nHier eine positive ganze Zahl eingeben.";
    private final        String MSG_Rationale_Zahl ="\nHier eine rationale Zahl eingeben.";
    private final static int ENDE =0;
    private final static int TEILERSUMME =1;
    private final static int PRUEFZIFFER =2;
    private final static int NULLSTELLEN =3;
    private final static int ZAHLENTRIPEL_V1 =4;
    private final static int ZAHLENTRIPEL_V2 =5;
    private final static int SUMMENZEICHEN =6;
    
    /**
     * Konstruktor.
     */
    public FunktionDialog()
    {
        input = new Scanner( System.in );
    }
    /**
     * Methode run(): Interaktives Testprogramm. Beinhaltet 6 Auswahlmoeglichkeiten, sowie drei Exception catcher bei ungueltigen Eingaben bei den Methoden. 
     * Zur Auswahl stehen die fuenf zu testende Funktionen sowie der Moeglichkeit das Programm mit der Eingabe "0" zu beenden.
     */
    
    public void run()
     {
        int wahl=1;
                              
     
       while ( wahl != ENDE )
       {
          wahl = readlnInt("\n Bitte waehlen Sie aus: "+
                          "\n 1) Teilersummenergebnis berechnen = 1"+
                          "\n 2) ISBN Pruefziffer berechnen = 2"+
                          "\n 3) Nullstellen einer quadratischen Gleichung berechnen = 3"+
                          "\n 4) Zahlentripel zu einer oberen Schranke berechnen = 4"+
                          "\n 5) Berechnen einer Summe = 5" +
                          "\nEnde = 0\n");
                          
        try
        {
           
          System.out.println ("");
          switch (wahl)
          {
             case ENDE:
                 System.out.println("Ende");
                 break;
             case TEILERSUMME:
                 System.out.println("\nTeilersumme = "+Funktion.berechneTeilersumme(readZahl()));
                 break;
             case PRUEFZIFFER:
                 System.out.println("\n"+Funktion.berechnePruefziffer(readIsbn()));
                 break;
             case NULLSTELLEN:
                 System.out.println("\n"+Funktion.berechneNullstellen(readP(), readQ()));
                 break;
             case ZAHLENTRIPEL_V1:
                 System.out.println("\n"+Funktion.berechneZahlentripel(readMax()));
                 break;
             case SUMMENZEICHEN:
                 System.out.println("\n"+Funktion.berechneSumme(readZahl(), readKommazahl()));
                 break;
        

             default:
                 System.out.println("Bitte treffen Sie eine gueltige Wahl!");
                 break;
          }
        }
        catch (AssertionError ae)
        {
            System.err.println(ae);
        } 
        catch ( NumberFormatException nfe)
        {  
            System.err.println(nfe);                           
        }       
        catch ( RuntimeException rex)
        {  
            System.err.println(rex);
        } 
       }                   
     }
    
     /**
     * Methode readMax() dient zum Einlesen des Parameters fuer die Berechnung der Teilersumme.
     * @return Parameterwert fuer Methode berechneTeilersumme(zahl()).
     */
     public int readMax()
     {
         int max;
         max = readlnInt("Obere Schranke eingeben: ");
         return max;
     }
     
     /**
     * Methode zahl() dient zum Einlesen des Parameters fuer die Berechnung der Teilersumme und die Summenberechnung.
     * @return positiver ganzzahliger Parameterwert.
     */
     public int readZahl()
     {
         int zahl;
         zahl = readlnInt("Natuerliche Zahl eingeben: ");
         return zahl;
     }
     
    /**
     * Methode readKommazahl() dient zum Einlesen der Kommazahl fuer die Summenberechnung.
     * @return Parameterwert fuer Summenfunktion  .
     */
     public double readKommazahl()
     {
         double zahl;
         zahl = readlnDouble("X-Wert eingeben: ");
         return zahl;
     }
    
     /**
     * Methode isbn() dient zum Einlesen der zu pruefenden ISBN neunstelligen Zahl
     * @return Parameterwert fuer Methode berechnePruefziffer(isbn()).
     */
     public long readIsbn()
     {
         long isbn;
         isbn = readlnLong("Zu pruefende (neunstellige) ISBN  eingeben: ");
         
         return isbn;
     }
              
     /**
     * Methode p() dient zum Einlesen Variable p fuer die p-q-Formel
     * @return Parameterwert fuer Methode gleichung().
     */
     public double readP()
     {
         double p;
         p = readlnDouble("Zahl p eingeben: ");
         return p;
     }
     
     /**
     * Methode q() dient zum Einlesen Variable q fuer die p-q-Formel
     * @return Parameterwert fuer Methode gleichung().
     */
     public double readQ()
     {
         double q;
         q = readlnDouble("Zahl q eingeben: ");
         return q;
     }
     
     /**
     * Methode readlnInt() dient zum Einlesen von int Werten.
     * @param String eingabe
     * @return eingelesener int wert
     */
      private int readlnInt(String eingabe)
      {
        int wert = 0;
        try 
        {
            System.out.print(eingabe);
            wert= input.nextInt();
            input.nextLine();
            
        }
        
        catch (InputMismatchException e) 
        {
            System.err.println(e+ MSG_Positive_Ganze_Zahl);
        } 
        return wert;
     }
     
     /**
     * Methode readlnLong() dient zum Einlesen von long Werten.
     * @param String eingabe
     * @return eingelesener long wert
     */
     public long readlnLong(String eingabe)
     {
        long wert = 0;
        try 
        {
            System.out.print(eingabe);
            wert= input.nextLong();
            input.nextLine();
            
        }
        
        catch (InputMismatchException e) 
        {
            System.err.println(e+ MSG_Positive_Ganze_Zahl);
        } 
        return wert;
     }
     
     /**
     * Methode readlnDouble() dient zum Einlesen von double Werten.
     * @param String eingabe
     * @return eingelesener double wert
     */
     public double readlnDouble(String eingabe)
     {
        double wert = 0;
        try 
        {
            System.out.print(eingabe);
            wert= input.nextDouble();
            input.nextLine();
            
        }
        
        catch (InputMismatchException e) 
        {
            System.err.println(e+ MSG_Rationale_Zahl);
        } 
        return wert;
     }
     
     
     /**
     * Die Main Methode dient zum starten des interaktiven Dialogs, der zum Testen der Methoden der Klasse Funktionen dient.
     * @param args Kommandozeilenparameter
     */
     public static void main (String[]args)
     {
         FunktionDialog dialog = new FunktionDialog();
         dialog.run();
    }
}
