public class Main {
    public static float convert(int a){
        return a*3.785f;
    }
    public static int fitCalc(int a, int b){
        return a*b;
    }
    public static int containers(int a, int b, int c){
        return a*20+b*50+c*100;
    }
    public static String triangleType(int a, int b, int c){
        if(a >= b + c || b >= a + c || c >= a + b) {
            return "not a triangle";
        }else if(a==b && b==c){
            return "isosceles";
        }else if(a==b || b==c || c==a){
            return "equilateral";
        }else{
            return "different-sided";
        }
    }
    public static int ternaryEvaluation(int a, int b){
        return a>b ? a : b;
    }
    public static int howManyItems(double n, double w, double h) {
        double area = n * 2;
        double itemArea = w * h * 4;
        double numItems = area / itemArea;
        return (int) Math.floor(numItems);
    }
    public static int factorial(int a){
        int fac = 1;
        for (int i=1; i!=a+1; i++){
            fac = fac *i ;
        }
        return fac;
    }
    public static int gcd(int a, int b){
        int max, min, del = 0;
        max = a > b ? a : b;
        min = max == b ? a : b;
        for(int i = min; i != 0; i--){
            if(max % i == 0 && min % i == 0){
                del = i;
                break;
            }
        }
        return del;
    }
    public static float ticketSaler(int a, int b) {return a * b * 0.72f;
    }
    public static int tables(int a, int b){
        double fun = a-b*2;
        fun = fun>0 ? Math.ceil(fun/2) : 0;
        return (int) fun ;
    }
    public static void main(String[] args) {
        System.out.println("№1");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

        System.out.println("№2");
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));

        System.out.println("№3");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));

        System.out.println("№4");
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));

        System.out.println("№5");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));

        System.out.println("№6");
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));

        System.out.println("№7");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println("№8");
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));

        System.out.println("№9");
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        System.out.println("№10");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }
}