package com.cengage.mtx.automation.BasicSmoke.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class Henley_Basic_Smoke_TestRunner.
 */
public class Henley_Basic_Smoke_TestRunner {
        
        /**
         * Test.
         */
        @Test
        public void Test() {
                List<String> file = new ArrayList<String>();
                file.add("Henley_Basic_Smoke_TestRunner.xml");
                TestNG testNG = new TestNG();
                testNG.setTestSuites(file);
                testNG.setOutputDirectory("./target/test-output");
                testNG.run();
                try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        }
}


