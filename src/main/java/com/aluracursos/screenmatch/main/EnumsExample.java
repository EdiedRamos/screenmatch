package com.aluracursos.screenmatch.main;

enum Level {
    EASY(1, "1 point"),
    MEDIUM(2, "2 points"),
    HARD(3, "3 points");

    private final String pointsMessage;
    private final int points;

    Level(int points, String pointsMessage) {
        this.pointsMessage = pointsMessage;
        this.points = points;
    }

    public String getPointsMessage() {
        return pointsMessage;
    }

    public int getPoints() {
        return points;
    }

    public String toString() {
       return pointsMessage;
    }
}

public class EnumsExample {
    public static void main(String[] args) {
        Level easy = Level.EASY;
        Level medium = Level.MEDIUM;
        Level hard = Level.HARD;

        int totalEasyProblems = 150;
        int totalMediumProblems = 200;
        int totalHardProblems = 50;

        int totalPoints = totalEasyProblems * easy.getPoints() + totalMediumProblems * medium.getPoints() + totalHardProblems * hard.getPoints();

        System.out.println(totalPoints + " points");
    }
}
