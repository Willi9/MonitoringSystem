/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitoringsystem;

/**
 *
 * @author willi
 */
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;


public class MonitoringSystem{
    
    //Making a method that that reads the animal file and outputs the right information
    public static void AnimalCase() {
        Scanner scr = new Scanner(System.in);
        
        //animal menu
        System.out.println("Choose an animal to monitor");
        System.out.println("Press 1 for Lion");
        System.out.println("Press 2 for Tiger");
        System.out.println("Press 3 for Bear");
        System.out.println("Press 4 for Giraffe");
        
        int option = Integer.parseInt(scr.nextLine());
        System.out.println();
        
        //Making the variable animal the choice of the user
	String animal = "";
	if (option == 1)
            animal = "Animal - Lion";
        else if (option == 2)
            animal = "Animal - Tiger";
        else if (option == 3)
            animal = "Animal - Bear";
        else if (option == 4)
            animal = "Animal - Giraffe";
	
	
	File file = new File("animals.txt");
        
        //opening the animal txt file
        try{
             /*change the file path that is displayed in the new Scanner(new File()) statement
            to the approriate file path located in the users computer 
            for Mac visit http://osxdaily.com/2015/11/05/copy-file-path-name-text-mac-os-x-finder/
            for Windoes visit https://www.pcworld.com/article/251406/windows_tips_copy_a_file_path_show_or_hide_extensions.html
            */
             
            Scanner inFile = new Scanner(file);
            //searching the file to locate the animal 
            while(inFile.hasNextLine()){
                if(animal.equals(inFile.nextLine()))
                    break;
                     }
            
            //reading the remaining details 
                     
            String name = inFile.nextLine();
            String age = inFile.nextLine();
            String health = inFile.nextLine();
            String feed = inFile.nextLine();
            inFile.close();
                     
            //printing the information and checking if there are any concerns
                     
            if(health.contains("*****")){
                System.out.println(animal);
                System.out.println(name);
                System.out.println(age);
                JOptionPane.showMessageDialog(null,health, "Warning :" + animal,
                    JOptionPane.INFORMATION_MESSAGE);
                System.out.println(feed);
                 }
                     
           
            else if (feed.contains("*****")){
                System.out.println(animal);
                System.out.println(name);
                System.out.println(age);
                System.out.println(health);
                JOptionPane.showMessageDialog(null, feed, "Warning :" + animal,
                    JOptionPane.INFORMATION_MESSAGE);
                     }
            
            else {
                System.out.println(animal);
                System.out.println(name);
                System.out.println(age);
                System.out.println(health);
                System.out.println(feed);
                     }
            
            System.out.println();
                     
                   
                 }
                 
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
                 }                 
    }
    
    
    //The method HabitatCase will read the file and out put the correct the information
    public static void HabitatCase() {
        //Habitat main menu
        Scanner scr = new Scanner(System.in);
        
        System.out.println("Choose what habitat you would like to monitor");
        System.out.println("Press 1 for the Penguin Habitat");
        System.out.println("Press 2 for the Bird house");
        System.out.println("Press 3 for the Aquarium");
                 
        int optionH = Integer.parseInt(scr.nextLine());
                 
        //naming our variable habitat
        String habitat= "";
                 
        if (optionH == 1)
            habitat = "Habitat - Penguin";
        else if (optionH == 2)
            habitat = "Habitat - Bird";
        else if (optionH == 3)
            habitat = "Habitat - Aquarium";
                 
        //reading the file
        try{
            //Insert the habitat file 
            
            /*change the file path that is displayed in the new Scanner(new File()) statement
            to the approriate file path located in the users computer 
            for Mac visit http://osxdaily.com/2015/11/05/copy-file-path-name-text-mac-os-x-finder/
            for Windoes visit https://www.pcworld.com/article/251406/windows_tips_copy_a_file_path_show_or_hide_extensions.html
            */
            
        	File file = new File("habitats.txt");
        	
            Scanner inFile = new Scanner(file);
                     
            //looking for all the right information
            while(inFile.hasNextLine()){
            if(habitat.equals(inFile.nextLine()))
                break;
            }
            //reading the rest of the correct data of the file
            String temperature = inFile.nextLine ();
            String food = inFile.nextLine();
            String cleanliness = inFile.nextLine();
             
            //Outputting all the correct data and checking for any concerns
            if (temperature.contains("*****")){
            System.out.println(habitat);
            JOptionPane.showMessageDialog(null, temperature, "Warning:" + habitat,
                JOptionPane.INFORMATION_MESSAGE);
            System.out.println(food);
            System.out.println(cleanliness);
            System.out.println();
            }
                     
            else if(food.contains("*****")){
                System.out.println(habitat);
                System.out.println(temperature);
                JOptionPane.showMessageDialog(null, food, "Warning:" + habitat,
                    JOptionPane.INFORMATION_MESSAGE);
                System.out.println(cleanliness);
                System.out.println();
                }
            
            else if(cleanliness.contains("*****")){
                System.out.println(habitat);
                System.out.println(temperature);
                System.out.println(food);
                JOptionPane.showMessageDialog(null, cleanliness, "Warning:" + habitat,
                    JOptionPane.INFORMATION_MESSAGE);
                System.out.println();
                }
            
            else{
                System.out.println(habitat);
                System.out.println(temperature);
                System.out.println(food);
                System.out.println(cleanliness);
                System.out.println();
                     }
                         
                 }
                 
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    //The main code that runs everything
    public static void main(String[] args){
        Scanner scr = new Scanner(System.in);
        
        while(true){
         //The main menu
         System.out.println("Welcome to the Zoo Monitoring System");
         System.out.println("Press 1 to monitor animals");
         System.out.println("Press 2 to monitor habitats");
         System.out.println("Press 3 to Exit");
         int choice = Integer.parseInt(scr.nextLine());
         System.out.println();
         
         
         //The Switch statements that allow to monitor what the user wants
         switch(choice){
             //Animal method
             case 1: 
                 AnimalCase();
                 break;
                  
             //Habitat method    
             case 2:
                 HabitatCase();
                 break; 
                 
             case 3:
              System.exit(0);                             
         }
        }
    }
}