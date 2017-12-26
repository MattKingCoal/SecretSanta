package com.match.games.ss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

public class SantaShuffle {

    static Logger log = Logger.getLogger(SantaShuffle.class);

    public static void main(String[] args) {
        List<String> list = Arrays.asList(args);
        log.info(String.format("%s santas to shuffle", args.length));
        List<String> copy = new ArrayList<>(list);
        int shuffles = 0;
        do {
            log.info("Shuffling......");
            Collections.shuffle(copy);
            shuffles++;
        } while (!shuffled(list, copy));

        printResult(list, copy, shuffles);
        log.info("Bye now");
    }

    private static void printResult(List<String> list, List<String> copy, int shuffles) {
        // log.info("Secret santas decided after " + shuffles + " shuffles");
        log.info(String.format("Secret santas decided after %d shuffles", shuffles));
        for (int i = 0; i < list.size(); i++) {
            log.info(String.format("%s ---------> %s", list.get(i), copy.get(i)));
        }

    }

    private static boolean shuffled(List<String> list, List<String> copy) {
        for (String s : list) {
            String sameIndexInCopy = copy.get(list.indexOf(s));
            if (s.equals(sameIndexInCopy)) {
                log.info(String.format("%s matched with themselves", s));
                return false;
            }
        }
        return true;
    }
}
