package com.krishnas.MainTestCaseControllers.SeleniumTests;

import com.krishnas.MainTestCaseControllers.RetryPackage.RetryHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(RetryHelper.class)
public class UnitTestCase {

    public int RetryMethodTest = 0;

    @Test
    public void Method1Test() {
        if (RetryMethodTest < 1) {
            RetryMethodTest++;
            throw new RuntimeException("Trying to Regenerate Method");

        }
        System.out.println("Execution Method");
    }
}
