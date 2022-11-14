package io.bayrktlihn;

public class App {
    public static void main(String[] args) {


        String imageBase64 = KaptchaProducerUtil.createBase64Image();

        System.out.println(imageBase64);

    }
}
