package com.coderscampus.assignment3.main;

import java.util.Scanner;

import com.coderscampus.assignment3.util.User;
import com.coderscampus.assignment3.util.UserService;

public class Assignment3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		UserService userService = new UserService();
		User[] users = userService.getUsersFromFile();
		System.out.println("Enter your email: \n");
		String username = scanner.nextLine();
		System.out.println("Enter your password: \n");
		String password = scanner.nextLine();

		int attempts = 0;

		while (attempts < 5) {
			attempts++;

			User user = userService.validateUser(users, username, password);
			if (user != null) {
				System.out.println("Welcome: " + user.getName());
				break;

			} else if (attempts > 4) {
				System.out.println("Too many failed login attempts, you are now logged out.");
			}   

			else {
				System.out.println("Invalid login, please try again \n");
				System.out.println("Enter your email: \n");
                username = scanner.nextLine();
                System.out.println("Enter your password: \n");
                password = scanner.nextLine();
			}

		}
	}
}
