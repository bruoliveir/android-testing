package com.example.unittesting;

import junit.framework.Assert;

import org.junit.Test;

public class ConverterTest {

    final double MPH = 60;
    final double KMH = 96.5606;
    final double DELTA = 0.1;

    @Test
    public void checkMphToKmh() {
        double result = Converter.mphToKmh(MPH);
        Assert.assertEquals(result, KMH, DELTA);
    }

    @Test
    public void checkKmhToMph() {
        double result = Converter.kmhToMph(KMH);
        Assert.assertEquals(result, MPH, DELTA);
    }
}
