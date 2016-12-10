/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blitz;

/**
 *
 * @author Salem
 */
import java.awt.*;
import java.util.*;

public class blitzFrame extends javax.swing.JFrame {
    boolean doDebug = false;
    boolean lobby = true;
    boolean game = false;
    boolean duplicate = false;
    boolean complete = false;
    boolean answer = false;
    boolean save = false;
    boolean added = false;
    boolean starting = true;
    String people = "Players: ";
    LinkedList<Boolean> reset = new LinkedList<>();
    int tempplayer = 0;
    Node begin;
    boolean finished = true;
    LinkedList<String> temptotal = new LinkedList<>();
    LinkedList<String> total = new LinkedList<>();
//    boolean something = false;

    /**
     * Creates new form blitzFrame
     */
    public blitzFrame() {
        initComponents();
        detect.setVisible(false);
        label2.setVisible(false);
        textBox2.setVisible(false);
        next.setVisible(true);
        next.setText("start");
//        another.setVisible(false);
//        while (finished) {
            begin = new Node();
//            players = 0;
            System.out.println("I hope you are ready to play Blitz. (I hope that is the name of this game)");
//            Scanner base = new Scanner(System.in);
//            System.out.println("");
//            naming(base);
////            System.out.println(players);
//            round(base);
//            String winner = whoWins();
//            System.out.println(winner + " has won, congrats!  Now this is the real quetion... Would you like to play again, yes or no?");
//            String answer = base.next();
//            System.out.println("");
//            if (answer.equals("no")) {
//                System.out.println("Thank you for playing!");
//                break;
//            }
//        }
    }

    private String whoWins() {
        Node all = begin;
        for (int i = total.size(); i > 0; i--) {
            if (all.score >= 100) {
                return all.name;
            }
            all = all.next;
        }
        return "no one found, sorry";
    }

//    private void round(Scanner base) {
//        boolean done = true;
//        while (done) {
//            LinkedList<String> remain = new LinkedList<>();
//            for (int i = 0; i < players; i++) {
//                remain.add(total.get(i));
//            }
//            int left = players;
//            System.out.println("Great!  As soon as you finish this round type the names and score of each player.");
//            scoring(remain, base, left);
//            done = winner();
//            tooLow();
//            scores();
//        }
//    }

//    private void scoring(LinkedList<String> remain, Scanner base, int left) {
//        while (left != 0) { // go through all of the players.
//            Node people = begin;
//            System.out.println("");
//            System.out.print("Out of these people: ");
//            rollcall(remain, left);
//            System.out.println("  Who got what score this round?");
//            Scanner another = new Scanner(System.in);
//            String name = another.nextLine();
//            String player = name.toLowerCase();
//            if ("score".equals(player)) {
//                scores();
//                scoring(remain, base, left);
//                break;
//            }
//
//            try {
//                while ((player.equals(people.name)) == false) { // go through the Nodes until you find the one you are looking for.
//                    people = people.next;
//                }
//            } catch (Exception e) {
//                System.out.println("");
//                System.out.println("Sorry, but that person is not one of your players, please try again.");
//                scoring(remain, base, left);
//                break;
//            }
//            try {
//                if ((remain.contains(player)) == false) {
//                    System.out.println("Sorry, but you have already done this person.");
//                    scoring(remain, base, left);
//                }
//                System.out.println("");
//                System.out.println("What did " + people.name + " get this round?");
//                Scanner number = new Scanner(System.in);
//                int num = number.nextInt();
//                people.score += num;
//                left -= 1;
//                remain.remove(player);
////                System.out.println(left);
//            } catch (Exception e) {
//                System.out.println("");
//                System.out.println("Sorry, but that is not a score.");
//                scoring(remain, base, left);
//                break;
//            }
//        }
//    }

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
        check = begin;
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
        check = begin;
        while (check.name != null) {
            if (check.score <= -50) {
                check.score = 0;
            }
            check = check.next;
        }
    }

    private boolean winner() {
        Node all = begin;
        for (int i = total.size(); i > 0; i--) {
            if(doDebug)System.out.println(all.score);
            if (all.score >= 100) {
                return true;
            }
            all = all.next;
        }
        return false;
    }

//    private void naming(Scanner base) {
//        System.out.println("Just type in the names of your players and then type 'done' when you are done.");
//        while (true) {
//            String player = base.nextLine();
////            if (player.getClass() != String.class) {
//////                throw new Exception("\033[31m Sorry that is not the name of a player");
////            }
//            if ("done".equals(player)) {
//                break;
//            }
//
//            if (begin.name == null) {
//                begin.name = player;
//                Node after = new Node();
//                begin.next = after;
//                begin.before = null;
//                total.add(player);
//            } else {
//                Node end = going();
//                Node previous = bname();
//                end.name = player;
//                end.before = previous;
//                Node future = new Node();
//                end.next = future;
//                total.add(player);
//            }
//            players += 1;
//        }
//
//        System.out.println("");
//    }

    private Node bname() {
        Node check = begin;
        while (check.next.name != null) {
            check = check.next;
        }
        return check;
    }

    private Node going(String player) {
        if(begin.name.equals(player)){ // if the first one equals the same as the one you are trying to put in
            duplicate = true;
        }
        Node check;
        check = begin.next;
        while (check.name != null) {
            if(check.name.equals(player)){
                duplicate = true;
            }
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
    
    private void lobby(){
        if(lobby == true){
//            textBox1.setVisible(false);
//            label1.setVisible(false);
            add.setVisible(false);
            lobby = false;
        } else {
//            textBox1.setVisible(true);
//            label1.setVisible(true);
            add.setVisible(true);
            lobby = true;
        }
    }
    
    private void game(){
        if(game == true){
//            textBox1.setVisible(false);
            textBox2.setVisible(false);
//            label1.setVisible(false);
            label2.setVisible(false);
//            next.setVisible(false);
            game = false;
        } else {
////            System.out.println(x + "  " + y);
//            System.out.println(finish.getLocation().x);
//            System.out.println(finish.getLocation().y);
//            finish.setLocation(finish.getLocation().x - 10000, finish.getLocation().y - 10000);
            label2.setVisible(true);
//            System.out.println(label2.getLocationOnScreen().x);
//            System.out.println(label2.getLocationOnScreen().y);
//            textBox1.setVisible(true);
            textBox2.setVisible(true);
//            label1.setVisible(true);
//            next.setVisible(true);
            game = true;
        }
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new javax.swing.JLabel();
        textBox1 = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        show = new javax.swing.JLabel();
        textBox2 = new javax.swing.JTextField();
        next = new javax.swing.JButton();
        label2 = new javax.swing.JLabel();
        detect = new java.awt.List();
        show2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setText("Player's name");

        add.setText("add");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addKeyPressed(evt);
            }
        });

        show.setToolTipText("");

        next.setText("next");
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMouseClicked(evt);
            }
        });
        next.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nextKeyPressed(evt);
            }
        });

        label2.setText("score");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(detect, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1)
                    .addComponent(label2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(next)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(show2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(add)
                                .addGap(53, 53, 53)
                                .addComponent(show, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                        .addGap(379, 379, 379))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                            .addComponent(textBox2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(next)
                        .addComponent(add))
                    .addComponent(show, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(show2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        String player = textBox1.getText();
        if (player.equals("")) {
            show.setText("I am sorry, but that is a blank space.");
        } else {
            if (begin.name == null) {
                detect.add("Starting");
                begin.name = player;
                Node after = new Node();
                begin.next = after;
                begin.before = null;
                total.add(player);
            } else {
                Node end = going(player);
                detect.add("working");
                if(duplicate == false){
                    Node previous = bname();
                    end.name = player;
                    end.before = previous;
                    Node future = new Node();
                    end.next = future;
                    total.add(player);
                    detect.add("added");
                } else {
                    show.setText("I am sorry, " + player + " already exists.");
                }
            }
//            System.out.println(starter.getFirst());
            show.setText(player);
            
        }
            textBox1.setText("");
    }//GEN-LAST:event_addMouseClicked

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        String box = textBox1.getText();
        detect.add(box);
        if(box.length() > 0 && temptotal.contains(textBox1.getText())){
            String text = textBox2.getText(); // grabing the text
            if(doDebug)System.out.println(text.length());
            if(text.length() == 0){
                show.setText("Sorry you have no score");
            } else { // if the name exists and there is a score, then put thoese in
                addingScore(textBox1.getText(),Integer.parseInt(textBox2.getText())); // pluging the name and score
                show.setText(temptotal.get(tempplayer - 1));
                tempplayer --;
                remainder(true);
            }
        } else if(box.length() == 0) {
            show.setText("Name box is empty.");
        } else {
            show.setText("The name either is not a player or you have already scored them for this round.");
            
        }
//            System.out.println(tempplayer);
//            for(int i = 0; i < temptotal.size(); i++){
//                System.out.println(temptotal.get(i));
//            }
    }//GEN-LAST:event_nextMouseClicked

    private void addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyPressed
        if(answer){ // close out of game.
            dispose(); // destroy the game.
        } else if(save){
            reset.add(false);
            reset.add(false);
            newGame();
        } else if(added){
            reset.add(false);
            newGame();
        } else {
            String player = textBox1.getText();
            if (player.equals("")) {
                show.setText("I am sorry, but that is a blank space.");
            } else {
                if (begin.name == null) {
                    begin.name = player;
                    Node after = new Node();
                    begin.next = after;
                    begin.before = null;
                    total.add(player);
                    show.setText(player + " has been added!");
                    people = people + player + ", "; // adds the first person to the list of people.
                } else {
                    Node end = going(player);
                    if(duplicate == false){
                        Node previous = bname();
                        end.name = player;
                        end.before = previous;
                        Node future = new Node();
                        end.next = future;
                        total.add(player);
                        detect.add("added");
                        show.setText(player + " has been added!");
                        people = people + player + ", "; // Add the new person.
                    } else {
                        show.setText("I am sorry, " + player + " already exists.");
                        duplicate = false; // set the duplicate back
                    }
                }
                show2.setText(people); // set the all of the people.
            }
                textBox1.setText("");
        }
    }//GEN-LAST:event_addKeyPressed

    private void nextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nextKeyPressed
        if(starting){
            if(total.size() > 1){
                temp(); // setting the tempplayer and temptotal
                lobby();
                game();
                show.setText(""); // makes the text box empty.
                String peopleLeft = "Here are the players: ";
                for(int i = 0; i < tempplayer; i++){
                    if(i == tempplayer - 1){
                        peopleLeft = peopleLeft + temptotal.get(i);
                    } else {
                        peopleLeft = peopleLeft + temptotal.get(i) + ", ";
                    }
                }
                peopleLeft = peopleLeft + ".";
                show2.setText(peopleLeft);
                starting = false; // will return next back to its original settings.
                next.setText("next"); // setting next back to next
            } else {
                show.setText("Please add more players.");
                
            }
        } else {
            String box = textBox1.getText();
            if(complete){
                add.setVisible(true);
                add.setText("no");
                next.setText("yes");
                show.setText("Would you like to play again?");
                show2.setText("");
                answer = true;
                complete = false;
            } else if(answer){
                show.setText("Would you like to save the players?");
                show2.setText("");
                save = true;
                answer = false;
            } else if(save){
                show.setText("Would you like to add someone?");
                show2.setText("");
                added = true;
                save = false;
                reset.add(true);
            } else if(added) {
                reset.add(true);
                newGame();
            } else {
                if(doDebug)System.out.println(total.size());
                if(temptotal.contains(textBox1.getText())){
                    String text = textBox2.getText(); // grabing the text
                    if(doDebug)System.out.println(text.length());
                    if(text.length() == 0){
                        show.setText("Sorry you have no score");
                    } else { // if the name exists and there is a score, then put thoese in
                        boolean integ = false;
                        try{ // checks to see if the Box2 is an int
                            Integer.parseInt(textBox2.getText());
                            integ = true;
                        } catch(Exception e) {
                            // since it failed, it will remain false.
                        }
                        if(integ == true){
                            addingScore(textBox1.getText(),Integer.parseInt(textBox2.getText())); // pluging the name and score
                            tempplayer --;
                            if(tempplayer == 0){ // ends the round.
                                boolean win = winner();
                                tooLow();
                                if(win == true){
                                    endGame();
                                } else {
                                    roundEnd();
                                }
                            } else {
                                // grab textBox2 and find the Score
                                int scores = findScore(textBox1.getText());
                                show.setText(textBox1.getText() + " has got the new score of " + scores + ".");

                                // grabs the players names and displays it.
                                String remain = remainder(true);
                                show2.setText(remain);
                            }
                        } else {
                            show.setText("Sorry that is not an integer.");
                        }
                    }
                } else if(box.length() == 0) {
                    show.setText("Name box is empty.");
                } else {
                    show.setText("The name either is not a player or you have already scored them for this round.");
                }
            }
        }
    }//GEN-LAST:event_nextKeyPressed

    private void newGame(){
        if(reset.get(0) == false){ // if they want to save thier players.
            begin.next = null;
            begin.name = null;
            begin.score = 0;
            total.clear();
            temptotal.clear();
            tempplayer = 0;
            lobby = false;
            game = true;
            starting = true; // switches the next to the lobby menu.
            next.setText("start");
            people = "Players: ";
        } else { // dont save players
            Node t = begin;
            while(t.name != null){ // set everyone's score to 0.
                t.score = 0;
                t = t.next;
            }
            temp(); // setting the tempplayer and temptotal
            show.setText("Here are the players: " + remainder(false));
            if(reset.get(1)){ // add people
                lobby = false;
                game = true;
                starting = true; // switches the next to the lobby menu.
                next.setText("start");
            } else { // do not add people
                lobby = true;
                game = false;
                next.setText("next");
            }
        }
        textBox1.setText(""); // set the box to empty
        textBox2.setText(""); // set the box to empty
        add.setText("add");
        lobby();
        game();
        reset.clear(); // clear the decision made last time.
        
        //restart all decistions made from before
        complete = false;
        answer = false;
        save = false;
        added = false;
    }
    
    private void endGame(){
        String winner = whoWins();
        int score = findScore(winner);
        show.setText(winner + " has won with " + score + "!");
        String list = "";
        for(int i = 0; i < total.size(); i++){
            if(winner.equals(total.get(i))){
                if(doDebug)System.out.println("winner");
            } else {
                int myscore = findScore(total.get(i));
                if(i == total.size() - 1){
                    list = list + total.get(i) + " got " + myscore + ".";
                } else {
                    list = list + total.get(i) + " got " + myscore + ", ";
                }
            }
        }
        show2.setText(list);
        next.setText("Finish");
        complete = true;
    }
    private void roundEnd(){
//        System.out.println(total.size());
        temptotal.clear();
//        System.out.println(total.size());
        for(int i = 0; i < total.size(); i++){
            // put all of players in to the temp again
            temptotal.add(total.get(i));
        }
        if(doDebug)System.out.println(temptotal.size());
//        Node people = begin;
//        String round = "";
//        while(people.name != null){
//            round = round + people.name + " has " + people.score + " points, ";
//            people = people.next;
//            
//        }
//        show.setText(round);

         // grabs all player's names and their scores and then displays it.
        String roundScores = allScore();
        show.setText(roundScores);
        
        // makes a string that will contain all player's names
        String list = "";
        list = list + remainder(true);
        show2.setText(list);
        
        
        
    }
    
    private void temp(){
        tempplayer = total.size();
            for(int i = 0; i < total.size(); i++){ // makes a complete copy of temptotal
                temptotal.add(total.get(i));
            }
    }
    
    private void addingScore(String name, int score){
        Node people = begin;
        while(true){
            if(people.name == null){
                break;
            } else {
                if(people.name.equals(name)){
                    people.score = people.score + score;
                    detect.add("added score");
                    temptotal.remove(people.name);
                    break;
                }
            }
            people = people.next;
        }
        detect.add("moving on");
    }
    
    private String remainder(boolean extra){
        String list = "";
        if(extra){
            list = "Here are the people left: ";
        }
        for(int i = 0; i < tempplayer; i++){
            if(i == tempplayer - 1){
                list = list + temptotal.get(i);
            } else {
                list = list + temptotal.get(i) + ", ";
            }
        }
        list = list + ".";
        return list;
    }
    
    private String allScore(){
        String list = "";
        for(int i = 0; i < total.size(); i++){
            // find score for the name index i.
            int scores = findScore(total.get(i));
            
            if(i == total.size() - 1){
                list = list + total.get(i) + " has a score of " + scores;
            } else if(i == total.size() - 2){
                list = list + total.get(i) + " has a score of " + scores + ", and ";
            } else {
                /* this part could be optimized by sorting the begin nodes
                and having an directory that corresponds to each element in the
                hash nodes. */
                list = list + total.get(i) + " has a score of " + scores + ", ";
            }
        }
        list = list + " for this round.";
        return list;
    }
    
    private int findScore(String name){
        Node starting = begin;
        int scores = 0;
        while(starting.name != null){
            if(starting.name.equals(name)){
                scores = starting.score;
                break;
            }
            starting = starting.next;
        }
        return scores;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(blitzFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(blitzFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(blitzFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(blitzFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new blitzFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private java.awt.List detect;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JButton next;
    private javax.swing.JLabel show;
    private javax.swing.JLabel show2;
    private javax.swing.JTextField textBox1;
    private javax.swing.JTextField textBox2;
    // End of variables declaration//GEN-END:variables
}
