package PW_3;

import java.util.Optional;
/**
 * Main class demonstrating the usage of UserRepository.
 * Shows examples of handling Optional:
 * Using orElseGet to provide a default user.
 * Using orElseThrow to throw an exception.
 */
public class UserRepositoryMain {
    /**
     * Entry point of the application.
     * Demonstrates how to retrieve users and handle missing users with Optional.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        // Find a user with a specific email
        Optional<User> optionalUser1 = userRepository.findByEmail("someaddress@gmail.com");
        User user1 = optionalUser1.orElseGet(() -> new User("undefined"));
        System.out.println("User: " + user1.getName());

        // Find a user with another email
        Optional<User> optionalUser2 = userRepository.findByEmail("otheraddress@gmail.com");
        try {
            User user2 = optionalUser2.orElseThrow(() -> new RuntimeException("no user found"));
            System.out.println("User: " + user2.getName());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
