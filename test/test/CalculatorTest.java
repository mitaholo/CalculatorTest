/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import calculator.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mikko Holopainen
 */
public class CalculatorTest {
    
    Calculator calc;
    
    public CalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        calc = new Calculator();
    }
    
    @After
    public void tearDown() {
        calc = null;
    }
    
    
    // long add(int a, int b) -metodin testit
    
    @Test
    public void addOnePlusOne() {
        assertEquals(2, calc.add(1,1));
    }
    
    @Test
    public void addOnePlusTwo() {
        assertEquals(3, calc.add(1,2));
    }
    
    @Test
    public void addZeroPlusZero() {
        assertEquals(0, calc.add(0,0));
    }
    
    @Test
    public void addOnePlusMinusTwo() {
        assertEquals(-1, calc.add(1,-2));
    }

    @Test
    public void addMinusSevenPlusMinusThirteen() {
        assertEquals(-20, calc.add(-7,-13));
    }
    
    @Test
    public void addMinusHundredPlusThousand() {
        assertEquals(900, calc.add(-100,1000));
    }
    
    @Test
    public void addZeroPlusMax() {
        assertEquals(2147483647, calc.add(0, Integer.MAX_VALUE));
    }
    
    @Test // Passasi vasta, kun tajusin muuttaa intit longeiksi ennen yhteenlaskua
    public void addMaxPlusOne() {
        assertEquals(2147483648l, calc.add(Integer.MAX_VALUE, 1));
    }

    @Test
    public void addMaxPlusMax() {
        assertEquals(4294967294l, calc.add(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
    
    @Test // Oletin tästä tulevan nolla, mutta MIN onkin itseisarvoltaan yhden suurempi kuin MAX
    public void addMaxPlusMin() {
        assertEquals(-1, calc.add(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
    
    
    // long subtract(int a, int b) -metodin testit
    
    @Test
    public void subtractTwoMinusOne() {
        assertEquals(1, calc.subtract(2,1));
    }
    
    @Test
    public void subtractOneMinusOne() {
        assertEquals(0, calc.subtract(1,1));
    }
    
    @Test
    public void subtractFiveMinusMinusSix() {
        assertEquals(11, calc.subtract(5,-6));
    }

    @Test
    public void subtractMinusTenMinusMinusEight() {
        assertEquals(-2, calc.subtract(-10,-8));
    }
    
    @Test
    public void subtractThousandMinusHundred() {
        assertEquals(900, calc.subtract(1000,100));
    }
    
    @Test
    public void subtractMinusOneMinusMax() {
        assertEquals(-2147483648l, calc.subtract(-1, Integer.MAX_VALUE));
    }
    
    @Test
    public void subtractMaxMinusMin() {
        assertEquals(4294967295l, calc.subtract(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
    
    @Test
    public void subtractMaxMinusMax() {
        assertEquals(0, calc.subtract(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
    
    
    // long multiply(int a, int b) -metodin testit
    
    @Test
    public void multiplyOneTimesTwo() {
        assertEquals(2, calc.multiply(1,2));
    }
    
    @Test
    public void multiplyTenTimesZero() {
        assertEquals(0, calc.multiply(10,0));
    }
    
    @Test
    public void multiplyFiveTimesMinusFour() {
        assertEquals(-20, calc.multiply(5,-4));
    }
    
    @Test
    public void multiplyMinusTenTimesMinusHundred() {
        assertEquals(1000, calc.multiply(-10,-100));
    }
    
    @Test
    public void multiplyMaxTimesOne() {
        assertEquals(2147483647, calc.multiply(Integer.MAX_VALUE, 1));
    }
    
    @Test
    public void multiplyZeroTimesMin() {
        assertEquals(0, calc.multiply(0, Integer.MIN_VALUE));
    }
    
    @Test
    public void multiplyMaxTimesTwo() {
        assertEquals(4294967294l, calc.multiply(Integer.MAX_VALUE, 2));
    }
    
    @Test
    public void multiplyMaxTimesMax() {
        assertEquals(4611686014132420609l, calc.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
    
    @Test
    public void multiplyMaxTimesMin() {
        assertEquals(-4611686016279904256l, calc.multiply(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
    
    
    // long divide(int a, int b) -metodin testit
    
    @Test
    public void divideOneOverOne() {
        assertEquals(1, calc.divide(1,1), 0);
    }
    
    @Test
    public void divideZeroOverTwo() {
        assertEquals(0, calc.divide(0,2), 0);
    }
    
    @Test
    public void divideThreeOverZero() {
        assertEquals(0, calc.divide(3,0), 0);
    }
    
    @Test
    public void divideZeroOverZero() {
        assertEquals(0, calc.divide(0,0), 0);
    }
    
    @Test
    public void divideOneOverTwo() {
        assertEquals(0.5, calc.divide(1,2), 0);
    }
    
    @Test
    public void divideFiftyOverMinusTwo() {
        assertEquals(-25, calc.divide(50,-2), 0);
    }
    
    @Test
    public void divideMinusFourtyTwoOverEighty() {
        assertEquals(-0.525, calc.divide(-42,80), 0);
    }
    
    @Test
    public void divideMinusSeventeenOverMinusFour() {
        assertEquals(4.25, calc.divide(-17,-4), 0);
    }
    
    @Test
    public void divideTenOverThree() {
        assertEquals(3.3333333333333333333333333333333d, calc.divide(10,3), 0);
    }
    
    @Test
    public void divideMaxOverMax() {
        assertEquals(1, calc.divide(Integer.MAX_VALUE, Integer.MAX_VALUE), 0);
    }
    
    @Test
    public void divideMinOverMax() {
        assertEquals(-1, calc.divide(Integer.MIN_VALUE, Integer.MAX_VALUE), 0.0000000005);
    }
    
    @Test
    public void divideOneOverMin() {
        assertEquals(-0.0000000005, calc.divide(1, Integer.MIN_VALUE), 0.00000000005);
    }
    
    
    // String doubleToString(double value) -metodin testit
    
    @Test
    public void doubleToStringInteger() {
        assertEquals("5", calc.doubleToString(5));
    }
    
    @Test
    public void doubleToStringNegativeInteger() {
        assertEquals("-7", calc.doubleToString(-7.000000));
    }
    
    @Test // Failasi aluksi, koska Java käytti String.formatissa desimaalipilkkua käyttöjärjestelmän asetuksien vuoksi
    public void doubleToStringExactDecimal1() {
        assertEquals("1.23000", calc.doubleToString(1.23));
    }
    
    @Test
    public void doubleToStringExactDecimal2() {
        assertEquals("98765.43210", calc.doubleToString(98765.43210));
    }
    
    @Test
    public void doubleToStringDecimal1() {
        assertEquals("1.11111", calc.doubleToString(1.111111111111111));
    }
    
    @Test // Pyöristyminen tasalukuun yllätti positiivisesti
    public void doubleToStringDecimal2() {
        assertEquals("10000", calc.doubleToString(9999.999999999999999));
    }
    
    @Test
    public void doubleToStringDecimal3() {
        assertEquals("12.34568", calc.doubleToString(12.34567890));
    }
    
    
    
    // String calculate(String calculation, int a, int b) -metodin testit
    
    @Test
    public void calculateZeroPlusZero() {
        assertEquals("0", calc.calculate("add", 0, 0));
    }
    
    @Test
    public void calculateOnePlusOne() {
        assertEquals("2", calc.calculate("add", 1, 1));
    }
    
    @Test
    public void calculateTenPlusMinusThousand() {
        assertEquals("-990", calc.calculate("add", 10, -1000));
    }
    
    @Test
    public void calculateMaxPlusZero() {
        assertEquals("2147483647", calc.calculate("add", Integer.MAX_VALUE, 0));
    }
    
    @Test
    public void calculateMaxPlusOne() {
        assertEquals("MA ERROR", calc.calculate("add", Integer.MAX_VALUE, 1));
    }
    
    @Test
    public void calculateMinPlusZero() {
        assertEquals("-2147483648", calc.calculate("add", Integer.MIN_VALUE, 0));
    }
    
    @Test
    public void calculateMinPlusMinusOne() {
        assertEquals("MA ERROR", calc.calculate("add", Integer.MIN_VALUE, -1));
    }
    
    @Test
    public void calculateMinPlusMin() {
        assertEquals("MA ERROR", calc.calculate("add", Integer.MIN_VALUE, Integer.MIN_VALUE));
    }
    
    @Test
    public void calculateOneMinusOne() {
        assertEquals("0", calc.calculate("subtract", 1, 1));
    }
    
    @Test
    public void calculateMinusTenMinusNine() {
        assertEquals("-19", calc.calculate("subtract", -10, 9));
    }
    
    @Test
    public void calculateZeroMinusMax() {
        assertEquals("-2147483648", calc.calculate("subtract", -1, Integer.MAX_VALUE));
    }
    
    @Test
    public void calculateMinMinusOne() {
        assertEquals("MA ERROR", calc.calculate("subtract", Integer.MIN_VALUE, 1));
    }
    
    @Test
    public void calculateZeroMinusMin() {
        assertEquals("MA ERROR", calc.calculate("subtract", 0, Integer.MIN_VALUE));
    }
    
    @Test
    public void calculateSixTimesOne() {
        assertEquals("6", calc.calculate("multiply", 6, 1));
    }
    
    @Test
    public void calculateThousandTimesZero() {
        assertEquals("0", calc.calculate("multiply", 1000, 0));
    }
    
    @Test
    public void calculateZeroTimesZero() {
        assertEquals("0", calc.calculate("multiply", 0, 0));
    }
    
    @Test
    public void calculateMinusFiveTimesTwentyFive() {
        assertEquals("-125", calc.calculate("multiply", -5, 25));
    }
    
    @Test
    public void calculateOneTimesMax() {
        assertEquals("2147483647", calc.calculate("multiply", 1, Integer.MAX_VALUE));
    }
    
    @Test
    public void calculateMinTimesOne() {
        assertEquals("-2147483648", calc.calculate("multiply", Integer.MIN_VALUE, 1));
    }
    
    @Test
    public void calculateTwoTimesMax() {
        assertEquals("MA ERROR", calc.calculate("multiply", 2, Integer.MAX_VALUE));
    }
    
    @Test
    public void calculateTwoTimesMin() {
        assertEquals("MA ERROR", calc.calculate("multiply", 2, Integer.MIN_VALUE));
    }
    
    @Test
    public void calculateMinusOneTimesMin() {
        assertEquals("MA ERROR", calc.calculate("multiply", -1, Integer.MIN_VALUE));
    }
    
    @Test
    public void calculateMaxTimesMin() {
        assertEquals("MA ERROR", calc.calculate("multiply", Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
    
    @Test
    public void calculateZeroOverOne() {
        assertEquals("0", calc.calculate("divide", 0, 1));
    }
    
    @Test
    public void calculateTwoOverOne() {
        assertEquals("2", calc.calculate("divide", 2, 1));
    }
    
    @Test
    public void calculateFourOverTwo() {
        assertEquals("2", calc.calculate("divide", 4, 2));
    }
    
    @Test
    public void calculateFiveOverTen() {
        assertEquals("0.50000", calc.calculate("divide",5, 10));
    }
    
    @Test
    public void calculateOneOverMinusThree() {
        assertEquals("-0.33333", calc.calculate("divide", 1, -3));
    }
    
    @Test
    public void calculateHundredOverSix() {
        assertEquals("16.66667", calc.calculate("divide", 100, 6));
    }
    
    @Test
    public void calculateMaxOverOne() {
        assertEquals("2147483647", calc.calculate("divide", Integer.MAX_VALUE, 1));
    }
    
    @Test
    public void calculateMinusMinOverOne() {
        assertEquals("-2147483648", calc.calculate("divide", Integer.MIN_VALUE, 1));
    }
    
    @Test
    public void calculateOneOverZero() {
        assertEquals("MA ERROR", calc.calculate("divide", 1, 0));
    }
    
    @Test
    public void calculateSynError1() {
        assertEquals("SYN ERROR", calc.calculate("addd", 0, 0));
    }
    
    @Test
    public void calculateSynError2() {
        assertEquals("SYN ERROR", calc.calculate("lol", 313, 666));
    }
}
