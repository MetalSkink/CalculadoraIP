package calculadoraip;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Luis Xavier
 */
public class CalculadoraIP {

    public static void main(String[] args) {
        int nredes, num;
        int acum = 0;
        System.out.println("Cuantas redes tienes: ");
        Scanner sc = new Scanner(System.in);
        nredes = sc.nextInt();
        Integer[] a = new Integer[nredes];
        int[] b = new int[nredes];
        int[] c = new int[nredes];
        //Mete las redes a un arreglo
        for (int i = 0; i < nredes; i++) {
            System.out.println("Ingresa tu red numero " + (i + 1));
            num = sc.nextInt();
            a[i] = num;
        }

        Arrays.sort(a, Collections.reverseOrder());
        
        //Imprime el arreglo
        System.out.println(Arrays.toString(a));
        //Calcula la aproximacion de las redes
        for (int i = 0; i < nredes; i++) {
            if (a[i] <= 2) {
                b[i] = 2;
                c[i] = 30;
            } else if (a[i] <= 6) {
                b[i] = 6;
                c[i] = 29;
            } else if (a[i] <= 14) {
                b[i] = 14;
                c[i] = 28;
            } else if (a[i] <= 30) {
                b[i] = 30;
                c[i] = 27;
            } else if (a[i] <= 62) {
                b[i] = 62;
                c[i] = 26;
            } else if (a[i] <= 126) {
                b[i] = 126;
                c[i] = 25;
            } else if (a[i] <= 254) {
                b[i] = 254;
                c[i] = 24;
            }else if(a[i] <= 510) {
                b[i] = 510;
                c[i] = 23;
            }else if(a[i] <= 1022) {
                b[i] = 1022;
                c[i] = 22;
            }else if(a[i] <= 2046) {
                b[i] = 2046;
                c[i] = 21;}
            acum += b[i];
        }
        System.out.println(Arrays.toString(b));
        System.out.println("numero de espacios necesarios " + acum);
        System.out.println("Tus submascaras seran: ");
        System.out.println(Arrays.toString(c));

        Arrays.sort(c);
        //CREAMOS ARRAYS
        //
        
        if (acum <= 256) {//Si es una red tipo C
            acum = 0;
            System.out.println("Es una red tipo C");
            for (int i = 0; i < nredes; i++) {
                System.out.println("Red " + (i+1));
                calcBits.imprimeBits(c[i]);
                calcBits.imprimeDir(c[i]);
                System.out.println();
                System.out.println("R:  192.168.1." + acum + "/" + c[i]);
                System.out.println("P:  192.168.1." + (acum + 1));
                acum += b[i];
                if (c[i]==30){
                System.out.println("U:  192.168.1." + (acum));
                System.out.println("B:  192.168.1." + (acum + 1));
                }else{
                System.out.println("U:  192.168.1." + (acum - 1));
                System.out.println("G:  192.168.1." + (acum));
                System.out.println("B:  192.168.1." + (acum + 1));
                }
                acum += 2;
                System.out.println(" ");
                System.out.println(" ");

            }

        }//Si es una red tipo B
        else if (acum<=65536){
            int unidad=0;
            System.out.println("Es una red tipo B");
            acum=0;
            
            for (int i = 0; i < nredes; i++) {
                System.out.println("Red " + (i+1));
                calcBits.imprimeBits(c[i]);
                calcBits.imprimeDir(c[i]);
                if(acum==254){
                    acum-=254;
                    unidad+=1;
                }
                System.out.println("R:  172.16."+unidad+"."+acum+"/" + c[i]);
                System.out.println("P:  172.16."+unidad+"."+(acum+1));
                acum+=b[i];
                if (acum>=255){
                    do{
                    acum-=256;
                    unidad+=1;
                    }while (acum>255);
                }
                if (c[i]==30){
                if (acum>=255){
                    do{
                    acum-=256;
                    unidad+=1;
                    }while (acum>255);
                }
                System.out.println("U:  172.16." +unidad+"."+(acum));
                System.out.println("B:  172.16." +unidad+"."+(acum+1));
                acum+=2;
                }else{
                System.out.println("U:  172.16." +unidad+"."+(acum-1));
                System.out.println("G:  172.16." +unidad+"."+(acum));
                if (acum>=255){
                    do{
                    acum-=256;
                    unidad+=1;
                    }while (acum>255);
                }
                
                System.out.println("B:  172.16." +unidad+"."+(acum+1));
                acum+=2;
                if (acum>=255){
                    do{
                    acum-=256;
                    unidad+=1;
                    }while (acum>255);
                }
                }
                
            }
        }
    }
}