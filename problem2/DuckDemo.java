package HM4.problem2;

public class DuckDemo {
    public static void main(String[] args) {
        Duck[] ducks = new Duck[5];
        for (int i = 0; i < ducks.length; i++) {
            ducks[i] = new Duck();
        }

        System.out.println("Randomized Ducks ");
        for (Duck duck : ducks) {
            System.out.println(duck);
        }

        ducks[0].befriend(ducks[1]);
        ducks[0].befriend(ducks[2]);
        ducks[1].befriend(ducks[3]);
        ducks[2].befriend(ducks[4]);

        System.out.println("\nFriends of Duck 0 ");
        for (Duck friend : ducks[0].getFriendList()) {
            System.out.println(friend);
        }
        Duck.printDucks(ducks[0].getFriendList());
        System.out.println("Number of friends Duck 0 has " + ducks[0].getNumberOfFriends());

        System.out.println("\nElder Oracle " + Duck.getElderOracle());
        System.out.println("Influencer Star " + Duck.getInfluencerStar());

        System.out.println("\nSimilarity Check ");
        System.out.println("Duck 0 is similar to Duck 1 " + ducks[0].isSimilar(ducks[1]));
        System.out.println("Duck 2 is similar to Duck 4  " + ducks[2].isSimilar(ducks[4]));
    }
}
