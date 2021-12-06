package com.lhauspie.example.kafka;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

import java.nio.charset.StandardCharsets;

public class PojoGenerator {

    public static final EasyRandom easyRandom = new EasyRandom(
            new EasyRandomParameters()
                    .seed(123L)
                    .objectPoolSize(100)
                    .randomizationDepth(5)
                    .charset(StandardCharsets.UTF_8)
                    .stringLengthRange(5, 10)
                    .collectionSizeRange(1, 3)
                    .scanClasspathForConcreteTypes(true)
                    .overrideDefaultInitialization(false)
                    .ignoreRandomizationErrors(true)
    );

    public static <T> T generate(Class<T> clazz) {
        return easyRandom.nextObject(clazz);
    }
}
