package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Geldbetrag implements Comparable<Geldbetrag>
{
    
    private final int _centBetrag;
    
    private final static Pattern _pattern = Pattern.compile("(\\d{0,})(,?)(\\d{1,2})");
    

    private Geldbetrag(int betrag)
    {
        _centBetrag = betrag;  
    }

    public static Geldbetrag select(String s)
    {
        Matcher matcher = _pattern.matcher(s);
        int betrag = 0;
        matcher.matches();
        if(matcher.group(2).equals(""))
        {
            betrag = Integer.parseInt(matcher.group(0));
            System.out.println("a: " + betrag);
        }
        else
        {
            betrag = (int) (Integer.parseInt(matcher.group(3))*(100/Math.pow(10, matcher.group(3).length())));
            System.out.println("b: " + betrag);
            betrag += Integer.parseInt(matcher.group(1))*100;
            System.out.println("c: " + betrag);
        }
        return new Geldbetrag(betrag);
    }
    
    public static Geldbetrag select(int betrag)
    {
        return new Geldbetrag(betrag);
    }
    
    
    @Override
    public int compareTo(Geldbetrag that)
    {
        return this._centBetrag-that._centBetrag;
    }

    @Override
    public boolean equals(Object o)
    {
        return false;
    }
    
    private boolean equals(Geldbetrag that)
    {
        return false;
    }

    @Override
    public int hashCode()
    {
        return 0;
    }

    @Override
    public String toString()
    {
        return "";
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

    public Geldbetrag add(Geldbetrag g2)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean istPositiv()
    {
        //TODO was ist mit 0? Ist der Betrag dann positiv, oder nicht? Evtl. zu istNegativ() umwandeln.
        return _centBetrag>=0;
    }

    public Geldbetrag subtract(Geldbetrag g2)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public Geldbetrag multiply(int i)
    {
        // TODO Auto-generated method stub
        return null;
    }
}