package com.mengcraft.scoreboard.body;

import com.mengcraft.scoreboard.TextLine;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created on 16-5-18.
 */
public class FixedBodyTest {

    @Test
    public void of() throws Exception {
        FixedBody.of(Arrays.asList(
                TextLine.of("" + System.nanoTime()),
                TextLine.of("" + System.nanoTime())
        )); // With pre-build line list, all line was static
        FixedBody.of(Arrays.asList(
                TextLine.of("" + System.nanoTime()),
                () -> "" + System.nanoTime()
        )); // With pre-build line list, include a dynamic line
        FixedBody.of(() -> Arrays.asList(
                TextLine.of("" + System.nanoTime()),
                TextLine.of("" + System.nanoTime())
        ));// With lister, build line list dynamic
    }

}