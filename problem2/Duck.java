package HM4.problem2;

import java.util.Random;

public class Duck {
    /**
     * The Duck class represents a duck with specific eye and beak characteristics.
     * It supports various functionalities such as setting and getting the eye and beak,
     * managing friendships, checking similarity, and more.
     * Each Duck object can have a list of friends and interact with special Duck objects,
     * elderOracle and influencerStar.
     */
    private char eye;
    private char beak;
    private Duck[] friendList;
    private int numberOfFriends;
    private static Duck elderOracle;
    private static Duck influencerStar;


    /**
     * Gets the eye character of the duck.
     *
     * @return the eye character
     */
    public char getEye() {
        return eye;
    }

    /**
     * Gets the beak character of the duck.
     *
     * @return the beak character
     */
    public char getBeak() {
        return beak;
    }

    /**
     * Sets the eye character of the duck.
     *
     * @param eye the eye character to set
     */
    public void setEye(char eye) {
        this.eye = eye;
    }

    /**
     * Sets the beak character of the duck.
     *
     * @param beak the beak character to set
     */
    public void setBeak(char beak) {
        this.beak = beak;
    }

    /**
     * Gets the number of friends the duck has.
     *
     * @return the number of friends
     */
    public int getNumberOfFriends() {
        return numberOfFriends;
    }

    /**
     * Gets the elderOracle duck, which is the first Duck object ever created.
     *
     * @return the elderOracle Duck object
     */
    public static Duck getElderOracle() {
        return elderOracle;
    }

    /**
     * Gets the influencerStar duck, which is the Duck object with the highest number of friends.
     *
     * @return the influencerStar Duck object
     */
    public static Duck getInfluencerStar() {
        return influencerStar;
    }

    /**
     * Returns a string representation of the duck's head.
     *
     * @return a string representing the duck's head in the format "=(^)"
     */
    @Override
    public String toString() {
        return this.beak+ "(" + this.eye + ")";
    }

    /**
     * Gets the list of friends of the duck.
     *
     * @return an array of Duck objects representing the friends
     */
    public Duck[] getFriendList() {
        Duck[] actualFriends = new Duck[numberOfFriends];
        for (int i = 0; i < numberOfFriends; i++) {
            actualFriends[i] = friendList[i];
        }
        return actualFriends;
    }

    /**
     * Constructs a Duck object with specified eye and beak characters.
     *
     * @param eye  the eye character
     * @param beak the beak character
     */
    public Duck(char eye, char beak) {
        this.eye = eye;
        this.beak = beak;
        this.friendList = new Duck[100];
        this.numberOfFriends = 0;

        if (elderOracle == null) {
            elderOracle = this;
        }
        setInfluencerStar();
    }

    /**
     * Constructs a Duck object with random eye and beak characters.
     */
    public Duck() {
        Random random = new Random();
        this.eye = (char) ('a' + random.nextInt(26));
        this.beak = (char) ('a' + random.nextInt(26));
        this.friendList = new Duck[100];
        this.numberOfFriends = 0;

        if (elderOracle == null) {
            elderOracle = this;
        }
        setInfluencerStar();

    }

    /**
     * Constructs a Duck object by copying the eye and beak characters from another Duck object.
     *
     * @param other the Duck object to copy from
     */
    public Duck(Duck other) {
        this.eye = other.eye;
        this.beak = other.beak;
        this.friendList = new Duck[100];
        this.numberOfFriends = other.numberOfFriends;
        for (int i = 0; i < other.numberOfFriends; i++) {
            this.friendList[i] = other.friendList[i];
        }
        if (elderOracle == null) {
            elderOracle = this;
        }
        setInfluencerStar();
    }
    /**
     * Set the influencerStar duck to be the duck with the highest number of friends.
     * If the number is the same for more than one duck, the new one is considered cooler and replaces the old star.
     */
    private void setInfluencerStar() {
        if (influencerStar == null || this.numberOfFriends > influencerStar.numberOfFriends) {
            influencerStar = this;
        } else if (this.numberOfFriends == influencerStar.numberOfFriends && this != influencerStar) {
            influencerStar = this;
        }
    }

    /**
     * Befriends another duck. Adds the given duck to the friend list of both the calling duck and the argument duck.
     * If the friend list is maxed out, prints an error message and terminates the program.
     *
     * @param other the Duck object to befriend
     */
    public void befriend(Duck other) {
        if (this.numberOfFriends >= 100 || other.numberOfFriends >= 100) {
            System.err.println("Error: Friend list is maxed out");
            System.exit(1);
        }
        if (!this.isFriend(other)) {
            this.friendList[this.numberOfFriends++] = other;
            other.friendList[other.numberOfFriends++] = this;
        }
    }

    /**
     * Checks if a given duck is already in the friend list.
     *
     * @param other the Duck object to check
     * @return true if the given duck is already a friend, false otherwise
     */
    private boolean isFriend(Duck other) {
        for (int i = 0; i < this.numberOfFriends; i++) {
            if (this.friendList[i] == other) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if two ducks are similar based on their eye or beak characters.
     *
     * @param d1 the first Duck object
     * @param d2 the second Duck object
     * @return true if the ducks have the same type of beak or eyes, false otherwise
     */
    public static boolean isSimilar(Duck d1, Duck d2) {
        return d1.eye == d2.eye || d1.beak == d2.beak;
    }

    /**
     * Checks if the calling duck is similar to another duck by using the static isSimilar method.
     *
     * @param other the Duck object to compare with
     * @return true if the ducks have the same type of beak or eyes, false otherwise
     */
    public boolean isSimilar(Duck other) {
        return Duck.isSimilar(this, other);
    }

    /**
     * Checks if two ducks are identical based on their eye and beak characters.
     *
     * @param d1 the first Duck object
     * @param d2 the second Duck object
     * @return true if the ducks have the same type of beak and eyes, false otherwise
     */
    public static boolean isIdentical(Duck d1, Duck d2){
        return d1.eye == d2.eye && d1.beak == d2.beak;

    }
    /**
     * Checks if the calling duck is identical to another duck by using the static isIdentical method.
     *
     * @param other the Duck object to compare with
     * @return true if the ducks have the same type of beak and eyes, false otherwise
     */
    public boolean isIdentical(Duck other){
        return Duck.isIdentical(this, other);
    }
    /**
     * Returns a string representation of the ducks.
     * @param ducks the Duck objects array
     * @print a string representing the ducks "
     */
    public static void printDucks(Duck[] ducks){
        String result = "";
        int line = 0;
        int i = 0;
        while (line*10 + i<ducks.length){
            for(i = 0; i< (Math.min(10, ducks.length)); i++){
                result += ducks[i].toString();
                result += "____ ";
            }
            result += "\n";
            for(i = 0; i<(Math.min(10, ducks.length)); i++){
                result += "   \\___/ ";
            }
            line+=1;
            System.out.println('\n');

        }

        System.out.println(result);
    }

}
