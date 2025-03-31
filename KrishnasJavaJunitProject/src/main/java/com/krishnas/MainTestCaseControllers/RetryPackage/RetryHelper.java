package com.krishnas.MainTestCaseControllers.RetryPackage;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.lang.reflect.Method;

public class RetryHelper implements TestExecutionExceptionHandler, BeforeTestExecutionCallback {
    private static final int MAX_RETRIES = 2;
    private int retryCount = 0;

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        Method method = context.getRequiredTestMethod();
        if (retryCount < MAX_RETRIES) {
            retryCount++;
            System.out.println("Retrying test " + method.getName() + " | Attempt " + (retryCount + 1));
            context.getRequiredTestInstance();
            if (context.getTestMethod().isPresent()) {
                context.getTestMethod().get().invoke(context.getRequiredTestInstance());
            }

        }
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        System.out.println("Before Testing Method Test This will have Method To Update");
        retryCount = 0;
    }
}
