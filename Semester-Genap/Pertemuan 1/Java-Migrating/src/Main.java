import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int anu1 = 0;
        float anu2 = 1.5f;
        double anu3 = 7.7;

        String anu7;

        System.out.print("Hello Dunia");
        System.out.println("Halo Kamu :" + anu1);//cout<<"anu"<<3;

        System.out.printf("ini anu1 = %d\n", anu1);
        System.out.printf("ini anu2 = %.1f\n", anu2);
        System.out.printf("ini anu3 = %.3f\n", anu3);

        Scanner terminalInput = new Scanner(System.in);

        int angkak;



        System.out.print("Masukkan angkak = ");
        angkak = terminalInput.nextInt();

        System.out.println("Angkak = " + angkak);

        terminalInput = new Scanner(System.in);
        System.out.print("Masukkan anu7 = ");
        anu7 = terminalInput.nextLine();

        System.out.println("anu7 = " + anu7);

        /*if (anu1 <=10 && anu2>=9){
            System.out.println("blabla");
        }

        if (anu7.contains("ucup")){
            System.out.println(anu7 + " ada");
        }
        */
    }
}
