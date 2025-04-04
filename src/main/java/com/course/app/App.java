package com.course.app;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
        logger.info("Hello, world");
        logger.info("Hello, world");
        logger.info("Hello, world");
    }
}
