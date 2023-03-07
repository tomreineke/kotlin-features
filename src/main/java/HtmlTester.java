package main.java;

import main.kotlin.HTML;

/*
 * This class simply shows the interoperability between Java and Kotlin. You can create an object of a Kotlin class
 * in Java code.
 */

public class HtmlTester {
    public static void main(String[] args) {
        HTML html = new HTML("div");
        html.body();
        System.out.println(html.getName());
    }
}


