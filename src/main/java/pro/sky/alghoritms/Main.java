package pro.sky.alghoritms;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        IntegerList integerList = new IntegerListImpl();

        int sizeArr = 100_000;

        Random r = new Random();

        for (int i = 0; i < sizeArr; i++) {
            integerList.add(r.nextInt(100_000) + 1);
        }

        System.out.println("integerList = " + integerList);

        IntegerList integerList2 = new IntegerListImpl();
        IntegerList integerList3 = new IntegerListImpl();
        integerList.integerListCopy(integerList2);
        integerList.integerListCopy(integerList3);


        long start1 = System.currentTimeMillis();
        System.out.println(integerList.contains(56,"Bubbles"));
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        System.out.println(integerList.contains(56,"Selection"));
        System.out.println(System.currentTimeMillis() - start2);

        long start3 = System.currentTimeMillis();
        System.out.println(integerList.contains(56,"Inspection"));
        System.out.println(System.currentTimeMillis() - start3);
    }

    }
