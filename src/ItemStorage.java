import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;


public class ItemStorage {
    public static void main(String[] args) {
        //Welcome to an Item Storage RPG simulator
        //You will simulate a character gaining and using items
        //as they progress through a video game

        System.out.println("Your Character's Item Storage");

        Character c1 = new Character("HGP Student");
        boolean stillPlaying = true;


        while(stillPlaying) {
            int userInput = World.giveUserOptions();
            if (userInput == 1) {
                //Get Item
                String itemName = World.getItemName();
                c1.addItem(itemName);

            } else if (userInput == 2) {
                //Use Item
                System.out.println(c1.getInventory());
                String itemName = World.getItemToUse(c1);
                c1.useItem(itemName);

            } else if (userInput == 3) {
                //TODO: Check Inventory: list all inventory items
                System.out.println(c1.getInventory());

            } else if (userInput == 4) {
                //Drop Item
                String itemName = World.getItemToUse(c1);
                c1.dropItem(itemName);

            } else if (userInput == 5) {
                //Save for Later
                World.saveForLater(c1);

            } else if (userInput == 6) {
                //Load previous character
                World.loadCharacter(c1);

            } else {
                //End simulation
                break;
            }
        }
        System.out.println("Thanks for playing.");
    }
}

class Character {
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private String name;
    private int health;
    private int magic;
    private int attackPower;
    private int magicPower;
    private int relaxation;
    private int smell;

    Character(String n) {
        this.name = n;
        this.health = 100;
        this.magic = 40;
        this.attackPower = 10;
        this.magicPower = 15;
        this.relaxation = 30;
        this.smell = 0;
        this.inventory.add(new Item("Potion", 2));
        this.inventory.add(new Item("AttackUp", 1));
    }

    //Write the following helper methods
    public void addItem(String iName) {
        //TODO: Take in Item Name and add it to inventory
        boolean inBag = false;

        // see if Item already exists
        for (Item i : inventory) {
            if (i.getName().equals(iName)) {
                i.changeCount(1);
                inBag = true;
                break;
            }
        }

        // if-else exists
        if (!inBag) {
            inventory.add(new Item(iName,1));
        }
    }

    public void useItem(String iName) {
        //Based on the name of your item, use it accordingly
        //on your character. Then remove it from the inventory
        if (iName.equals("Potion")) {
            //Use Potion
            this.health += 20;
            if (this.health > 100) {
                this.health = 100;
            }
            System.out.println("Used item to boost health to: " + this.health);
            //TODO: Remove potion from Inventory
            dropItem(iName);

        } else if (iName.equals("AttackUp")) {
            //TODO: Use AttackUp item
            this.attackPower += 50;

            //TODO: Remove AttackUp item from inventory
            dropItem(iName);
        } else if (iName.equals("Weed")) {
            this.relaxation += 20;
            dropItem(iName);
        } else if (iName.equals("Poop")) {
            this.smell += 75;
            dropItem(iName);
        }
        //TODO: add another item ability here; else if()
    }

    public void dropItem (String iName) {
        //TODO: Drop item method
        for (Item i : inventory) {
            if (i.getName().equals(iName)) {
                if (i.getCount() == 1) {
                    inventory.remove(i);
                } else {
                    i.changeCount(-1);
                }
                break;
            }
        }
    }
    //The following methods are already finished for you

    private boolean isItemAvailable(Item item1) {
        //This method is finished for you already
        for (Item i: inventory) {
            if (item1.equals(i)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }
}

class Item {
    private String name;
    private int count;

    Item(String n, int c) {
        this.name = n;
        this.count = c;
    }

    int getCount() {
        return count;
    }

    void changeCount(int change) {
        this.count += change;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    boolean equals(Item i) {
        if (i.getName().equals(this.name)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.name + ": " + this.count;
    }
}

class World {
    World() {

    }

    static void saveForLater(Character c1) {
        //TODO: Create save file for game
        try {
            File myFile= new File("save.txt");
            if (myFile.createNewFile()) {
                System.out.println("File Created: " + myFile.getName());
            } else {
                System.out.println("Saved game!");
            }

            // Wrtie to File

            FileWriter fw = new FileWriter("save.txt");
            for (Item i : c1.getInventory()) {
                fw.write(i.getName());
                fw.write("\n");
                fw.write(String.valueOf(i.getCount()));
                fw.write("\n");
            }
            fw.close();

        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }

    static void loadCharacter(Character c1) {
        //TODO: Load previous character

        c1.getInventory().clear(); // Delete all inventory

        // Open the save file
        try {
            File myObj = new File("save.txt");
            Scanner myReader = new Scanner(myObj);
            // loop through the file
            while (myReader.hasNextLine()) {
                String item1;
                int ItemCount1;
                // For every 2 lines of the file, save to self inventory ITEM objects
                String data = myReader.nextLine();
                item1 = data; // "Potion"
                data = myReader.nextLine();
                ItemCount1 = Integer.parseInt(data);
                //c1.addToInventory(item1, ItemCount1);
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        // For every 2 lines of the file, save to self inventory ITEM objects
    }


    static int giveUserOptions() {
        Scanner scanForInput = new Scanner(System.in);

        System.out.println("======= Choose something for your character to do: ======= ");
        System.out.println("1. Gain an item");
        System.out.println("2. Use an item");
        System.out.println("3. Check Inventory");
        System.out.println("4. Drop Item");
        System.out.println("5. Save Inventory For Later");
        System.out.println("6. Load Previous Character");
        System.out.println("7. Quit Simulation");
        System.out.println("Type a number and hit the ENTER key.");

        int userInput = scanForInput.nextInt();
        boolean validIn = true;
        if (userInput > 7 || userInput < 1) {
            validIn = false;
        }
        while (!validIn) {
            System.out.println("You need to pick a valid option, try again.");
            userInput = scanForInput.nextInt();
            if (userInput <= 7 && userInput >= 1) {
                validIn = true;
            }
        }
        return userInput;
    }

    static String getItemName() {
        Scanner scanItemIn = new Scanner(System.in);
        System.out.println("Type an item name below and hit ENTER.");
        String userItemIn = scanItemIn.nextLine();

        return userItemIn;
    }

    static String getItemToUse(Character c) {
        Scanner scanItemIn = new Scanner(System.in);
        System.out.println("Type an item name below and hit ENTER.");
        String userItemIn = scanItemIn.nextLine();

        boolean valid = false;
        ArrayList<Item> myInv = c.getInventory();

        for (int i=0; i < myInv.size(); i++) {
            // checks if the Item already exists in inventory! if not, make the user try again
            if (myInv.get(i).getName().equals(userItemIn)) {
                valid = true;
                break;
            }
        }

        while(!valid) {
            System.out.println("That item does not exist. Try typing again.");
            userItemIn = scanItemIn.nextLine();

            for (int i=0; i < myInv.size(); i++) {
                if (myInv.get(i).getName().equals(userItemIn)) {
                    valid = true;
                    break;
                }
            }
        }

        return userItemIn;
    }
}
