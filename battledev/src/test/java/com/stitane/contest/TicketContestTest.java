package com.stitane.contest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import com.stitane.contest.battledev.tickets.TicketsContest;

import org.junit.Assert;
import org.junit.Test;

public class TicketContestTest {

    @Test
    public void mainTest() throws Exception {
        String dirName = "/tickets/inputs/";
        File[] inputs = Paths.get(getClass().getResource(dirName).toURI()).toFile()
                .listFiles(pathname -> pathname.getName().startsWith("input"));
        int length = Optional.ofNullable(inputs).map(inputs1 -> inputs1.length).orElse(0);
        for (int i = 1; i <= length; i++) {

            String file = dirName + "input" + i + ".txt";
            System.err.println("current : " + file);
            InputStream in = getClass().getResourceAsStream(file);
            URL out = getClass().getResource(dirName + "output" + i + ".txt");
            System.setIn(in);

            // Set the standard output to use newConsole.
            ByteArrayOutputStream consoleOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(consoleOut));

            TicketsContest.main(new String[] {});

            String fileOut = Files.readAllLines(Paths.get(out.toURI())).get(0);
            Assert.assertEquals("out not equals : ", consoleOut.toString().trim(), fileOut);
        }

    }
}
