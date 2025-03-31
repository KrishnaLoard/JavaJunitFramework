package com.krishnas.MainTestCaseControllers.SeleniumTests;

import com.krishnas.MainTestCaseControllers.RetryPackage.RetryHelper;
import com.krishnasJUnit.basePackage.BaseTestCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(RetryHelper.class)
public class UIPageTestCase extends BaseTestCase {

    public static int RetryAttempt = 0;

    @Test
    public void UIPageTestCase1_TEST() throws Exception {
        Thread.sleep(5000);
        if (RetryAttempt == 1) {
            System.out.println("Retry Happening");
        }
        if (RetryAttempt < 1) {
            RetryAttempt++;
            throw new Exception("Method Exception");
        }
    }
}
