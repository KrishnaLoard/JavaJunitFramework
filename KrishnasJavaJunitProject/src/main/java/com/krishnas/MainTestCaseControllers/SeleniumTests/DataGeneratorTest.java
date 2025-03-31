package com.krishnas.MainTestCaseControllers.SeleniumTests;

import com.krishnasJUnit.basePackage.BaseTestCase;
import com.krishnasJUnit.basePackage.TestDataGenerator;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class DataGeneratorTest extends BaseTestCase {

    @Test
    @Timeout(15)
    public void EmailTest() {
        Assert.assertFalse("Email Is Empty", TestDataGenerator.generateEmail().isEmpty());
    }
}
