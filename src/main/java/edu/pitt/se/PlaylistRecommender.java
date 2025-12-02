package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        if (bpms == null || bpms.isEmpty()) {
            throw new IllegalArgumentException("BPM list cannot be null or empty");
        }

        double avg = bpms.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        if (avg >= 140) {
            return "HIGH";
        } else if (avg >= 100) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title) {
        if (title == null) {
            return false;
        }
        if (title.length() < 1 || title.length() > 30) {
            return false;
        }
        // Alphabetic characters and spaces only
        return title.matches("[A-Za-z ]+");
    }

    public static int normalizeVolume(int volumeDb) {
        if (volumeDb < 0) {
            return 0;
        } else if (volumeDb > 100) {
            return 100;
        } else {
            return volumeDb;
        }
    }
}

