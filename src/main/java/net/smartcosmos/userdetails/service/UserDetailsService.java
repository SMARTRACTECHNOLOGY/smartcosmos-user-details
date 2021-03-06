package net.smartcosmos.userdetails.service;

import org.springframework.security.core.AuthenticationException;

import net.smartcosmos.userdetails.domain.UserDetails;

/**
 * Interface for User Details Service implementations.
 */
public interface UserDetailsService {

    /**
     * Gets the User Details for a provided user.
     *
     * @param username the user name
     * @param password the password
     * @return the User Details
     * @throws IllegalArgumentException if {@code username} or {@code password} are {@code null} or empty
     * @throws AuthenticationException  if something goes wrong and the details can't be returned, e.g., the user does not exist or the credentials
     *                                  are incorrect
     */
    UserDetails getUserDetails(String username, String password) throws IllegalArgumentException, AuthenticationException;

    /**
     * Gets the user details without a password, which is necessary to support refresh tokens.
     *
     * @param username the user name
     * @return the User Details
     * @throws IllegalArgumentException f {@code username} is {@code null} or empty
     * @throws AuthenticationException  if something goes wrong and the details can't be returned, e.g., the user does not exist or the credentials
     *                                  are incorrect
     */
    UserDetails getUserDetails(String username) throws IllegalArgumentException, AuthenticationException;

    /**
     * Verifies that the User Details don't violate any constraints, i.e. it contains all required fields.
     *
     * @param userDetails the User Details.
     * @return {@code true} if the User Details are valid, {@code false} otherwise
     */
    boolean isValid(UserDetails userDetails);
}
