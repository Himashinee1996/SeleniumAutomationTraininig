package com.pragmatic.testng;

import org.testng.annotations.*;

public class TestingExample {

    @BeforeClass
    public void BeforeClass(){

        System.out.println("TestingExample.BeforeClass");
    }

    @AfterClass
    public void afterClass(){

        System.out.println("TestingExample.afterClass");
    }

    @BeforeMethod
    public void BeforeMethod(){

        System.out.println("TestingExample.BeforeMethod");
    }

    @AfterMethod
    public void afterMethod(){

        System.out.println("TestingExample.afterMethod");
    }

    @Test
    public void testMethod1(){

        System.out.println("TestingExample.testMethod1");
    }

    @Test
    public void testMethod2(){

        System.out.println("TestingExample.testMethod1");
    }

    @Test
    public void testMethod3(){

        System.out.println("TestingExample.testMethod1");
    }

    @Test
    public void testMethod4(){

        System.out.println("TestingExample.testMethod1");
    }

    @Test
    public void testMethod5(){

        System.out.println("TestingExample.testMethod1");
    }
}
