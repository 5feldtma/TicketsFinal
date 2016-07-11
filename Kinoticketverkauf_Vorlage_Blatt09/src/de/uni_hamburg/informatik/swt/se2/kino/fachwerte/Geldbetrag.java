package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Geldbetrag implements Comparable<Geldbetrag>
{

    private final long _centBetrag;

    private final static Pattern _pattern = Pattern
        .compile("(-?)(\\d*)([,.]?)(\\d{1,2})€?");

    private Geldbetrag(long betrag)
    {
        _centBetrag = betrag;
    }

    /**
     * 
     * @param eingabe Die Eingabe
     * @throws IllegalStateException Bei falschem Eingabeformat
     * @return Geldbetrag aus der Eingabe
     */
    public static Geldbetrag select(String eingabe) throws IllegalStateException
    {
        if (eingabe.length() > 12)
        {
            throw new IllegalStateException();
        }

        Matcher matcher = _pattern.matcher(eingabe);
        long betrag = 0;
        matcher.matches();

        if (matcher.group(3)
            .matches("[,.]"))
        {
            if(!matcher.group(4)
                    .isEmpty())
            {
                betrag = (long) (Long.parseLong(matcher.group(4))
                        * (100 / Math.pow(10, matcher.group(4)
                                .length())));//Magic¸¸.•*¨*•♫♪¸¸.•*¨*•♫♪¸¸.•*¨*•♫♪¸¸.•*¨*•♫♪¸¸.•*¨*•♫♪¸¸.•*¨*•♫♪¸¸.•*¨*•♫♪
            }
            betrag += Long.parseLong(matcher.group(2)) * 100;
        }
        else
        {
            
            betrag = Long.parseLong(matcher.group()) * 100;
        }
        
        if(!matcher.group(1).isEmpty())
        {
            betrag *= -1;
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

    public static Geldbetrag select(long betrag)
    {
        return new Geldbetrag(betrag);
    }

    @Override
    public int compareTo(Geldbetrag that)
    {
        int result;
        
        if (this._centBetrag - that._centBetrag < 0)
        {
            result = -1;
        }
        else if (this._centBetrag - that._centBetrag > 0)
        {
            result = 1;
        }
        else
        {
            result = 0;
        }
        
        return result;
        
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Geldbetrag)
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
        return (int) (_centBetrag % Integer.MAX_VALUE);
    }

    /**
     * Gibt den absoluten Betrag zurück.
     */
    public String absToString()
    {
        return getEuro() + "," + getCent();
    }

    @Override
    public String toString()
    {
        if (this.istPositiv())
        {
            return absToString();
        }
        else
        {
            return "-" + getEuro() + "," + getCent();
        }
    }

    /**
     * Gibt den Euroanteil des Geldbetrages aus.
     */
    public long getEuro()
    {
        return Math.abs(_centBetrag / 100);
    }

    /**
     * Gibt den Centanteil des Geldbetrages aus.
     */
    public long getCent()
    {
        return Math.abs(_centBetrag % 100);
    }

    /**
     * Gibt den kompletten Betrag des Geldbetrages in Cent aus.
     */
    public long getBetrag()
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
        long betrag = this._centBetrag + that._centBetrag;
        return new Geldbetrag(betrag);
    }

    /**
     * Gibt einen Geldbetrag zurück, dessen Betrag gleich der Differenz des Parameters und des Geldbetrages, an dem die Methode aufgerufen wurde, ist.
     * 
     * @param that Der zu subtrahierende Geldbetrag.
     */
    public Geldbetrag subtract(Geldbetrag that)
    {
        long betrag = this._centBetrag - that._centBetrag;
        return new Geldbetrag(betrag);
    }

    /**
     * Gibt einen Geldbetrag zurück, dessen Betrag gleich dem Produkt des Parameters und des Geldbetrages, an dem die Methode aufgerufen wurde, ist.
     * 
     * @param skalar Der Wert, mit dem der Geldbetrag multipliziert werden soll.
     */
    public Geldbetrag multiply(int skalar)
    {
        long betrag = this._centBetrag * skalar;
        return new Geldbetrag(betrag);
    }

    public boolean istPositiv()
    {
        //TODO was ist mit 0? Ist der Betrag dann positiv, oder nicht? Evtl. zu istNegativ() umwandeln.
        return _centBetrag >= 0;
    }
}