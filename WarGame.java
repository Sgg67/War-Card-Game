package ass1;

import java.io.*;
import java.util.*; 


public class WarGame {
     public static void main(String[] args){

          System.out.println("Welcome to the game of war");

          int maxRound;
             if(args.length == 1){
                maxRound = Integer.parseInt(args[0]);
             }
             else{
               maxRound = 1000;
             }
         // intialize new deck
     SQueue<Card> deck  = new SQueue<>(53);

     // intialize two player decks
     SQueue<Card> player1Hand = new SQueue<>(53);
     SQueue<Card> player2Hand = new SQueue<>(53);

     // intialize two player discard decks
     SQueue<Card> player1Discard = new SQueue<>(53);
     SQueue<Card> player2Discard = new SQueue<>(53);

     // intialize two player war decks
     SQueue<Card> warPile1 = new SQueue<>(30);
     SQueue<Card> warPile2 = new SQueue<>(30);
  
    // declaring a tied variable to check if there is a war
     Boolean tied = false;
     
     // create cards and add them to deck
          for( Card.Suits suit: Card.Suits.values()){
               for(Card.Ranks rank: Card.Ranks.values()){

                    Card card = new Card(suit, rank);
                  deck.enqueue(card);
          }     
          }
              // shuffle deck
               deck.shuffle();

         // dealing cards to both players
           System.out.print("Now dealing cards to the players");
           for(int i = 0; i < 26; i++){
                    player1Hand.enqueue(deck.dequeue());
                    player2Hand.enqueue(deck.dequeue());
           }
          //printing player 1 deck
          System.out.println("Player 1's Deck:");
          System.out.println(player1Hand.toString() + " " + "\n");
          //printing player 2 deck 
          System.out.println("Player 2's Deck:");
          System.out.println(player2Hand.toString() + " " + "\n");
          // printing wargame starts
          System.out.println("Starting the game of war!");
          // printing max rounds
          System.out.println("Max number of rounds = " + maxRound);
          // intializing current round to 0
             int currRound = 0;
         // creating a while loop with the condition while current round is less than max round    
             while(currRound < maxRound){
         // if player 1 is out of cards print player 1 is out of cards and break loop
               if(player1Hand.isEmpty() && player1Discard.isEmpty()){
                    System.out.println(" Player 1 is out of cards");
                    break;
               }
         // if player 2 is out of cards print player 2 is out of cards and break the loop
                 if(player2Hand.isEmpty() && player2Discard.isEmpty()){
                    System.out.println(" Player 2 is out of cards");
                    break;
               }
                  
               // if player 1 deck is empty shuffle discard and recycle it to main deck
                  if(player1Hand.isEmpty() && !player1Discard.isEmpty()){
              System.out.println("Getting and shuffling the pile for Player 1"); 
               player1Discard.shuffle();
               while(!player1Discard.isEmpty()){
               player1Hand.enqueue(player1Discard.dequeue());
               }
          }

             // if player 2 deck is empty shuffle discard and recycle it to main deck
             if(player2Hand.isEmpty() && !player2Discard.isEmpty()){
               System.out.println("Getting and shuffling the pile for Player 2");
               player2Discard.shuffle();
               while(!player2Discard.isEmpty()){
               player2Hand.enqueue(player2Discard.dequeue());
             }
          }
            // create a top card for each player that is the top of each player deck
               Card player1Top = player1Hand.dequeue();
               Card player2Top = player2Hand.dequeue();
            // diff = player 1 top card compared to player 2 top of card
               int diff = player1Top.compareTo(player2Top);
           // if diff > 0 player 1 wins and takes both top cards
                 if(diff > 0){
                    System.out.println(" Round " + currRound + " Player 1 wins: " + player1Top.toString() + " beats " + player2Top.toString());
                    player1Discard.enqueue(player1Top);
                    player1Discard.enqueue(player2Top);
               }
          // if diff < 0 player 2 wins and takes both cards
                 if( diff < 0){
                    System.out.println(" Round " + currRound + " Player 2 wins: " + player1Top.toString() + " loses to " + player2Top.toString());
                    player2Discard.enqueue(player1Top);
                    player2Discard.enqueue(player2Top);
               }
          // if diff = 0 set tied to true
               if(diff == 0){
                    tied = true;
               }
          // if tied is true war is activated     
                if(tied == true){
                    // prints facedown for the down card
                    System.out.println( " face down ");
                    // sets a card called tie for each player which is their top card
                    Card  tie1 = player1Top;
                    Card  tie2 = player2Top;
                    // if player 1 is out of cards print player 1 is out of cards and break loop
                    if(player1Hand.isEmpty() && player1Discard.isEmpty()){
                         System.out.println(" Player 1 is out of cards");
                         break;
                    }
                    // if player 2 is out of cards print player 2 is out of cards and break loop
                     if(player2Hand.isEmpty() && player2Discard.isEmpty()){
                         System.out.println(" Player 2 is out of cards");
                         break;
                    }
                    // if player one has no cards shuffle discard deck and recycle to player deck
                       if(player1Hand.isEmpty() && !player1Discard.isEmpty()){
              System.out.println(" Getting and shuffling the pile for Player 1 "); 
               player1Discard.shuffle();
               while(!player1Discard.isEmpty()){
               player1Hand.enqueue(player1Discard.dequeue());
               }
          }

             // if player 2 deck is empty shuffle discard deck and recycle it to player deck
             if(player2Hand.isEmpty() && !player2Discard.isEmpty()){
               System.out.println(" Getting and shuffling the pile for Player 2 ");
               player2Discard.shuffle();
               while(!player2Discard.isEmpty()){
               player2Hand.enqueue(player2Discard.dequeue());
             }
          }
            // creates loop that takes two cards from players and places them in each players war pile
             for(int i = 0; i < 2; i++){
               // if player 1 is out of cards print player one has no cards and break loop
                  if(player1Hand.isEmpty() && player1Discard.isEmpty()){
                         System.out.println(" Player 1 is out of cards");
                         break;
                    }
               // if player 2 is out of cards print player two has no cards and break loop.
                     if(player2Hand.isEmpty() && player2Discard.isEmpty()){
                         System.out.println(" Player 2 is out of cards");
                         break;
                    }
               // if player 1 deck is empty shuffle discard and recycle it to main deck
                       if(player1Hand.isEmpty() && !player1Discard.isEmpty()){
              System.out.println("Getting and shuffling the pile for Player 1"); 
               player1Discard.shuffle();
               while(!player1Discard.isEmpty()){
               player1Hand.enqueue(player1Discard.dequeue());
               }
          }

             // if player 2 deck is empty shuffle discard and recycle it to main deck
             if(player2Hand.isEmpty() && !player2Discard.isEmpty()){
               System.out.println("Getting and shuffling the pile for Player 2");
               player2Discard.shuffle();
               while(!player2Discard.isEmpty()){
               player2Hand.enqueue(player2Discard.dequeue());
             }
          }
           // takes card from player decks and puts them in the two player war piles
            warPile1.enqueue(player1Hand.dequeue());
            warPile2.enqueue(player2Hand.dequeue());
             }
             // creates the down cards
             Card down1 = warPile1.dequeue();
             Card down2 = warPile2.dequeue();
             // creates flip cards
             Card flip1 = warPile1.dequeue();
             Card flip2 = warPile2.dequeue();
             // compares the two flipped cards
             int warDiff = flip1.compareTo(flip2);
             // if diff > 0 player 1 wins war and takes all the war cards and we set tied to false to denote war has been resolved
             if(warDiff > 0){
               player1Discard.enqueue(tie1);
               player1Discard.enqueue(tie2);
               player1Discard.enqueue(down1);
               player1Discard.enqueue(down2);
               player1Discard.enqueue(flip1);
               player1Discard.enqueue(flip2);
               tied = false;
             }
             // if diff < 0 player two wins war and takes all the war cards and we set tied to false to denote war has been resolved
             else if(warDiff < 0){
               player2Discard.enqueue(tie1);
               player2Discard.enqueue(tie2);
               player2Discard.enqueue(down1);
               player2Discard.enqueue(down2);
               player2Discard.enqueue(flip1);
               player2Discard.enqueue(flip2);
               tied = false;
             }
           // otherwise war has not been resolved and the loop countinues
             else{
               tied = true;

             }
          }

             // increment current round 
             currRound++;
             // if curr rounnd = max round game ends and winner is determmined on who has more cards
             if(currRound == maxRound){
               int PL1 = player1Hand.getSize() + player1Discard.getSize();
               int PL2 = player2Hand.getSize() + player2Discard.getSize();
              System.out.println(" After " + maxRound + " rounds here are the results: ");
          System.out.println(" Player 1: " +  + PL1 + " Cards " );
          System.out.println(" Player 2: " + PL2 + " Cards ");
             }
          }
          // calculate how many cards the players are left with
          int Player1 = player1Hand.getSize() + player1Discard.getSize();
          int Player2 = player2Hand.getSize() + player2Discard.getSize();
          // calculate result by doing player 1 number of cards - player 2 number of cards
          int result = Player1 - Player2;
          // if result > 0 player 1 wins
          if(result > 0){
               System.out.println(" Player 1 wins!");
          }
          // if result < 0 player two wins
          else if(result < 0){
               System.out.println(" Player 2 wins! ");
          }
          // otherwise the game is a tie
          else{
               System.out.println(" The game is a tie ");
          }
          
     

     }
}
     
            
     

               
  
         
       
  
          
        
     
        
     

     


     
     
     
  
     