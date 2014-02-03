package com.cengage.mtx.smoke_test.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;

/**
 * The Class StudentWorkFlowSomkeTestRunner.
 */
public class StudentWorkFlowSomkeTestRunner {
        
        /**
         * Test.
         */
        @Test
        public void Test() {
                List<String> file = new ArrayList<String>();
                file.add("MTX_Smoke_Suite.xml");
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


