public class Calculator {
    public static int calculateString(String text) {
        // ใช้ split() เพื่อแยกคำใน String ด้วยช่องว่าง
        String[] textArray = text.split(" ");

        // ดึงตัวเลขและตัวดำเนินการออกมาจาก textArray
        int num1 = Integer.parseInt(textArray[0]);
        int num2 = Integer.parseInt(textArray[2]);
        String operator = textArray[1];

        // ดำเนินการคำนวณตามตัวดำเนินการ
        int result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
        }

        return result;
    }

    public static void main(String[] args) {
        // เรียกใช้งานฟังก์ชัน calculateString() และแสดงผลลัพธ์
        String text = "3 + 4";
        int result = calculateString(text);
        System.out.println("Result: " + result);  // ผลลัพธ์ควรจะเป็น 7
    }
}