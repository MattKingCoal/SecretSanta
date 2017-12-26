package com.match.games.ss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.match.games.ss.model.User;

public class SecretSanta {

    private static List<User> users = new ArrayList<>();
    private static List<User> copy;
    private static int shuffles;

    static Logger log = Logger.getLogger(SecretSanta.class);

    public static void main(String[] args) {
        log.info("Starting.........");
        readUsers(args);
        while (!assignSantys()) {
        }
        printUsers();
        log.info("Took " + shuffles + " shuffles");
    }

    private static boolean assignSantys() {
        log.debug("Starting the shuffle and assign...");
        shuffles++;
        Collections.shuffle(users);
        copy = new ArrayList<User>(users);
        Collections.shuffle(copy);
        for (User u : users) {
            if (!u.equals(copy.get(0))) {
                u.setSecretSanta(copy.get(0));
                log.debug(u.getName() + " is secret santa for " + copy.get(0).getName());
                copy.remove(0);
            } else if (copy.size() > 1) {
                u.setSecretSanta(copy.get(1));
                log.debug(u.getName() + " is secret santa for " + copy.get(1).getName());
                copy.remove(1);
            } else {
                log.debug("Nobody left for " + u.getName());
                return false;
            }
        }
        return true;
    }

    private static void printUsers() {
        log.info(users.size() + " users..........");
        for (User u : users) {
            log.info(u);
        }

    }

    private static void readUsers(String[] args) {
        for (String s : args) {
            users.add(new User(s, s.toLowerCase() + "@gmail.com"));
        }
    }
}
