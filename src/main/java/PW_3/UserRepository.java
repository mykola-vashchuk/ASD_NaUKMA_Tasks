package PW_3;

import java.util.Optional;

/**
 * Repository for managing users.
 * Provides methods to find users by email.
 */
public class UserRepository {

    /**
     * Finds a user by their email address.
     *
     * @param email the email of the user
     * @return an Optional containing the user if found,
     *         or an empty Optional if no user with the given email exists
     */
    public Optional<User> findByEmail(String email) {
        if ("someaddress@gmail.com".equals(email)) {
            User user = new User("some name");
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}
