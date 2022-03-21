import java.util.Date;
import java.util.Scanner;

public class Recursive {

    public static void main (String []args){
        Scanner in = new Scanner(System.in);
        System.out.println("Skriv inn et grunntallet:");
        double basis = in.nextDouble();
        System.out.println("Skriv inn et eksponent:");
        int exponent = in.nextInt();
        //System.out.println(result(basis, exponent));
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
        System.out.println(basis+" opphøyd i "+exponent+ " er "+result(basis,exponent));
        System.out.println("Millisekund pr. runde MED bruk av Math.pow():" + time);
    }

    /**
     * Calculating x^n
     * @param x base of the power
     * @param n exponent of the power
     * @return if the entered exponent is 0, the return value would be 0
     *         for other values of n, the return value would be the calculation of the power
     */
    public static double result(double x, int n){
        if (n==0) return 1;
         else return x*(result(x,n-1));
    }
}
