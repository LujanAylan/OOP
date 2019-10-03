package app;

public class App {
    public static void main(String[] args) throws Exception {
        int a = 0;
        a = 5;
        cambiar(a);
        System.out.println(a);
    }
    
    public static void cambiar(int b) {
        b = 8;
    }
}