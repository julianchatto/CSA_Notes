import java.util.Arrays;
import java.util.Random;

public class CSAProj3 {
    public static void main(String[] args) {

        // Variables
        String[] river = new String[50];
        boolean riverGenerationTest = true;
        int simulationRunNumber = 1;

        while (riverGenerationTest) { // generates river
            // Variables
            int bearCount = 0;
            int fishCount = 0;

            for (int i = 0; i < river.length; i++) { //builds river
                Random bearOrFish = new Random();
                int bearOrFish2 = bearOrFish.nextInt(60) + 1;

                if (bearOrFish2 >= 55) {
                    river[i] = "BEAR";

                } else if (bearOrFish2 <= 15) {
                    river[i] = "FISH";
                } else {
                    river[i] = "";
                }
            }

            for (int i = 0; i < river.length; i++) { // counts number of fish and bears
                String organismPosition = river[i];
                if (organismPosition.equals("FISH")) {
                    fishCount++;

                } else if (organismPosition.equals("BEAR")) {
                    bearCount++;

                }
            }

            if (fishCount >= 2 && bearCount >= 2) { // checks if river has enough animals
                riverGenerationTest = false;
            }
        }
        System.out.println("Original River: " + Arrays.toString(river) + "\n");

        while (simulationRunNumber < 21) { // prints simulation 20x
            for (int i = 0; i < river.length; i++) { // loops through river positions
                if (river[i].equals("FISH")) {
                    Random movement = new Random();
                    int movement1 = movement.nextInt(3); //0,1,2
                    if (i == 0) { // if in position 0
                        if (movement1 == 1) { // moves right
                            if (river[i + 1].equals("BEAR")) { // bear kills fish
                                river[i] = "";
                                i++;
                            } else if (river[i + 1].equals("")) { // fish moves to empty cell
                                river[i + 1] = "FISH";
                                river[i] = "";
                                i++;
                            } else { // fish and fish mate
                                // Variables
                                int emptySetCounter = 0;
                                int bearCounter = 0;
                                int fishCounter = 0;

                                for (int j = 0; j < river.length; j++) { // checks if river has an empty spot
                                    if (river[j].equals("")) {
                                        emptySetCounter++;
                                    } else if (river[j].equals("BEAR")) {
                                        bearCounter++;
                                    } else {
                                        fishCounter++;
                                    }
                                }
                                if (emptySetCounter > 0) {
                                    //Variable
                                    boolean fishFish = true;

                                    while (fishFish) { // checks to see if new bear can move to position
                                        Random fishAndFish = new Random();
                                        int fishAndFish2 = fishAndFish.nextInt(50);
                                        if (river[fishAndFish2].equals("")) {
                                            river[fishAndFish2] = "FISH";
                                            fishFish = false;
                                        }
                                    }
                                } else if (bearCounter == 50) {
                                    System.out.println("The river is full of bears! A new bear cannot be born!");

                                } else if (fishCounter == 50) {
                                    System.out.println("The river is full of fish! A new fish cannot be born!");

                                } else {
                                    System.out.println("The river is full of fish and bears! A new animal cannot be born!");
                                }
                            }
                        }
                    } else if (i == 49) { // if in last position
                        if (movement1 == 0) { // moves left
                            if (river[i - 1].equals("BEAR")) { // bear kills fish
                                river[i] = "";
                            } else if (river[i - 1].equals("")) { // fish moves to empty cell
                                river[i - 1] = "FISH";
                                river[i] = "";
                            } else { // fish and fish mate
                                // Variables
                                int emptySetCounter = 0;
                                int bearCounter = 0;
                                int fishCounter = 0;

                                for (int j = 0; j < river.length; j++) { // checks if river has an empty spot
                                    if (river[j].equals("")) {
                                        emptySetCounter++;
                                    } else if (river[j].equals("BEAR")) {
                                        bearCounter++;
                                    } else {
                                        fishCounter++;
                                    }
                                }
                                if (emptySetCounter > 0) {
                                    //Variable
                                    boolean fishFish = true;

                                    while (fishFish) { // checks to see if new bear can move to position
                                        Random fishAndFish = new Random();
                                        int fishAndFish2 = fishAndFish.nextInt(50);
                                        if (river[fishAndFish2].equals("")) {
                                            river[fishAndFish2] = "FISH";
                                            fishFish = false;
                                        }
                                    }
                                } else if (bearCounter == 50) {
                                    System.out.println("The river is full of bears! A new bear cannot be born!");

                                } else if (fishCounter == 50) {
                                    System.out.println("The river is full of fish! A new fish cannot be born!");

                                } else {
                                    System.out.println("The river is full of fish and bears! A new animal cannot be born!");
                                }
                            }
                        }

                    } else { // all other positions
                        if (movement1 == 0) { // moves left

                            if (river[i - 1].equals("BEAR")) { // bear kills fish
                                river[i] = "";
                            } else if (river[i - 1].equals("")) { // fish moves to empty cell
                                river[i - 1] = "FISH";
                                river[i] = "";
                            } else { // fish and fish mate
                                // Variables
                                int emptySetCounter = 0;
                                int bearCounter = 0;
                                int fishCounter = 0;

                                for (int j = 0; j < river.length; j++) { // checks if river has an empty spot
                                    if (river[j].equals("")) {
                                        emptySetCounter++;
                                    } else if (river[j].equals("BEAR")) {
                                        bearCounter++;
                                    } else {
                                        fishCounter++;
                                    }
                                }
                                if (emptySetCounter > 0) {
                                    //Variable
                                    boolean fishFish = true;

                                    while (fishFish) { // checks to see if new bear can move to position
                                        Random fishAndFish = new Random();
                                        int fishAndFish2 = fishAndFish.nextInt(50);
                                        if (river[fishAndFish2].equals("")) {
                                            river[fishAndFish2] = "FISH";
                                            fishFish = false;
                                        }
                                    }
                                } else if (bearCounter == 50) {
                                    System.out.println("The river is full of bears! A new bear cannot be born!");

                                } else if (fishCounter == 50) {
                                    System.out.println("The river is full of fish! A new fish cannot be born!");

                                } else {
                                    System.out.println("The river is full of fish and bears! A new animal cannot be born!");
                                }
                            }

                        } else if (movement1 == 1) { // moves right
                            if (river[i + 1].equals("BEAR")) { // bear kills fish
                                river[i] = "";
                                i++;
                            } else if (river[i + 1].equals("")) { // fish moves to empty cell
                                river[i + 1] = "FISH";
                                river[i] = "";
                                i++;
                            } else { // fish and fish mate
                                // Variables
                                int emptySetCounter = 0;
                                int bearCounter = 0;
                                int fishCounter = 0;

                                for (int j = 0; j < river.length; j++) { // checks if river has an empty spot
                                    if (river[j].equals("")) {
                                        emptySetCounter++;
                                    } else if (river[j].equals("BEAR")) {
                                        bearCounter++;
                                    } else {
                                        fishCounter++;
                                    }
                                }
                                if (emptySetCounter > 0) {
                                    //Variable
                                    boolean fishFish = true;

                                    while (fishFish) { // checks to see if new bear can move to position
                                        Random fishAndFish = new Random();
                                        int fishAndFish2 = fishAndFish.nextInt(50);
                                        if (river[fishAndFish2].equals("")) {
                                            river[fishAndFish2] = "FISH";
                                            fishFish = false;
                                        }
                                    }
                                } else if (bearCounter == 50) {
                                    System.out.println("The river is full of bears! A new bear cannot be born!");

                                } else if (fishCounter == 50) {
                                    System.out.println("The river is full of fish! A new fish cannot be born!");

                                } else {
                                    System.out.println("The river is full of fish and bears! A new animal cannot be born!");
                                }
                            }
                        }
                    }
                } else if (river[i].equals("BEAR")) {
                    Random movement = new Random();
                    int movement1 = movement.nextInt(3); //0,1,2

                    if (i == 0) { // if in position 0
                        if (movement1 == 1) { // moves right
                            if (river[i + 1].equals("")) { // bear moves to empty cell
                                river[i] = "";
                                river[i + 1] = "BEAR";
                                i++;
                            } else if (river[i + 1].equals("FISH")) { // bear kills fish
                                river[i + 1] = "BEAR";
                                river[i] = "";
                                i++;
                            } else { // bear and bear mate
                                // Variables
                                int emptySetCounter = 0;
                                int bearCounter = 0;
                                int fishCounter = 0;

                                for (int j = 0; j < river.length; j++) { // checks if river has an empty spot
                                    if (river[j].equals("")) {
                                        emptySetCounter++;
                                    } else if (river[j].equals("BEAR")) {
                                        bearCounter++;
                                    } else {
                                        fishCounter++;
                                    }
                                }
                                if (emptySetCounter > 0) {
                                    //Variable
                                    boolean bearBear = true;

                                    while (bearBear) { // checks to see if new bear can move to position
                                        Random bearAndBear = new Random();
                                        int bearAndBear2 = bearAndBear.nextInt(50);
                                        if (river[bearAndBear2].equals("")) {
                                            river[bearAndBear2] = "BEAR";
                                            bearBear = false;
                                        }
                                    }
                                } else if (bearCounter == 50) {
                                    System.out.println("The river is full of bears! A new bear cannot be born!");

                                } else if (fishCounter == 50) {
                                    System.out.println("The river is full of fish! A new fish cannot be born!");

                                } else {
                                    System.out.println("The river is full of fish and bears! A new animal cannot be born!");
                                }
                            }
                        }

                    } else if (i == 49) { // if in last position
                        if (movement1 == 0) { // moves left
                            if (river[i - 1].equals("")) { // bear moves to empty cell
                                river[i] = "";
                                river[i - 1] = "BEAR";
                            } else if (river[i - 1].equals("FISH")) { // bear kills fish
                                river[i - 1] = "BEAR";
                                river[i] = "";
                            } else { // bear and bear mate
                                // Variables
                                int emptySetCounter = 0;
                                int bearCounter = 0;
                                int fishCounter = 0;

                                for (int j = 0; j < river.length; j++) { // checks if river has an empty spot
                                    if (river[j].equals("")) {
                                        emptySetCounter++;
                                    } else if (river[j].equals("BEAR")) {
                                        bearCounter++;
                                    } else {
                                        fishCounter++;
                                    }
                                }
                                if (emptySetCounter > 0) {
                                    //Variable
                                    boolean bearBear = true;

                                    while (bearBear) { // checks to see if new bear can move to position
                                        Random bearAndBear = new Random();
                                        int bearAndBear2 = bearAndBear.nextInt(50);
                                        if (river[bearAndBear2].equals("")) {
                                            river[bearAndBear2] = "BEAR";
                                            bearBear = false;
                                        }
                                    }
                                } else if (bearCounter == 50) {
                                    System.out.println("The river is full of bears! A new bear cannot be born!");

                                } else if (fishCounter == 50) {
                                    System.out.println("The river is full of fish! A new fish cannot be born!");

                                } else {
                                    System.out.println("The river is full of fish and bears! A new animal cannot be born!");
                                }
                            }
                        }
                    } else { // all other positions
                        if (movement1 == 0) { // moves left
                            if (river[i - 1].equals("")) { // bear moves to empty cell
                                river[i] = "";
                                river[i - 1] = "BEAR";
                            } else if (river[i - 1].equals("FISH")) { // bear kills fish
                                river[i - 1] = "BEAR";
                                river[i] = "";
                            } else { // bear and bear mate
                                // Variables
                                int emptySetCounter = 0;
                                int bearCounter = 0;
                                int fishCounter = 0;

                                for (int j = 0; j < river.length; j++) { // checks if river has an empty spot
                                    if (river[j].equals("")) {
                                        emptySetCounter++;
                                    } else if (river[j].equals("BEAR")) {
                                        bearCounter++;
                                    } else {
                                        fishCounter++;
                                    }
                                }
                                if (emptySetCounter > 0) {
                                    //Variable
                                    boolean bearBear = true;

                                    while (bearBear) { // checks to see if new bear can move to position
                                        Random bearAndBear = new Random();
                                        int bearAndBear2 = bearAndBear.nextInt(50);
                                        if (river[bearAndBear2].equals("")) {
                                            river[bearAndBear2] = "BEAR";
                                            bearBear = false;
                                        }
                                    }
                                } else if (bearCounter == 50) {
                                    System.out.println("The river is full of bears! A new bear cannot be born!");

                                } else if (fishCounter == 50) {
                                    System.out.println("The river is full of fish! A new fish cannot be born!");

                                } else {
                                    System.out.println("The river is full of fish and bears! A new animal cannot be born!");
                                }
                            }

                        } else if (movement1 == 1) { // moves right
                            if (river[i + 1].equals("")) { // bear moves to empty cell
                                river[i] = "";
                                river[i + 1] = "BEAR";
                                i++;
                            } else if (river[i + 1].equals("FISH")) { // bear kills fish
                                river[i + 1] = "BEAR";
                                river[i] = "";
                                i++;
                            } else { // bear and bear mate
                                // Variables
                                int emptySetCounter = 0;
                                int bearCounter = 0;
                                int fishCounter = 0;

                                for (int j = 0; j < river.length; j++) { // checks if river has an empty spot
                                    if (river[j].equals("")) {
                                        emptySetCounter++;
                                    } else if (river[j].equals("BEAR")) {
                                        bearCounter++;
                                    } else {
                                        fishCounter++;
                                    }
                                }
                                if (emptySetCounter > 0) {
                                    //Variable
                                    boolean bearBear = true;

                                    while (bearBear) { // checks to see if new bear can move to position
                                        Random bearAndBear = new Random();
                                        int bearAndBear2 = bearAndBear.nextInt(50);
                                        if (river[bearAndBear2].equals("")) {
                                            river[bearAndBear2] = "BEAR";
                                            bearBear = false;
                                        }
                                    }
                                } else if (bearCounter == 50) {
                                    System.out.println("The river is full of bears! A new bear cannot be born!");

                                } else if (fishCounter == 50) {
                                    System.out.println("The river is full of fish! A new fish cannot be born!");

                                } else {
                                    System.out.println("The river is full of fish and bears! A new animal cannot be born!");
                                }
                            }
                        }
                    }
                }

            }
            System.out.println("Run " + simulationRunNumber + ": " + Arrays.toString(river) + "\n");
            simulationRunNumber++;
        }
    }
}

