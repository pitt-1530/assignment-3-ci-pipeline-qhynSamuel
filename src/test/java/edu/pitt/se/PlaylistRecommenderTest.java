package edu.pitt.se;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

public class PlaylistRecommenderTest {

    @Test
    public void testClassifyEnergyHigh() {
        assertEquals("HIGH",
            PlaylistRecommender.classifyEnergy(Arrays.asList(150, 160)));
    }

    @Test
    public void testClassifyEnergyMedium() {
        assertEquals("MEDIUM",
            PlaylistRecommender.classifyEnergy(Arrays.asList(110, 120)));
    }

    @Test
    public void testClassifyEnergyLow() {
        assertEquals("LOW",
            PlaylistRecommender.classifyEnergy(Arrays.asList(80, 90)));
    }

    @Test
    public void testClassifyEnergyRejectsNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            PlaylistRecommender.classifyEnergy(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            PlaylistRecommender.classifyEnergy(Collections.emptyList());
        });
    }

    @Test
    public void testIsValidTrackTitle() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("Hello World"));
        assertFalse(PlaylistRecommender.isValidTrackTitle("Bad!"));      // special char
        assertFalse(PlaylistRecommender.isValidTrackTitle("123"));       // digits
        assertFalse(PlaylistRecommender.isValidTrackTitle(null));        // null input
    }

    @Test
    public void testNormalizeVolume() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(150));
        assertEquals(0, PlaylistRecommender.normalizeVolume(-30));
        assertEquals(80, PlaylistRecommender.normalizeVolume(80));
    }
}
