package by.it.moroz.jd01_07;

public class Runner {

    public static void main(String[] args) {

        Var var1 = new Scalar(3.1415);
        Var var2 = new Scalar("3.1415");
        Var var3 = new Scalar((Scalar) var1);
        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
    }
}
