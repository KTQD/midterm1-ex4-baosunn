public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};

        SumThread sumThread = new SumThread(numbers);
        MaxThread maxThread = new MaxThread(numbers);

        sumThread.start();
        maxThread.start();

        try {
            sumThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MaxThread extends Thread {
    private int[] numbers;
    private int max;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("Phan tu lon nhat: " + max);
    }
}


class SumThread extends Thread {
    private int[] numbers;
    private int sum;

    public SumThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Tong cac pha tu trong mang: " + sum);
    }
}

