package pro.sky.alghoritms;

public class Main {
    public static void main(String[] args) {

        StringList stringList = new StringListImpl();

        stringList.add("один");
        stringList.add("два");
        stringList.add("три");
        stringList.add("пять");
        System.out.println(stringList);
        System.out.println();

        stringList.add(1, "два");
        System.out.println(stringList);
        System.out.println();

        stringList.remove("пять");
        System.out.println(stringList);

    }
}
