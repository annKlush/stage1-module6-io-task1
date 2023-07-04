package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = null;
        BufferedReader br = null;
        try {
            StringBuilder fileContent = new StringBuilder();
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append("\n");
            }

            String profileData = fileContent.toString();
            String[] lines = profileData.split("\n");
            String name = "";
            int age = 0;
            String email = "";
            long phone = 0;

            for (String lineData : lines) {
                String[] keyValue = lineData.split(":");
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();

                switch (key) {
                    case "Name":
                        name = value;
                        break;
                    case "Age":
                        age = Integer.parseInt(value);
                        break;
                    case "Email":
                        email = value;
                        break;
                    case "Phone":
                        phone = Long.parseLong(value);
                        break;
                    default:
                        break;
                }
            }

            profile = new Profile(name, age, email, phone);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return profile;
    }
}
