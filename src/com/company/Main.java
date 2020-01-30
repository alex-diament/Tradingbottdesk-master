package com.company;
//*****ASSGIN STOCKS BASED ON A SCORE RATING

public class Main {
    public static void main(String[] args) {
        urlConnection initial = new urlConnection();
        stockDataParser mainParser = new stockDataParser();
        tester mainTester = new tester();
        dateParser DataParser = new dateParser();
        urlConnection.connect();
       // tester.test();
    }
}
