package com.epam.mjc.io;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("./src/main/resources/Profile.txt");
        Profile profile = new FileReader().getDataFromFile(file);
    }
}
