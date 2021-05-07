package services;

import domain.Bug;
import domain.User;

public interface Service {

    /**
     * Method for finding a user by their username and password
     * @param username: String, the desired username
     * @param password: String, the desired password
     * @return
     *          - null, if there is no user with that {@code username} and {@code password}
     *          - the user, otherwise
     */
    User findUser(String username, String password);

    /**
     * Method for adding a bug
     * @param bug: Bug, the bug that wants to be added
     * @return
     *          - null, if {@code bug} is successfully saved
     *          - the bug, otherwise
     */
    Bug addBug(Bug bug);
}
