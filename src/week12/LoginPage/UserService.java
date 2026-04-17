package org.example;

import java.io.*;
import java.util.Scanner;

public class UserService {

    private final String FILE = "users.txt";

    public void saveUser(String user, String pass, String email) {
        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write(user + "," + pass + "," + email + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUser(String user, String pass) {
        try (Scanner sc = new Scanner(new File(FILE))) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                if (data[0].equals(user) && data[1].equals(pass)) {
                    return true;
                }
            }
        } catch (Exception ignored) {}
        return false;
    }

    public boolean userExists(String user, String email) {
        try (Scanner sc = new Scanner(new File(FILE))) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                if (data[0].equals(user) || data[2].equals(email)) {
                    return true;
                }
            }
        } catch (Exception ignored) {}
        return false;
    }
}
