package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Geldbetrag implements Comparable<Geldbetrag>
{
    
    private final int _centBetrag;
    
    private final static Pattern _pattern = Pattern.compile("(\\d{0,})(,?)(\\d{0,2})");
    

    private Geldbetrag(int betrag)
    {
        _centBetrag = betrag;  
    }

    public static Geldbetrag select(String s)
    {
        Matcher matcher = _pattern.matcher(s);
        int betrag = 0;
        matcher.matches();
        
        
        if(matcher.group(2).equals(","))
        {
            betrag = (int) (Integer.parseInt(matcher.group(3))*(100/Math.pow(10, matcher.group(3).length())));
            System.out.println("b: " + betrag);
            betrag += Integer.parseInt(matcher.group(1))*100;
            System.out.println("c: " + betrag);
        }
        else
        {
            betrag = Integer.parseInt(matcher.group(0));
            System.out.println("a: " + betrag);
        }
        
        /*
        if(matcher.group(2).equals(","))
        {
            betrag = (int) (Integer.parseInt(matcher.group(3))*(100/Math.pow(10, matcher.group(3).length())));
            System.out.println("b: " + betrag);
        }
            
        betrag += Integer.parseInt(matcher.group(1))*100;
        System.out.println("c: " + betrag);
        */
        
        return new Geldbetrag(betrag);
    }
    
    public static Geldbetrag select(int betrag)
    {
        return new Geldbetrag(betrag);
    }
    
    @Override
    public int compareTo(Geldbetrag that)
    {
        return this._centBetrag - that._centBetrag;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Geldbetrag)
        {
            Geldbetrag that = (Geldbetrag) obj;
            return equals(that);
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Zwei Geldbeträge, die den selben Centbetrag enthalten, werden als gleich angesehen.
     */
    private boolean equals(Geldbetrag that)
    {
        return this._centBetrag == that._centBetrag;
    }

    @Override
    public int hashCode()
    {
        return _centBetrag;
    }

    @Override
    public String toString()
    {
        return getEuro() + "," + getCent();
    }
    
    /**
     * Gibt den absoluten Betrag zurück.
     */
    public String absToString()
    {
        if(this.istPositiv())
        {
            return toString();
        }
        else
        {
            return -1 * getEuro() + "," + getCent();
        }
    }

    /**
     * Gibt den Euroanteil des Geldbetrages aus.
     */
    public int getEuro()
    {
        return _centBetrag/100;
    }

    /**
     * Gibt den Centanteil des Geldbetrages aus.
     */
    public int getCent()
    {
        return Math.abs(_centBetrag%100);
    }
    
    /**
     * Gibt den kompletten Betrag des Geldbetrages in Cent aus.
     */
    public int getBetrag()
    {
        return _centBetrag;
    }

    /**
     * Gibt einen Geldbetrag zurück, dessen Betrag gleich der Summe des Parameters und des Geldbetrages, an dem die Methode aufgerufen wurde, ist.
     * 
     * @param that Der zu addierende Geldbetrag.
     */
    public Geldbetrag add(Geldbetrag that)
    {
        int betrag = this._centBetrag + that._centBetrag;
        return new Geldbetrag(betrag);
    }

    /**
     * Gibt einen Geldbetrag zurück, dessen Betrag gleich der Differenz des Parameters und des Geldbetrages, an dem die Methode aufgerufen wurde, ist.
     * 
     * @param that Der zu subtrahierende Geldbetrag.
     */
    public Geldbetrag subtract(Geldbetrag that)
    {
        int betrag = this._centBetrag - that._centBetrag;
        return new Geldbetrag(betrag);
    }

    /**
     * Gibt einen Geldbetrag zurück, dessen Betrag gleich dem Produkt des Parameters und des Geldbetrages, an dem die Methode aufgerufen wurde, ist.
     * 
     * @param skalar Der Wert, mit dem der Geldbetrag multipliziert werden soll.
     */
    public Geldbetrag multiply(int skalar)
    {
        int betrag = this._centBetrag * skalar;
        return new Geldbetrag(betrag);
    }

    public boolean istPositiv()
    {
        //TODO was ist mit 0? Ist der Betrag dann positiv, oder nicht? Evtl. zu istNegativ() umwandeln.
        return _centBetrag >= 0;
    }
}