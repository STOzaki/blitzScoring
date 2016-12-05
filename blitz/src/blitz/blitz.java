/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blitz;

//import edu.princeton.cs.algs4.StdOut;
import java.lang.Exception;
import java.util.Scanner;
import java.util.LinkedList;

/**
 *
 * @author Salem
 */
public class blitz {

    int players = 0;
    Node start = new Node();
    boolean finished = true;
    LinkedList<String> total = new LinkedList<>();

    public blitz() {
//        while (finished) {
        start = new Node();
        players = 0;
        System.out.println("I hope you are ready to play Blitz. (I hope that is the name of this game)");
        Scanner base = new Scanner(System.in);
        System.out.println("");
        naming();
        round();
        String winner = whoWins();
        System.out.println(winner + " has won, congrats!  Now this is the real quetion... Would you like to play again, yes or no?");
        String answer = base.next();
        System.out.println("");
        if (answer.equals("no")) {
            System.out.println("Thank you for playing!");
//                break;
        }
//            System.out.println(players);
//        }
    }

    private String whoWins() {
        Node all = start;
        for (int i = players; i > 0; i--) {
            if (all.score >= 100) {
                return all.name;
            }
            all = all.next;
        }
        return "no one found, sorry";
    }

    private void round() {
        boolean done = true;
        while (done) {
            LinkedList<String> remain = new LinkedList<>();
            for (int i = 0; i < players; i++) {
                remain.add(total.get(i));
            }
            int left = players;
            System.out.println("Great!  As soon as you finish this round type the names and score of each player.");
            scoring(remain, left);
            done = winner();
            tooLow();
            scores();
        }
    }

    private void scoring(LinkedList<String> remain, int left) {
        while (left != 0) { // go through all of the players.
            Node people = start;
            System.out.println("");
            System.out.print("Out of these people: ");
            rollcall(remain, left);
            System.out.println("  Who got what score this round?");
            Scanner another = new Scanner(System.in);
            String name = another.nextLine();
            String player = name.toLowerCase();
            if ("score".equals(player)) {
                scores();
                scoring(remain, left);
                break;
            }

            try {
                while ((player.equals(people.name)) == false) { // go through the Nodes until you find the one you are looking for.
                    people = people.next;
                }
            } catch (Exception e) {
                System.out.println("");
                System.out.println("Sorry, but that person is not one of your players, please try again.");
                scoring(remain, left);
                break;
            }
            try {
                if ((remain.contains(player)) == false) {
                    System.out.println("Sorry, but you have already done this person.");
                    scoring(remain, left);
                }
                System.out.println("");
                System.out.println("What did " + people.name + " get this round?");
                Scanner number = new Scanner(System.in);
                int num = number.nextInt();
                people.score += num;
                left -= 1;
                remain.remove(player);
//                System.out.println(left);
            } catch (Exception e) {
                System.out.println("");
                System.out.println("Sorry, but that is not a score.");
                scoring(remain, left);
                break;
            }
        }
    }

    private void rollcall(LinkedList<String> remain, int left) {
        for (int j = 0; j < left; j++) {
            System.out.print(remain.get(j));
            if (j >= 0 && j < left - 1) {
                System.out.print(", ");
            } else if (j == left - 1) {
                System.out.print(".");
            }
        }
    }

    private void scores() {
        Node check;
        check = start;
        System.out.println("");
        System.out.println("This is the score for this round: ");
        System.out.println("");
        while (check.name != null) {
            System.out.println(check.name + " has " + check.score + " points.");
            System.out.println("");
            check = check.next;
        }
    }

    private void tooLow() {
        Node check;
        check = start;
        while (check.name != null) {
            if (check.score <= -50) {
                check.score = 0;
            }
            check = check.next;
        }
    }

    private boolean winner() {
        Node all = start;
        for (int i = players; i > 0; i--) {
            if (all.score >= 100) {
                return false;
            }
            all = all.next;
        }
        return true;
    }

    private void naming() {
        blitzFrame show = new blitzFrame();
        new blitzFrame().setVisible(true);
        Scanner base = new Scanner(System.in);
        System.out.println("Type as soon as you are done, except for stop (I think).");
        String stop = base.nextLine();
        total.getFirst();
        if(total.isEmpty()){
            naming();
        } else {
            System.out.println("we are almost there");
//        System.out.println("Just type in the names of your players and then type 'done' when you are done.");
//        while (true) {
//            String player = base.nextLine();
////            if (player.getClass() != String.class) {
//////                throw new Exception("\033[31m Sorry that is not the name of a player");
////            }
//            if ("done".equals(player)) {
//                break;
//            }
        LinkedList<String> test = new LinkedList<>();
        while (test.isEmpty() == false) {
            if (start.name == null) {
                start.name = test.getFirst();
                Node after = new Node();
                start.next = after;
                start.before = null;
                test.removeFirst();
//                total.add(player);
            } else {
                Node end = going();
                Node previous = bname();
                end.name = test.getFirst();
                end.before = previous;
                Node future = new Node();
                end.next = future;
                test.removeFirst();
//                total.add(player);
            }
            players += 1;
//            }
        }
        while (start.name != null) {
            System.out.println(start.name);
            start = start.next;
        }

        System.out.println("");
        }
    }

    private Node bname() {
        Node check = start;
        while (check.next.name != null) {
            check = check.next;
        }
        return check;
    }

    private Node going() {
        Node check;
        check = start.next;
        while (check.name != null) {
            check = check.next;
        }
        return check;

    }

    private class Node {

        String name;
        int score = 0;
        Node next;
        Node before;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        blitz test = new blitz();
//        System.out.println(test.start.score);

    }

}
