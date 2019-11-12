package main.java;

import main.kotlin.HTML;

public class HtmlTester {
    public static void main(String[] args) {
        HTML html = new HTML("div");
        html.body();
        System.out.println(html.getName());
    }
}


