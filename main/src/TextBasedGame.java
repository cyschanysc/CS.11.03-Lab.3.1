import java.util.Scanner;

public class TextBasedGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        startGame(scanner);
    }

    public static void startGame(Scanner scanner) {
        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("You find yourself in a mysterious cave...");
        System.out.println("Choose your actions wisely to survive!");

        boolean gameOver = false;
        int playerHealth = 100;
        int monsterHealth = 100;

        while (!gameOver) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1. Explore the cave");
            System.out.println("2. Fight the monster");
            System.out.println("3. Exit the game");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You explore the cave and find a hidden treasure!");
                    System.out.println("Congratulations! You win!");
                    gameOver = true;
                    break;
                case 2:
                    System.out.println("You encounter a fierce monster!");
                    while (playerHealth > 0 && monsterHealth > 0) {
                        System.out.println("Choose your attack:");
                        System.out.println("1. Sword Attack");
                        System.out.println("2. Magic Spell");
                        System.out.println("3. Run away");

                        int attackChoice = scanner.nextInt();

                        switch (attackChoice) {
                            case 1:
                                int damage = calculateDamage(20);
                                monsterHealth -= damage;
                                System.out.println("You attack the monster with your sword and deal " + damage + " damage.");
                                break;
                            case 2:
                                int spellDamage = calculateDamage(30);
                                monsterHealth -= spellDamage;
                                System.out.println("You cast a powerful spell and deal " + spellDamage + " damage.");
                                break;
                            case 3:
                                System.out.println("You run away from the monster... coward!");
                                gameOver = true;
                                break;
                            default:
                                System.out.println("Invalid choice! Try again.");
                                break;
                        }

                        if (monsterHealth > 0) {
                            int monsterAttack = calculateDamage(15);
                            playerHealth -= monsterAttack;
                            System.out.println("The monster attacks you and deals " + monsterAttack + " damage.");

                            if (playerHealth <= 0) {
                                System.out.println("You have been defeated by the monster. Game over!");
                                gameOver = true;
                            }
                        } else {
                            System.out.println("Congratulations! You defeated the monster and won the game!");
                            gameOver = true;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Thank you for playing! Goodbye!");
                    gameOver = true;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
                    break;
            }
        }
    }

    public static int calculateDamage(int baseDamage) {
        double damageMultiplier = Math.random() * 0.5 + 0.75;
        return (int) (baseDamage * damageMultiplier);
    }
}