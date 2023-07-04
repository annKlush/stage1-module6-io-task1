package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            StringBuilder fileContent = new StringBuilder();

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
            Profile pr=new Profile();
            for (String lineData : lines) {
                String[] keyValue = lineData.split(":");
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();

                switch (key) {
                    case "Name":
                        pr.setName(value);
                        break;
                    case "Age":
                        pr.setAge(Integer.parseInt(value));
                        break;
                    case "Email":
                        pr.setEmail(value);
                        break;
                    case "Phone":
                        pr.setPhone(Long.parseLong(value));
                        break;
                    default:
                        break;
                }
            }
            return pr;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Return null if an exception occurs
    }
}
