package org.example;

public class Main {

    // Palindrom
    public static boolean isPalindrome(int number) {
        number = Math.abs(number);
        int original = number;
        int reversed = 0;

        while (number != 0) {
            int lastDigit = number % 10;
            reversed = reversed * 10 + lastDigit;
            number /= 10;
        }

        return original == reversed;
    }

    // Mükemmel sayı
    public static boolean isPerfectNumber(int number) {
        if (number < 0) {
            return false;
        }

        int toplam = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                toplam += i;
            }
        }
        return toplam == number;
    }

    // kelimeler
    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        int reversed = reverse(number);
        int originalDigitCount = getDigitCount(number);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < originalDigitCount; i++) {
            int lastDigit = reversed % 10;
            result.append(digitToWord(lastDigit));
            if (i != originalDigitCount - 1) {
                result.append(" ");
            }
            reversed /= 10;
        }

        return result.toString();
    }



    public static String digitToWord(int digit) {
        switch (digit) {
            case 0: return "Zero";
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return "";
        }
    }


    public static int reverse(int number) {
        int reversed = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            reversed = reversed * 10 + lastDigit;
            number /= 10;
        }
        return reversed;
    }

    // Rakam sayısını bul
    public static int getDigitCount(int number) {
        if (number == 0) {
            return 1;
        }
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        // Palindrom testleri
        System.out.println("isPalindrome(-1221): " + isPalindrome(-1221)); // true
        System.out.println("isPalindrome(707): " + isPalindrome(707));     // true
        System.out.println("isPalindrome(11212): " + isPalindrome(11212)); // false

        // Mükemmel sayı testleri
        System.out.println("isPerfectNumber(6): " + isPerfectNumber(6));   // true
        System.out.println("isPerfectNumber(28): " + isPerfectNumber(28)); // true
        System.out.println("isPerfectNumber(5): " + isPerfectNumber(5));   // false
        System.out.println("isPerfectNumber(-1): " + isPerfectNumber(-1)); // false

        // numberToWords testleri
        System.out.print("numberToWords(123): ");
        numberToWords(123); // One Two Three

        System.out.print("numberToWords(1010): ");
        numberToWords(1010); // One Zero One Zero

        System.out.print("numberToWords(-12): ");
        numberToWords(-12); // Invalid Value
    }
}


