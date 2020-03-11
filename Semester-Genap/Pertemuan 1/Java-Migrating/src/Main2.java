import java.util.ArrayList;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] deret = new int[5];
        deret[0] = 0;
        deret[1] = 1;
        deret[2] = 2;
        deret[3] = 3;
        deret[4] = 4;

        int deret2[] = {5,6,7,8,9};

//        //cara 1
//        System.out.println("cara 1");
//        for (int i=0; i<deret.length; i++){
//            System.out.print(deret[i] + " ");
//        }
//        System.out.println();
//
//        //cara 2
//        System.out.println("cara 2");
//        for (int x : deret2) {
//            System.out.print(x + " ");
//        }
//        System.out.println();

//        //konversi
//        System.out.println("konversi");
//        String sDeret = Arrays.toString(deret);
//        System.out.println(sDeret);
//
//        int x = 4;
//        String sX = Integer.toString(x);
//
//        String bil = "5";
//        double ibil = Double.parseDouble(bil);
//        double jumlah = ibil + 3.5;

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(99);
        for (int i: arrayList) {
            System.out.println(i);
        }
    }
}
