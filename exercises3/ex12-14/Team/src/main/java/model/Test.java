package model;

public class Test {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Team team = new Team();
        for(int i = 0; i < 50; i++) {
            team.addPlayer(new Player("player" + (i+1), i+1));
        }
        Player pasi = new Player("Pasi", 420);
        team.addPlayer(pasi);
        team.removePlayer(19);
        System.out.println(team.toString());
    }
}