import java.util.*;

import javax.swing.plaf.basic.BasicGraphicsUtils;

import java.math.*;

public class DeffieHellman {

    public static BigInteger giveNum(BigInteger p){
        return BigInteger.valueOf((long) Math.floor((Math.random()*(p.intValue() - 1)) + 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        BigInteger P = BigInteger.valueOf(p);
        boolean flag = false;

        for(int i = 2; i < p; i++){
            if(p % i == 0){
                flag = true;
                break;
            }
        }

        if(flag){
            System.out.println("Please enter a prime number");
        }else{

            flag = true;

            BigInteger a = giveNum(P);
            BigInteger b = giveNum(P);

            System.out.println("The private keys are :");
            System.out.print(""+a+" "+b);
            System.out.println();

            BigInteger primitiveroot = BigInteger.valueOf(scanner.nextInt());

            BigInteger publickeya = primitiveroot.modPow(a, P);
            BigInteger publickeyb = primitiveroot.modPow(b, P);
            System.out.println("The public keys are :");
            System.out.print(""+publickeya+" "+publickeyb);
            System.out.println();

            BigInteger secretkey1 = publickeyb.modPow(a, P);
            BigInteger secretkey2 = publickeya.modPow(b, P);

            if(secretkey1.equals(secretkey2)){
                System.out.println("The secret keys are same");
                System.out.println(secretkey1+" "+secretkey2);
            }else{
                System.out.println("Error");
            }
        }
    }
}
