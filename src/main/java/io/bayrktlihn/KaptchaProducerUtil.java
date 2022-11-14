package io.bayrktlihn;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

import java.awt.image.BufferedImage;
import java.util.Base64;
import java.util.Properties;

public class KaptchaProducerUtil {


    public static String createBase64Image() {


        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(new Config(defaultProperties()));


        String text = defaultKaptcha.createText();
        BufferedImage image = defaultKaptcha.createImage(text);


        byte[] bytes = ImageUtil.toByteArray(image, "jpeg");


        return Base64.getEncoder().encodeToString(bytes);


    }


    private static Properties defaultProperties() {
        Properties properties = new Properties();
        properties.setProperty("kaptcha.image.width", "175");
        properties.setProperty("kaptcha.image.height", "60");
        properties.setProperty("kaptcha.textproducer.font.size", "32");
        properties.setProperty("kaptcha.textproducer.font.color", "255,255,255");
        properties.setProperty("kaptcha.textproducer.char.length", "8");
        properties.setProperty("kaptcha.border", "yes");
        properties.setProperty("kaptcha.border.color", "red");
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.DefaultNoise");
        properties.setProperty("kaptcha.noise.color", "white");
        properties.put("kaptcha.background.clear.from", "red");
        properties.put("kaptcha.background.clear.to", "blue");
        properties.put("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
        return properties;
    }


}
