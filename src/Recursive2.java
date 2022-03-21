import java.util.Date;
import java.util.Scanner;

public class Recursive2 {

    public static void main (String []args){
        Scanner in = new Scanner(System.in);
        System.out.println("Skriv inn et grunntallet:");
        double basis = in.nextDouble();
        System.out.println("Skriv inn et eksponent:");
        int exponent = in.nextInt();

        //Method 1 (without MathPow)
        Date start = new Date();
        int rounds = 0;
        double time;
        Date end;
        do {
            result(basis, exponent);
            end = new Date();
            rounds++;
        }while ((end.getTime()-start.getTime())<50000);
        time = (double)
                (end.getTime()-start.getTime()) / rounds;
        System.out.println("\n"+basis+" opphøyd i "+exponent+ " er "+result(basis, exponent));
        System.out.println("Millisekund pr. runde UTEN bruk av Math.pow():" + time+"\n");

        //Method 2 (with MathPow)
        Date start1 = new Date();
        int rounds1 = 0;
        double time1;
        Date end1;
        do {
            resultMathPow(basis, exponent);
            end1 = new Date();
            rounds1++;
        }while ((end1.getTime()-start1.getTime())<50000);
        time1 = (double)
                (end1.getTime()-start1.getTime()) / rounds1;
        System.out.println(basis+" opphøyd i "+exponent+ " er "+resultMathPow(basis,exponent));
        System.out.println("Millisekund pr. runde MED bruk av Math.pow():" + time1);

    }

    /**
     * Calculating x^n, but the calculation of the power depends on if
     * the entered base is an even or an odd number
     * @param x base of the power
     * @param n exponent of the power
     * @return if the entered exponent is 0, the return value would be 0
     *         for other values of n, the return value would be the calculation of the power
     */
    public static double result(double x, int n){
        if (n==0) return 1;
        else if (n%2!=0) return x*result(x*x,(n-1)/2);
        return result(x*x,n/2);
    }

    /**
     * Calculating x^n, but the calculation of the power depends on if
     * the entered base is an even or an odd number. This method is a little different from the method
     * above, since here I use Math.pow() to calculate power.
     * @param x base of the power
     * @param n exponent of the power
     * @return if the entered exponent is 0, the return value would be 0
     *         for other values of n, the return value would be the calculation of the power
     */
    public static double resultMathPow(double x, int n){
        double m = Math.pow(x,2);
        if (n==0) return 1;
        else if (n%2!=0) return x*result(m,(n-1)/2);
        return result(m,n/2);
    }
}
