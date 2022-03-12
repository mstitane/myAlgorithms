package com.stitane.contest;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import com.stitane.contest.battledev.gym.GymPassword;
import org.junit.Assert;
import org.junit.Test;

public class GymPasswordTest {

    @Test
    public void gymPasswordTest() throws Exception {
        InputStream in = getClass().getResourceAsStream("/gym/inputs/input1.txt");
        URL out = getClass().getResource("/gym/inputs/output1.txt");
        System.setIn(in);

        // Set the standard output to use newConsole.
        ByteArrayOutputStream consoleOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOut));

        GymPassword.main(new String[] {});

        String fileOut = Files.readAllLines(Paths.get(Objects.requireNonNull(out).toURI())).get(0);
        Assert.assertEquals("out not equals : ", consoleOut.toString().trim(), fileOut);

    }
}
