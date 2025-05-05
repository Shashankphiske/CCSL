import java.math.BigInteger;
import java.util.*;
import java.util.function.BiFunction;

public class RSA {

    public static int[] calculate(int num,int num1,int num2){
        for(int j = 2; j <= num1; j++){
            if(num1%j == 0 && num2%j == 0){
                num = 1;
                break;
            }
        }
        int[] arr = { num, num1 };

        return arr;
    }

    public static boolean checkVal(int num){

        if(num == 2){
            return true;
        }
        else if(num <= 1){
            return false;
        }
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int p = scanner.nextInt();
        int q = scanner.nextInt();

        boolean flag = checkVal(p);
        if(flag){
            flag = checkVal(q);
        }

        if(p == q){
            flag = false;
        }

        if(flag){
            int n = p * q;
            int phi_n = (p-1)*(q-1);
    
            System.out.println(n);
            System.out.println(phi_n);
    
            int e = -1;
    
            int m = 5;

            System.out.println("Enter your message :");
            m = scanner.nextInt();

            for(int i = 2; i < phi_n; i++){
                int nflag = 0;
                    int[] result = calculate(nflag, i, phi_n);
                    if(result[0] == 1){
                        continue;
                    }else{
                        e = i;
                    }
                if(e != -1){
                    break;
                }
            }
    
            System.out.println(e);
    
            float d = -1;
            for(int i = 1; i < phi_n; i++){
                d = (((phi_n * i) + 1)/ (float) e);
                if(Math.floor(d) == Math.ceil(d)){
                    break;
                }else{
                    d = -1;
                }
            }
            System.out.println(d);

            BigInteger cbase = BigInteger.valueOf(m);
            BigInteger cpow = BigInteger.valueOf(e);
            BigInteger mod = BigInteger.valueOf(n);

            BigInteger cipherText = cbase.modPow(cpow, mod);
            
            System.out.println("Cypher Text :");
            System.out.println(cipherText);

            BigInteger pow = BigInteger.valueOf((int) d);
    
            BigInteger result = cipherText.modPow(pow, mod);
    
            System.out.println("Original message :");
            System.out.println(result);
        }
    }
}