package calculadoraip;

/**
 *
 * @author Luis Xavier
 */
public class calcBits {
    
    public static void imprimeBits(int a){
        int resto=a;
        int ban=4;
        for (int i=0;i<4;i++){
            for (int z=0;z<8;z++){
            if (resto>=1){
               System.out.print("1");
               resto-=1;
            }else{
                System.out.print("0"); 
            }
        }
        ban-=1;
        if (ban>=1){
        System.out.print(".");  
            }
        }
    }
    public static void imprimeDir(int b){
        System.out.println("");
        switch (b) {
            case 21:
                System.out.println("La direccion es: ");
                System.out.println("255.255.248.0");
                break;
            case 22:
                System.out.println("La direccion es: ");
                System.out.println("255.255.252.0");
                break;
            case 23:
                System.out.println("La direccion es: ");
                System.out.println("255.255.254.0");
                break;
            case 24:
                System.out.println("La direccion es: ");
                System.out.println("255.255.255.0");
                break;
            case 25:
                System.out.println("La direccion es: ");
                System.out.println("255.255.255.128");
                break;
            case 26:
                System.out.println("La direccion es: ");
                System.out.println("255.255.255.192");
                break;
            case 27:
                System.out.println("La direccion es: ");
                System.out.println("255.255.255.224");
                break;
            case 28:
                System.out.println("La direccion es: ");
                System.out.println("255.255.255.240");
                break;
            case 29:
                System.out.println("La direccion es: ");
                System.out.println("255.255.255.248");
                break;
            case 30:
                System.out.println("La direccion es: ");
                System.out.println("255.255.255.252");
                break;
            case 31:
                System.out.println("La direccion es: ");
                System.out.println("255.255.255.254");
                break;
            case 32:
                System.out.println("La direccion es: ");
                System.out.println("255.255.255.255");
                break;
            default:
                break;
        }
    }
}
