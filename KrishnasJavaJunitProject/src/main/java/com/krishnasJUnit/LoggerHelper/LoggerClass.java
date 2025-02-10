package com.krishnasJUnit.LoggerHelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class LoggerClass {

    public static final Logger logger = LogManager.getLogger(LoggerClass.class);

    public static Marker IMPMarker = MarkerManager.getMarker("IMPORTANT");

}