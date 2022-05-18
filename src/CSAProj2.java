import java.util.Scanner;

public class CSAProj2 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        // establishes all variables for game
        int gameContinuation = 1, retryCounter = 3, userInput, userInputAttic;

        System.out.println("Welcome to the Escape Cornwells Hall Game!\nThe point of the game is quite simple, escape Cornwells Hall...");


        // loops while user enters one and has more than 0 retries
        while (retryCounter != 0 && gameContinuation == 1) {
            Thread.sleep(2000);
            System.out.println("\nYou have " + retryCounter + " tries left to play the game.");
            Thread.sleep(1000);
            System.out.print("\nIt's dark. The power is out and the you don't know where to look. \n\nTo look for a lightswitch, press 1, to walk forward press 2.\t");
            userInput = scan.nextInt();

            if (userInput == 1) { // towards lightswitch
                System.out.println("\nYou find a lightswitch and turn it on. However, you quickly find out that the switch electrocutes you.");
                System.out.println("\nYou die"); // ending #1 BAD

            } else { // walk forward
                System.out.print("\nYou find a wall. \n\nWould you like to walk to the left (1) or to the right (2)?\t");
                userInput = scan.nextInt();

                if (userInput == 2) { // goes right
                    System.out.println("You continue walking along side the wall and find a breaker. \n\nYou open the breaker and a few spiders crawl out.");
                    Thread.sleep(4000);

                    System.out.println("\nAll hope is not lost, however, because you find the main switch off and flip the button");
                    System.out.println("The lights come on and you realize that you are high above Cornwells Hall in the attic. Ahead in the distance you see the a set of stairs leading down.");
                    System.out.print("\nDo you (1) look around the attic or (2) head down the stairs.\t");
                    userInputAttic = scan.nextInt();

                    if (userInputAttic == 1) { // looks around attic and finds intel
                        Thread.sleep(1000);
                        System.out.println("You look around the attic rummaging through the vast and creepy storage. You find ancient scrolls describing the buildings and architecture. \nFurther rummaging reveals an article claiming of an evil wizard in the Cornwells locker room." +
                                " You keep this in the back of your mind.");
                    }

                    System.out.println("You continue down the stairwell.");
                    Thread.sleep(2000);
                    System.out.println("\nAfter exiting the staircase, you find yourself in Mr. Profy's class. Recognizing your location, you think about the quickest exit path.");
                    System.out.println("You decide to walk to the stairs outside his room and hed all the way down and exist through the door.");
                    Thread.sleep(5000);
                    System.out.println("\nWalking through his door, you come up on the stairs. \nQuickly you find out that the stairs are blocked, you decide that you must continue down the hallway.");
                    Thread.sleep(5000);
                    System.out.print("\nYou continue walking past Mr. Eckerle's room and come up on the chem labs. You hear an ominous panting sound coming from the staircase next to Ms. Conville's room.\n\nYou must make a decision. \nDo you (1) continue to the staircase behind " +
                            "Mrs. Hill's room or (2) head down the current staircase?\t");
                    userInput = scan.nextInt();

                    if (userInput == 1) { // hill staircase
                        System.out.println("\nYou continue past the chem labs and approach Mrs. Hill's room. \nYou find the door locked but pull so hard, the door comes flying off.");
                        System.out.println("\nYou continue through her classroom and out through the back room. You reach the bottom of the steps but the door to outside is locked and you can't get it to budge. \nYou continue through to the art room and past the side door " +
                                "entrance, all locked.");

                        // specifies text based on decision in attic
                        if (userInputAttic == 1) {
                            System.out.println("Knowing there to be an exit through the locker room storage closest, you hed to the locker room despite your knowledge of the wizard. \nAfter entering the locker room you spot the wizard.");
                            System.out.println("Underestimating its power, you attempt to get a quick punch at it. However, with nothing to defend yourself, you quickly loose the battle.");
                            System.out.println("\n\nYou die."); // ending #3 BAD

                        } else {
                            System.out.println("Knowing there to be an exit through the locker room storage closest, you hed to the locker room");
                            Thread.sleep(3000);
                            System.out.println("After entering the locker room you recognize a friendly-looking creature of in the distance. You approach it and attempt to make friends.");
                            System.out.println("Quickly recognizing your mistake, the friendly-looking creature turns around attacks you. With nothing to defend yourself, you quickly loose the battle.");
                            System.out.println("You die."); // ending #3 BAD
                        }

                    } else { // weird sound staircase
                        System.out.println("After heading down 1 level of stairs, you realize the stairs further down are blocked, you decide to turn right and head down the stairs next to Profe's room.");
                        Thread.sleep(3000);
                        System.out.println("All of a sudden Dr. Pollock's door swings open smacking you in the forehead. A massive bump quickly appears on your forehead.");
                        System.out.println("After regaining your train of thought, you head past his room and down the stairs. \nYou reach the bottom of the steps but the door to outside is locked and you can't get it to budge. So you head right from the bottom of the stairs " +
                                "towards Mrs. Busheks room.");
                        Thread.sleep(5000);
                        System.out.print("Passing her room, you notice Mrs. Bushek diligently working. \nDo you ask her to (1) treat your wound or (2) wait until you escape Cornwells Hall.");
                        userInput = scan.nextInt();

                        if (userInput == 2) { //avoids treatment
                            System.out.println("You continue past her room and head down the stairs next to the chapel. \nHowever, while heading down the stairs to the kitchen, your vision becomes cloudy and you fall down the stairs and pass out, breaking several bones and " +
                                    "suffering great internal bleeding.");
                            System.out.println("You quickly realize how much of a fool you were for not seeking Mrs. Bushek's help.");
                            Thread.sleep(2000);
                            System.out.println("\nYou die of your injuries."); // Ending #4 BAD

                        } else { // goes for treatment
                            System.out.println("Mrs. Bushek quickly patches you up and hands you a sword with no context. You accept her offer. \nYou then continue on your way down the stairs by the chapel and down the stairs to the kitchen");

                            /// specifies text based on decision in attic
                            if (userInputAttic == 1) {
                                Thread.sleep(5000);
                                System.out.println("You then hed up the ramp to the locker room. Knowing there to be an exit through the locker room storage closest, you hed to the locker room despite your knowledge of the wizard. After entering the locker room you spot the wizard.");
                                System.out.println("Realizing Mrs. Bushek gave you a sword, you are able to sneak up on the wizard and back stab it, killing it instantly.");
                                System.out.println("You go through the storage closet and exit through the spider ridden door.");
                                System.out.println("\n\nYou win the game!"); // Ending #1 GOOD

                            } else {
                                Thread.sleep(5000);
                                System.out.println("You then hed up the ramp to the locker room, knowing there to be an exit through the locker room storage closest.");
                                System.out.println("After entering the locker room you recognize a friendly-looking creature of in the distance. You approach it and attempt to make friends.");
                                Thread.sleep(2000);
                                System.out.println("\nQuickly recognizing your mistake, the friendly-looking creature turns around attacks you. Realizing that Mrs. Bushek gave you a sword, you back stab the wizard, killing it instantly.");
                                System.out.println("\n\nYou win the game!"); // Ending #1 GOOD

                            }
                        }
                    }
                } else {  // goes left
                    System.out.println("You find a staircase leading down. Do you (1) continue down the stairs or (2) head back and continue to the right?");
                    userInput = scan.nextInt();

                    if (userInput == 2) { // heads back to breaker
                        System.out.println("You continue walking along side the wall and find a breaker. \n\nYou open the breaker and a few spiders crawl out.");
                        Thread.sleep(4000);

                        System.out.println("\nAll hope is not lost, however, because you find the main switch off and flip the button");
                        System.out.println("The lights come on and you realize that you are high above Cornwells Hall in the attic. Ahead in the distance you see the a set of stairs leading down.");
                        System.out.print("\nDo you (1) look around the attic or (2) head down the stairs.\t");
                        userInputAttic = scan.nextInt();

                        if (userInputAttic == 1) { // looks around attic and finds intel
                            Thread.sleep(1000);
                            System.out.println("You look around the attic rummaging through the vast and creepy storage. You find ancient scrolls describing the buildings and architecture. \nFurther rummaging reveals an article claiming of an evil wizard in the Cornwells locker " +
                                    "room. You keep this in the back of your mind.");
                        }

                        System.out.println("You continue down the stairwell.");
                        Thread.sleep(2000);
                        System.out.println("\nAfter exiting the staircase, you find yourself in Mr. Profy's class. Recognizing your location, you think about the quickest exit path.");
                        System.out.println("You decide to walk to the stairs outside his room and hed all the way down and exist through the door.");
                        Thread.sleep(5000);
                        System.out.println("\nWalking through his door, you come up on the stairs. \nQuickly you find out that the stairs are blocked, you decide that you must continue down the hallway.");
                        Thread.sleep(5000);
                        System.out.print("\nYou continue walking past Mr. Eckerle's room and come up on the chem labs. You hear an ominous panting sound coming from the staircase next to Ms. Conville's room.\n\nYou must make a decision. \nDo you (1) continue to the staircase " +
                                "behind Mrs. Hill's room or (2) head down the current staircase?\t");
                        userInput = scan.nextInt();

                        if (userInput == 1) { // hill staircase
                            System.out.println("\nYou continue past the chem labs and approach Mrs. Hill's room. \nYou find the door locked but pull so hard, the door comes flying off.");
                            System.out.println("\nYou continue through her classroom and out through the back room. You reach the bottom of the steps but the door to outside is locked and you can't get it to budge. \nYou continue through to the art room and past the side door " +
                                    "entrance, all locked.");

                            // specifies text based on decision in attic
                            if (userInputAttic == 1) {
                                System.out.println("Knowing there to be an exit through the locker room storage closest, you hed to the locker room despite your knowledge of the wizard. \nAfter entering the locker room you spot the wizard.");
                                System.out.println("Underestimating its power, you attempt to get a quick punch at it. However, with nothing to defend yourself, you quickly loose the battle.");
                                System.out.println("\n\nYou die."); // ending #3 BAD

                            } else {
                                System.out.println("Knowing there to be an exit through the locker room storage closest, you hed to the locker room");
                                Thread.sleep(3000);
                                System.out.println("After entering the locker room you recognize a friendly-looking creature of in the distance. You approach it and attempt to make friends.");
                                System.out.println("Quickly recognizing your mistake, the friendly-looking creature turns around attacks you. With nothing to defend yourself, you quickly loose the battle.");
                                System.out.println("You die."); //ending #3 BAD
                            }

                        } else { // weird sound staircase
                            System.out.println("After heading down 1 level of stairs, you realize the stairs further down are blocked, you decide to turn right and head down the stairs next to Profe's room.");
                            Thread.sleep(3000);
                            System.out.println("All of a sudden Dr. Pollock's door swings open smacking you in the forehead. A massive bump quickly appears on your forehead.");
                            System.out.println("After regaining your train of thought, you head past his room and down the stairs. \nYou reach the bottom of the steps but the door to outside is locked and you can't get it to budge. So you head right from the bottom of the stairs " +
                                    "towards Mrs. Busheks room.");
                            Thread.sleep(5000);
                            System.out.print("Passing her room, you notice Mrs. Bushek diligently working. \nDo you ask her to (1) treat your wound or (2) wait until you escape Cornwells Hall.");
                            userInput = scan.nextInt();

                            if (userInput == 2) { // avoids treatment
                                System.out.println("You continue past her room and head down the stairs next to the chapel. \nHowever, while heading down the stairs to the kitchen, your vision becomes cloudy and you fall down the stairs and pass out, breaking several bones and " +
                                        "suffering great internal bleeding.");
                                System.out.println("You quickly realize how much of a fool you were for not seeking Mrs. Bushek's help.");
                                Thread.sleep(2000);
                                System.out.println("\nYou die of your injuries."); // ending #4 BAD

                            } else { // gets treatment
                                System.out.println("Mrs. Bushek quickly patches you up and hands you a sword with no context. You accept her offer. \nYou then continue on your way down the stairs by the chapel and down the stairs to the kitchen");

                                // specifies text based on decision in attic
                                if (userInputAttic == 1) {
                                    Thread.sleep(5000);
                                    System.out.println("You then hed up the ramp to the locker room. Knowing there to be an exit through the locker room storage closest, you hed to the locker room despite your knowledge of the wizard. After entering the locker room you spot the wizard.");
                                    System.out.println("Realizing Mrs. Bushek gave you a sword, you are able to sneak up on the wizard and back stab it, killing it instantly.");
                                    System.out.println("You go through the storage closet and exit through the spider ridden door.");
                                    System.out.println("\n\nYou win the game!"); // Ending #1 GOOD

                                } else {
                                    Thread.sleep(5000);
                                    System.out.println("You then hed up the ramp to the locker room, knowing there to be an exit through the locker room storage closest.");
                                    System.out.println("After entering the locker room you recognize a friendly-looking creature of in the distance. You approach it and attempt to make friends.");
                                    Thread.sleep(2000);
                                    System.out.println("\nQuickly recognizing your mistake, the friendly-looking creature turns around attacks you. Realizing that Mrs. Bushek gave you a sword, you back stab the wizard, killing it instantly.");
                                    System.out.println("\n\nYou win the game!"); // Ending #1 GOOD

                                }
                            }
                        }
                    } else { // continues down the stairs
                        System.out.println("After continuing down the stairs, you see movement. Suddenly a man who you make out to be Mr. Profy grabs you by the face scaring you so much that you have a heart attack.");
                        System.out.println("\n\nYou die."); //ending #2 BAD
                    }
                }
            }


            System.out.print("\nWould you like to play again? Yes (1), No (2)");
            gameContinuation = scan.nextInt();

            retryCounter--;

        }


        if (retryCounter == 0) { // no more tries
            System.out.println("You ran out of tries. Good luck next time!");

        } else { // if user is done
            System.out.println("Thanks for playing the game; I hope you play again.");
        }


    }

}
