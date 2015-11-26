package calculator;
import java.util.Locale;

/**
 *
 * @author Mikko Holopainen
 */
public class Calculator {
    
    public Calculator() {
        
    }
    
    public long add(int a, int b) {
        return (long) a + (long) b;
    }

    public long subtract(int a, int b) {
        return (long) a - (long) b;
    }

    public long multiply(int a, int b) {
        return (long) a * (long) b;
    }

    public double divide(int a, int b) {
        if(b == 0) return 0;
        return (double) a / (double) b;
    }
    
    public String doubleToString(double value) {
        if(value % 1 == 0) return String.format(Locale.ENGLISH, "%.0f", value);
        else return String.format(Locale.ENGLISH, "%.5f", value);
    }
    
    public String calculate(String calculation, int a, int b) {
        switch(calculation) {
            case "add":
                long addValue = add(a, b);
                if(addValue < Integer.MIN_VALUE || addValue > Integer.MAX_VALUE) return "MA ERROR";
                else return Long.toString(addValue);
            case "subtract":
                long subtractValue = subtract(a, b);
                if(subtractValue < Integer.MIN_VALUE || subtractValue > Integer.MAX_VALUE) return "MA ERROR";
                else return Long.toString(subtractValue);
            case "multiply":
                long multiplyValue = multiply(a, b);
                if(multiplyValue < Integer.MIN_VALUE || multiplyValue > Integer.MAX_VALUE) return "MA ERROR";
                else return Long.toString(multiplyValue);
            case "divide":
                if(b == 0) return "MA ERROR";
                double divideValue = divide(a, b);
                if(divideValue < Integer.MIN_VALUE || divideValue > Integer.MAX_VALUE) return "MA ERROR";
                else return doubleToString(divideValue);
            default:
                return "SYN ERROR";
        }
    }
    
    
    public static void main(String[] args) {
    }
}
