In the SQueue file I created various methods to add to queue,
 remove from queue and getsize of queue, shuffle queue, clear queue, check if queue is full and queue is empty.

In the wargame file I implemented the queue and created a deck, shuffled that deck, dealt the deck, tested for whenever players run out of cards to break the loop.
I created a recyle loop that says when the player deck is empty and player has cards in their discard deck, that player deck will take the cards from discard.
I also determined that who won the round by using a diff variable.
In my code I use  a while loop that says while curr round is less max round.
max round was taken by user input and if input was not given, max round = base case.
diff = player 1 top card compared to player 2 top card
if diff > 0, player one won the round, if diff < 0, player 2 round and if diff = 0, then I made a boolean called tied = true.
Then I created a war loop that said while tied is true then execute.
Then I checked if players had cards in either deck. 
I also checked if player had no card in deck but had in recycle so the recycle loop would add the cards from discard to player deck.
so in general what I did in was say if tied is then run war. For war I had two war piles. so then from there 
I had the top cards from the original comparison.
I had flip which was the cards being compared by war.
I had down which is the card that was put down after the original comparison of the toop two cards.
so from there if the war diff > 0 player 1 won and war was resolved and if diff < 0 player 2 won and war was resolved.
if  war diff = 0, then loop would run until war was resolved. 
After round was over I would increment curr round to show that it is a new round
So the code went until either a player ran out of cards or max rounds reached.

My code ran according to the specifications and according to sample outputs and I did not have to alter anything to get the same output.


