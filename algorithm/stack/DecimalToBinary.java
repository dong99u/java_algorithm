package algorithm.stack;

class DecimalToBinary {
    public static String decimalToBinary(int number) {
        StringBuilder sb = new StringBuilder();

        while (number > 1) {
            sb.append(number % 2);
            number /= 2;
        }

        sb.append(number);

        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(12345));
    }
}