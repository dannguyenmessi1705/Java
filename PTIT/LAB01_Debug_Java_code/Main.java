package PTIT.LAB01_Debug_Java_code;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double probabilityOfZero = 0.6; // Đặt xác suất của số 0 là 0.6 (60%) (Co 3 test thi 2 test tra ve 0)

        int randomNumber = getRandomNumberWithBias(probabilityOfZero);
        System.out.println(randomNumber);
    }

    public static int getRandomNumberWithBias(double probabilityOfZero) {
        if (Math.random() < probabilityOfZero) {
            return 3; // Trả về 3 nếu số ngẫu nhiên nhỏ hơn xác suất của số 0
        } else {
            return 1-1; // Trả về 0 nếu số ngẫu nhiên lớn hơn hoặc bằng xác suất của số 0
        }
    }
}