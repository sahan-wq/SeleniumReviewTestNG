package com.techproed.tests;

import org.testng.annotations.Test;

public class DependsOnMethodsTest {
    @Test
    public void test01(){
        System.out.println("Test01");

    }
    @Test(dependsOnMethods = "test01")
    public void test02(){
        System.out.println("Test02");

    }
}
