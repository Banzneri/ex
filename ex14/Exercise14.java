public class Exercise14 {

    public static void main(String[] args) {
        int height = args.length;
        int[] numbers = new int[height];
        int largestNegative = 0;
        int largestPositive = numbers[0];

        for(int i = 0; i < height; i++) {
            numbers[i] = Integer.parseInt(args[i]);
        }

        for(int i : numbers) {
            if(i < largestNegative) {
                largestNegative = i;
            }

            if(i > largestPositive) {
                largestPositive = i;
            }
        }

        int origin = Math.abs(largestNegative);
        int width = origin + largestPositive + 1;

        for(int y = 0; y < height; y++) {
            System.out.println();
            for(int x = 0; x < width; x++) {
                if(x == origin) {
                    System.out.print("|");
                } else if(numbers[y] < 0 && x - origin < 0 && x >= origin + numbers[y]) {
                    System.out.print("-");
                } else if(numbers[y] > 0 && x - origin > 0 && x <= origin + numbers[y]) {
                    System.out.print("+");
                } else {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }
}