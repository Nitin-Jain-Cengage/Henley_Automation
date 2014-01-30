package com.cengage.mtx.reports;

import javax.mail.PasswordAuthentication;

/**
 * The Class Authenticator.
 */
class Authenticator extends javax.mail.Authenticator {

	/** The authentication. */
	private PasswordAuthentication authentication;

	/**
	 * Instantiates a new authenticator.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public Authenticator(String username, String password) {
		authentication = new PasswordAuthentication(username, password);
	}


	protected PasswordAuthentication getPasswordAuthentication() {
		return authentication;
	}
}
