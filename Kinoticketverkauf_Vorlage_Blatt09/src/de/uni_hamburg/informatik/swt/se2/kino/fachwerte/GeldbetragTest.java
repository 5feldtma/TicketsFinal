package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.*;


import org.junit.Test;

public class GeldbetragTest
{
    @Test
    public void testeKonstruktoren()
    {
        Geldbetrag g1 = Geldbetrag.select("1513");
        assertEquals(15, g1.getEuro());
        assertEquals(13, g1.getCent());
        assertTrue(g1.istPositiv());
        
        Geldbetrag g2 = Geldbetrag.select(-1642);
        assertEquals(16, g2.getEuro());
        assertEquals(42, g2.getCent());
        assertFalse(g2.istPositiv());
        
        Geldbetrag g3 = Geldbetrag.select("276,3");
        assertEquals(151, g3.getEuro());
        assertEquals(3, g3.getCent());
        assertTrue(g3.istPositiv());
        
        Geldbetrag g4 = Geldbetrag.select("6,19");
        assertEquals(151, g4.getEuro());
        assertEquals(3, g4.getCent());
        assertTrue(g4.istPositiv());
    }

    @Test
    public void testeEquals()
    {
        Geldbetrag g1 = Geldbetrag.select(1077);
        Geldbetrag g2 = Geldbetrag.select("10,77");
        Geldbetrag g3 = Geldbetrag.select(-1077);
        Geldbetrag g4 = Geldbetrag.select("0,22");
        Geldbetrag g5 = Geldbetrag.select("0,22");

        assertEquals(g1, g2);
        assertEquals(g4, g5);
        assertFalse(g1.equals(g3));
        assertFalse(g1.equals(g4));
    }

    @Test
    public void testeHashCode()
    {
        Geldbetrag g1 = Geldbetrag.select(100);
        Geldbetrag g2 = Geldbetrag.select(100);

        assertEquals("HashCode bleibt bei zwei Aufrufen gleich", g1.hashCode(),
                g1.hashCode());
        assertEquals("HashCodes mit gleichem Geldbetrag sind gleich",
                g1.hashCode(), g2.hashCode());
    }
    
    @Test
    public void testeAddition()
    {
        Geldbetrag g1 = Geldbetrag.select(100);
        Geldbetrag g2 = Geldbetrag.select("100");
        Geldbetrag g3 = Geldbetrag.select(-200);
        
        assertEquals(Geldbetrag.select(200), g1.add(g2));
        assertEquals(Geldbetrag.select(-100), g1.add(g3));
    }
    
    @Test
    public void testeSubtraktion()
    {
        Geldbetrag g1 = Geldbetrag.select(100);
        Geldbetrag g2 = Geldbetrag.select("100");
        Geldbetrag g3 = Geldbetrag.select(-200);
        
        assertEquals(Geldbetrag.select(0), g1.subtract(g2));
        assertEquals(Geldbetrag.select(300), g1.subtract(g3));
    }
    
    @Test
    public void testeMultiplikation()
    {
        Geldbetrag g1 = Geldbetrag.select(100);
        Geldbetrag g2 = Geldbetrag.select(-200);
        
        assertEquals(Geldbetrag.select(500), g1.multiply(5));
        assertEquals(Geldbetrag.select(-600), g2.multiply(3));
    }
    
    @Test
    public void testeToString()
    {
        Geldbetrag g1 = Geldbetrag.select(1077);
        Geldbetrag g2 = Geldbetrag.select("10,77");
        Geldbetrag g3 = Geldbetrag.select(-1077);
        
        assertEquals("10,77", g1.toString());
        assertEquals("10,77", g2.toString());
        assertEquals("10,77", g3.toString());
    }
    
    @Test
    public void testeCompareTo()
    {
        Geldbetrag g1 = Geldbetrag.select(1337);
        Geldbetrag g2 = Geldbetrag.select("13,37");
        Geldbetrag g3 = Geldbetrag.select(80085);
        Geldbetrag g4 = Geldbetrag.select("42");
        
        assertTrue(0 == g1.compareTo(g2));
        assertTrue(0 > g1.compareTo(g3));
        assertTrue(0 < g1.compareTo(g4));
        
    }
}
