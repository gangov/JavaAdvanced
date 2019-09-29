package com.company;

import java.util.*;

/*
Marian is a famous system administrator. The person to overcome the security of his servers has not yet been born.
However, there is a new type of threat where users flood the server with messages and are hard to be detected since
they change their IP address all the time. Well, Marian is a system administrator and is not so into programming.
Therefore, he needs a skillful programmer to track the user logs of his servers. You are the chosen one to help him!
You are given an input in the format:
IP=(IP.Address) message=(A&sample&message) user=(username)
Your task is to parse the IP and the username from the input and for every user, you have to display every IP from
which the corresponding user has sent a message and the count of the messages sent with the corresponding IP. In the
output, the usernames must be sorted alphabetically while their IP addresses should be displayed in the order of their
first appearance. The output should be in the following format:
username:
IP => count, IP => count.
For example, given the following input - IP=192.23.30.40 message='Hello&derps.' user=destroyer, you have to get the
username destroyer and the IP 192.23.30.40 and display it in the following format:
destroyer:
192.23.30.40 => 1.
The username destroyer has sent a message from IP 192.23.30.40 once.
Check the examples below. They will further clarify the assignment.
Input
The input comes from the console as varying number of lines. You have to parse every command until the command that
follows is end. The input will be in the format displayed above, there is no need to check it explicitly.
Output
For every user found, you have to display each log in the format:
username:
IP => count, IP => count…
The IP addresses must be split with a comma, and each line of IP addresses must end with a dot.
Constraints
The number of commands will be in the range [1..50]
The IP addresses will be in the format of either IPv4 or IPv6.
The messages will be in the format: This&is&a&message
The username will be a string with length in the range [3..50]
Time limit: 0.3 sec. Memory limit: 16 MB.
 */
public class UserLogsExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String, Integer>> information = new TreeMap<>();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String ip = tokens[0].substring(3);
            String message = tokens[1].substring(9, tokens[1].length() - 1);
            String user = tokens[2].substring(5);

            information.putIfAbsent(user, new LinkedHashMap<>()); // putting the username if there is none
            if (information.containsKey(user)) { // checking if there's a username
                information.get(user).putIfAbsent(ip, 0); // we have username, putting the ip address if there is none
                information.get(user).put(ip, information.get(user).get(ip) + 1); // we have ip address, increasing the occurrence
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> usernameAndIP : information.entrySet()) {
            String username = usernameAndIP.getKey();
            LinkedHashMap<String, Integer> ipAndMessages = usernameAndIP.getValue();
            System.out.printf("%s:%n", username);
            int time = 0;
            for (Map.Entry<String, Integer> ipAndTimes : ipAndMessages.entrySet()) {
                String ip = ipAndTimes.getKey();
                int count = ipAndTimes.getValue();
                if (time == information.get(username).size() - 1) {
                    System.out.printf("%s => %d.%n", ip, count);
                } else {
                    System.out.printf("%s => %d, ", ip, count);
                }
                time++;
            }
        }
    }
}
