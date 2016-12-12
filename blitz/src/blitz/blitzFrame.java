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
        label2.setVisible(false);
        textBox2.setVisible(false);
        next.setVisible(true);
        next.setText("start");
//        another.setVisible(false);
//        while (finished) {
            begin = new Node();
//            players = 0;
            show.setText("I hope you are ready to play Blitz!");
            show2.setText("Type in your name(s) and press add. Once everyone is added, press start.");
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

    private LinkedList<String> whoWins() {
        LinkedList<String> winners = new LinkedList<>();
        int max = 0;
        Node all = begin;
        for (int i = total.size(); i > 0; i--) {
            if (all.score > max) {
//                System.out.println("Find the max " + all.score);
                winners.clear();
                winners.add(all.name);
                max = all.score;
            } else if(all.score == max) {
//                System.out.println("Find a match " + all.score);
                winners.add(all.name);
            }
            all = all.next;
        }
        return winners;
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
                                .addComponent(show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(show2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        addEvent();
    }//GEN-LAST:event_addMouseClicked

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        nextEvent();
    }//GEN-LAST:event_nextMouseClicked

    private void addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyPressed
        if(evt.getExtendedKeyCode() == 10){
            addEvent();
        }
    }//GEN-LAST:event_addKeyPressed

    private void nextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nextKeyPressed
        if(evt.getExtendedKeyCode() == 10){
            nextEvent();
        }
    }//GEN-LAST:event_nextKeyPressed

    private void addEvent(){
        if(answer){ // close out of game.
            dispose(); // destroy the game.
        } else if(save){
            reset.add(false);
            reset.add(false);
            newGame();
        } else if(added){
            reset.add(false);
            newGame();
        } else { // normally adding people.
            String player = textBox1.getText();
            if (player.equals("")) {
                show.setText("I am sorry, but that is a blank space.");
            } else {  // adding a new person.
                if (begin.name == null) {
                    begin.name = player;
                    Node after = new Node();
                    begin.next = after;
                    begin.before = null;
                    total.add(player);
//                    temptotal.add(player); // add to the temp as well.
                    show.setText(player + " has been added!");
                    people = people + player + ", "; // adds the first person to the list of people.
//                    tempplayer ++; // increment the amount of people.
                } else {
                    Node end = going(player);
                    if(duplicate == false){
                        Node previous = bname();
                        end.name = player;
                        end.before = previous;
                        Node future = new Node();
                        end.next = future;
                        total.add(player);
                        show.setText(player + " has been added!");
                        people = people + player + ", "; // Add the new person.
//                        tempplayer ++;
                    } else {
                        show.setText("I am sorry, " + player + " already exists.");
                        duplicate = false; // set the duplicate back
                    }
                }
                show2.setText(people); // set the all of the people.
            }
                textBox1.setText("");
        }
    }
    
    private void nextEvent(){
        if(starting){
            if(total.size() > 1){
                temp(); // setting the tempplayer and temptotal
                lobby();
                game();
                show.setText(""); // makes the text box empty.
                String peopleLeft = "Here are the players: ";
                temptotal.clear(); // clears the array to add new ones.
                for(int i = 0; i < tempplayer; i++){
                    temptotal.add(total.get(i)); // this will renew the temptotal!
                    if(i == tempplayer - 1){
                        peopleLeft = peopleLeft + total.get(i);
                    } else {
                        peopleLeft = peopleLeft + total.get(i) + ", ";
                    }
                }
                if(doDebug)System.out.println(remainder(true));
                peopleLeft = peopleLeft + ".";
                show2.setText(peopleLeft);
                starting = false; // will return next back to its original settings.
                next.setText("next"); // setting next back to next.
            } else {
                show.setText("Please add more players.");
                
            }
        } else {  // others
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
            } else { // regular scoring
                if(doDebug)System.out.println(total.size());
                if(temptotal.contains(textBox1.getText())){
                    String score = textBox2.getText(); // grabing the score
                    if(doDebug)System.out.println(score.length());
                    if(score.length() == 0){
                        show.setText("Sorry you have no score");
                    } else { // if the name exists and there is a score, then put thoese in
                        boolean integ = false;
                        try{ // checks to see if the Box2 is an int
                            Integer.parseInt(textBox2.getText());
                            integ = true;
                        } catch(Exception e) {
                            // since it failed, it will remain false.
                        }
                        if(integ == true){  // everything is correctly inputed.
                            // scores for that person's name.
                            addingScore(textBox1.getText(),Integer.parseInt(textBox2.getText()));
                            tempplayer --;
                            if(tempplayer == 0) { // ends the round.
                                boolean win = winner();
                                tooLow();
                                if(win == true){
                                    endGame();
                                } else {
                                    roundEnd();
                                    show2.setText("Players: " + remainder(false)); // telling the people who is playing for everyround.
                                }
                                
                            } else {
                                // grab textBox2 and find the Score
                                int scores = findScore(textBox1.getText());
                                show.setText(textBox1.getText() + " has got the new score of " + scores + ".");

                                // grabs the players names and displays it.
                                show2.setText(remainder(true));
                                
                                // clears the name textBox.
                                textBox1.setText("");
                            }
                        } else {
                            show.setText("Sorry that is not an integer.");
                        }
                    }
                } else if(box.length() == 0) {
                    show.setText("Name box is empty.");
                } else {
                    show.setText("The player either does not exist or has already been scored.");
//                    show.setText("The name either is not a player or you have already scored them for this round.");
                }
            }
        }
    }
    
    private void newGame(){
        if(reset.get(0) == false){ // if they do not want to save thier players.
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
        } else { // save players
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
        LinkedList<String> winner = whoWins();
//        System.out.println(winner.size());
        if(winner.size() > 1){
            int lenWinner = winner.size();
            String winners = "";
            while(lenWinner != 0){
                if(lenWinner == 1){
                    winners = winners + winner.get(lenWinner - 1) + " won with " + findScore(winner.get(lenWinner - 1)) + "!";
                } else if(lenWinner == 2) {
                    winners = winners + winner.get(lenWinner - 1) + ", and ";
                } else {
                    winners = winners + winner.get(lenWinner - 1) + ", ";
                }
                lenWinner --;
            }
            show.setText(winners);
        } else if(winner.size() == 1) { // only one winner.
            int score = findScore(winner.get(0)); // grabing the winner's score.
            show.setText(winner.get(0) + " has won with " + score + "!");
        } else {
            show.setText("No one has won the game!");
        }
        
        
        String list = "";
        for(int i = 0; i < total.size(); i++) {
            if(winner.contains(total.get(i))) {
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
        temptotal.clear(); // clears the temtotal
        tempplayer = total.size(); // set the length back to normal.
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
                    temptotal.remove(people.name);
                    break;
                }
            }
            people = people.next;
        }
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
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JButton next;
    private javax.swing.JLabel show;
    private javax.swing.JLabel show2;
    private javax.swing.JTextField textBox1;
    private javax.swing.JTextField textBox2;
    // End of variables declaration//GEN-END:variables
}
