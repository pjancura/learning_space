# sort the 13 cards (assign numeric values for face cards) from a deck of cards
#  in order from least to greatest
# each card can only be seen one at a time 
# the card must be placed somewhere in the original hand so that all cards are in order by the end 


def card_sort(cards):
    # run times was included for avoid an infinite loop while debugging
    run_times = 0
    # counter is used as a index
    counter = 0
    # counts if cards are in correct position
    checked = 0
    # used to turn off the while loop
    sorting = True
    # the loop for sorting the cards
    while (sorting):
        # gets the card that is on top of the deck
        new_card = cards.pop(counter)
        #  used for debugging
        print(new_card)
        #  checks if card is in correct position
        if new_card != counter + 1:
            # inserts card in correct spot
            cards.insert(new_card - 1, new_card)
            #  increases counter
            counter += 1
            # prints whenever a change to the card order has been made
            print(cards)
        else:
            # reinserts the card at the same position if it is in correct position
            cards.insert(new_card - 1, new_card)
            # increases counter
            counter += 1
            # counts the number of cards in the correct position
            checked += 1
            # checks if the counter has made it through the entire deck with cards in correct order 
            if checked == len(cards):
                # ends the while loop
                sorting = False
                continue
        # checks if the counter has reached the last index
        if counter == len(cards):
            # resets counter and checked
            counter = 0
            checked = 0
        # increments run_times
        run_times += 1
        # breaks the loop incase of infinite loop
        if run_times == 200:
            break
    print("run_times:", run_times)
    # returns sorted list
    return cards


cards_arr = [2, 5, 1, 7, 4, 3, 8, 13, 11, 10, 9 ,12, 6]

print(card_sort(cards_arr))