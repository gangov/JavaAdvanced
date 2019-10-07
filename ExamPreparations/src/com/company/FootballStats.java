package com.company;

import java.util.*;


/*
You know that football is "The King of Sports". In our days football is not just a sport, it is business and like every
business there is some stats that are needed. More important stats than everything is result of matches between teams.
So now you will need to write a program that take care of all results between teams. At begging you will need to read
all results from matches in format:
{firstTeam} - {secondTeam} result {firstTeamGoals}:{secondTeamGoals}
You will get results till you read "Season End" command. Then you will get one more single line with all teams that you
need to print, separated with ", ". You have to print all games, that team play in format:
{team} - {opponent} result {teamGoals}:{opponentGoals}
All opponents for current team have to be print in alphabetical order.

Input
The input comes from the console as varying number of lines. You have to parse every command until the command that
follows is "Season End". The input will be in the format displayed above, there is no need to check it explicitly.

Output
For every team stats you need to print, you need to sort its opponents in alphabetical order. Result for all matches
have to be in format {teamGoals}:{opponentGoals}.

Constraints
The number of teams will be in the range [1..50]
The number of results for each teams will be in the range [1..1000]
Time limit: 0.3 sec. Memory limit: 16 MB.
 */
public class FootballStats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, TreeMap<String, int[]>> games = new TreeMap<>();

        while (!input.equals("Season End")) {
            String[] tokens = input.split(" result ");
            String[] teams = tokens[0].split(" - ");
            String[] score = tokens[1].split(":");
            int firstTeamScore = Integer.parseInt(score[0]);
            int secondTeamScore = Integer.parseInt(score[1]);

            String teamFirst = teams[0];
            String teamSecond = teams[1];


            games.putIfAbsent(teamFirst, new TreeMap<>());
            games.get(teamFirst).putIfAbsent(teamSecond, new int[]{firstTeamScore, secondTeamScore});


            input = scanner.nextLine();
        }

        String[] requestStatistics = scanner.nextLine().split(", ");

        for (String teamStats : requestStatistics) {
            if (games.containsKey(teamStats)) {
                games.get(teamStats).entrySet().stream().forEach(t -> {
                    System.out.println(String.format("%s - %s -> %d:%d", teamStats, t.getKey(), t.getValue()[0], t.getValue()[1]));
                });
            }
//            else {
//                System.out.print(teamStats + " - ");
//                games.keySet().forEach(name -> System.out.print(name + ""));
//            }
        }
    }
}

