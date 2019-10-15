package SecondExam;

import java.util.*;

/*
A new club has opened in town and everyone wants to go partying. The club has many halls and people may only go there
with reservations.
You will be given n – an integer specifying the halls' maximum capacity. Then you will be given input line which will
contain English alphabet letters and numbers, separated by a single space. The input for the line should be read from
the last inserted to the first one. The letters represent the halls and the numbers – the people in a single
reservation. Companies of people should go in the halls. The first entered hall is the first which people are entering.
Every reservation takes specific capacity, equal to its number.
When a hall overflows (it cannot contain a given number of people due to lack of enough free capacity), it passes the
people to the next entered hall. If there is no open hall and you receive a reservation, you should skip it.
If a hall overflows you must remove it, and print it on the console, along with all of the companies of people it
currently contains. After you’ve removed that hall, the next one becomes the first in the order – people will first be
passed to it.


Input
The input will come in only one line containing letters and digits separated by a space.


Output
For output, you must print a hall, every time it overflows, after removing it.
The format is the following: {hall} -> {reservation1}, {reservation2}…
Where {hall} is the letter that corresponds to that hall, and the reservations are the numbers. Constraints
The halls will only be English alphabet letters.
Each hall’s letter will always be unique.
The integer n will be in the range [0, 500].
The reservations will always be valid integers in the range [0, 500]
 */
public class ClubParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = Integer.parseInt(scanner.nextLine());

        //getting the halls and reservations combined
        String[] entry = scanner.nextLine().split("\\s+");


        //getting the halls and people and putting them into Stack
        ArrayDeque<String> openHalls = new ArrayDeque<>();
        ArrayList<Integer> allGuests = new ArrayList<>();

        int current = 0;
        for (int i = entry.length - 1; i >= 0; i--) {
            String debugNow = entry[i];
            if (Character.isDigit(entry[i].charAt(0))) {
                if (current + Integer.parseInt(entry[i]) > limit) {
                    current = 0;
                    if (openHalls.isEmpty()) {
                        allGuests.clear();
                        continue;
                    }
                    System.out.print(openHalls.poll() + " -> ");
                    for (int j = 0; j < allGuests.size(); j++) {
                        if (j == allGuests.size() - 1) {
                            System.out.println(allGuests.get(j));
                        } else {
                            System.out.print(allGuests.get(j) + ", ");
                        }
                    }
                    allGuests.clear();
                    current += Integer.parseInt(entry[i]);
                    allGuests.add(Integer.parseInt(entry[i]));
                } else {
                    current += Integer.parseInt(entry[i]);
                    allGuests.add(Integer.parseInt(entry[i]));
                }
            } else {
                openHalls.offer(entry[i]);
            }
        }
    }
}
