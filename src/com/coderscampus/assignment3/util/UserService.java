package com.coderscampus.assignment3.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserService {
	
	
	
	
	
	public User createUser(String[] userInput) {
		User user = new User();
		user.setUsername(userInput[0]);
		user.setPassword(userInput[1]);
		user.setName(userInput[2]);
		return user;
		
		
		
		
		
		}
	
	public User[] getUsersFromFile() {
		BufferedReader fileReader = null;
        User[] users = new User[4];
		UserService userServices = new UserService();
		int i = 0;

		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));

			String line = ",";
			while ((line = fileReader.readLine()) != null) {

				String[] data = line.split(",");
				User user = userServices.createUser(data);
				users[i] = user;
				i = i + 1;
				
				
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	
	public User validateUser(User[] users, String username, String password) {
		for (User user : users) {
        	if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
        		
        		return user;
        	} 
        	
        		
        	
        }
		return null;
	}


	
	}


