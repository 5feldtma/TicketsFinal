package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

public final class Geldbetrag implements Comparable<Geldbetrag>
{
    
    private final int _centBetrag;
    

    private Geldbetrag(int i)
    {
        _centBetrag = i;  
    }
    
    
    @Override
    public int compareTo(Geldbetrag g)
    {
        return 0;
    }

    @Override
    public boolean equals(Object o)
    {
        return true;
    }
    
    private boolean equals(Geldbetrag andererGeldbetrag)
    {
        return true;
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
        // TODO Auto-generated method stub
        return 0;
    }

    public int getCent()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    public static Geldbetrag select(String s)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    public static Geldbetrag select(int i)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public Geldbetrag add(Geldbetrag g2)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean istPositiv()
    {
        // TODO Auto-generated method stub
        return true;
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
