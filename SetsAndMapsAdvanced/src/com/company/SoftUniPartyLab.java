package com.company;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

/*
There is a party in SoftUni. Many guests are invited, and they are two types: VIP and regular.  When guest comes, you
have to check if he/she exist in any of two reservation lists.
All reservation numbers will be with 8 chars.
All VIP numbers start with digit.
There will be 2 command lines. First is "PARTY" - party is on and guests start coming. Second is "END" - then party is
over, and no more guest will come.
Output shows all guests, who didn't come to the party (VIP must be first).

 */
public class SoftUniPartyLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        TreeSet<String> vipInvitations = new TreeSet<>();
        TreeSet<String> regularInvitations = new TreeSet<>();


        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vipInvitations.add(input);
            } else {
                regularInvitations.add(input);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        int skipped = vipInvitations.size() + regularInvitations.size();

        while (!input.equals("END")) {
            if (Character.isDigit(input.charAt(0))) {
                vipInvitations.remove(input);
                skipped--;
            } else {
                regularInvitations.remove(input);
                skipped--;
            }

            input = scanner.nextLine();
        }

        System.out.println(skipped);
        for (String guest : vipInvitations) {
            System.out.println(guest);
        }
        for (String guest : regularInvitations) {
            System.out.println(guest);
        }
    }
}
