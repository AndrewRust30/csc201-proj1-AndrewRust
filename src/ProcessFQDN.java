/**
 * This program finds the unique FQDNs and 2LDs in a file, the file
 * is a command line argument.
 *
 * Useage:
 *   java ProcessFQDN url.txt
 *
 * @author Nirre Pluf {@literal }
 * @version 0.2, Sept. 5, 2021
 */

import java.io.*;
import java.util.Scanner;


public class ProcessFQDN {

    /**
     * This is the main method
     * @param args command line arguments (1 file name)
     */
    public static void main(String[] args){

        if(!argsOK(args))
            System.exit(1);
        readNameFile(args[0]);
        displayNameInfo();
    }


    /**
     *  This method reads (and eventually stores) FQDN and 2LD in the fqdn file
     *
     *  @param  filename is the fqdn filename (command line argument)
     */
    static void readNameFile(String fileName){
        System.out.print("Processing " + fileName);

        // reading dictionary file
        try {
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNext()) {
                String line = input.nextLine();
                System.out.println("debug: " + line);
            }
            input.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error in opening " + fileName);
            System.exit(1);
        }
    }


    /**
     *  This method displays the stats and FQDN and 2LD found in the file
     *
     *  @param  the lists...
     */
    static void displayNameInfo() {
        System.out.println("displayName: stub");
    }


    /**
     *  This method returns true if the command line arguments are acceptable,
     *  1 file name (String) must exist in args
     *
     *  @param  args list of Strings (command line arguments)
     *  @return true if the arguments are acceptable, false otherwise
     */
    private static boolean argsOK(String[] args){
        if(args.length < 1) {
            System.out.println("Usage: java program URLfile1 URLfile2 ... ");
            return false;
        }
        return true;
    }

}
