public class hw1Exceptions {
    public static void main(String[] args) {
        int exception;
        int num = 10, den = 0;
        try {
            exception = num / den;
            System.out.println(exception);
            System.out.println("try succeeded");
        } catch (ArithmeticException e) {
            System.out.println("try failed, ArithExcept ;P");
        }
        int hello2 = Integer.parseInt("123a");
    }

}
