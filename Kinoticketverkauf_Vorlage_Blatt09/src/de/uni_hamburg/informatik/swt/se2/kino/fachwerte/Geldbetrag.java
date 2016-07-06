package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Geldbetrag implements Comparable<Geldbetrag>
{
    
    private final int _centBetrag;
    
    private final static Pattern _pattern = Pattern.compile("(\\d{1,}),?(\\d{1,2})");
    

    private Geldbetrag(int betrag)
    {
        _centBetrag = betrag;  
    }

    public static Geldbetrag select(String s)
    {
        Matcher matcher = _pattern.matcher(s);
        int betrag = 0;
        matcher.matches();
        if (matcher.group(2) != null)
        {
            betrag = Integer.parseInt(matcher.group(2));
        }
        betrag += Integer.parseInt(matcher.group(1))*Math.pow(10, matcher.group(2).length());
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

    public int getEuro()
    {
        return _centBetrag/100;
    }

    public int getCent()
    {
        return _centBetrag%100;
    }

    public Geldbetrag add(Geldbetrag g2)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean istPositiv()
    {
        return false;
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