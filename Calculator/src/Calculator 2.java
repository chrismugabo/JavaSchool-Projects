
public class Calculator {
	public static int add(int a, int b) {
		return a + b;
		}
	public static int subtract(int a, int b) {
		return a - b;
		}
	public static int multiply(int a, int b) {
		return a * b;
		}
	public static  double divide(double a, int b) {
		return (double)(a/b);
		}
	public static int remainder(int a, int b) {
		return a%b;
	}
	public static  int modulo(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot calculate modulo with zero");
        }
        return Math.floorMod(a, b);
	}
	public static  double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static double exponent(double a) {
        return Math.exp(a);
    }
    
}
