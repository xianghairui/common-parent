package com.xiang.demo.java.pecs;

import com.xiang.demo.java.pecs.example.Apple;
import com.xiang.demo.java.pecs.example.Fruit;
import com.xiang.demo.java.pecs.example.Plate;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Auther: xianghairui
 * Date: 2018/8/30 18:29
 * Description:
 */
public class PecsTest {

    private static final Logger logger = LoggerFactory.getLogger(PecsTest.class);

    @Test
    public void test01() {

        Plate<Fruit> p = new Plate<>(new Apple());

        logger.info("p = {}", p);

    }


}
