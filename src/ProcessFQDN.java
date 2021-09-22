/**
 * This program finds the unique FQDNs and 2LDs in a file, the file
 * is a command line argument.
 *
 * Useage:
 *   java ProcessFQDN url.txt
 *
 * @author Andrew Rust {@rustac19@wfu.edu }
 * @version 0.1, Sept. 20, 2021
 */

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class ProcessFQDN {

    /**
     * This is the main method
     * @param args command line arguments (1 file name)
     */
    public static void main(String[] args) {

        if(!argsOK(args))
            System.exit(1);
        readNameFile(args[0]);
    }

    /**
     *  This method reads (and eventually stores) FQDN and 2LD in the fqdn file
     *
     *  @param  filename is the fqdn filename (command line argument)
     */
    static void readNameFile(String fileName){
        System.out.println("Processing " + fileName);

        // reading dictionary file
        try {
            Scanner input = new Scanner(new File(fileName));
            int uniqueFQDNs = 0; // counting integer for each tag of valid FQDNs
            int unique2LDs = 0;
            int uniqueTLDs = 0;
            int numFQDNs = 0;

            DLinkedList<String> listFQDN = new DLinkedList<>(); //DLinked list for each of the different fully qualified domain names
            DLinkedList<String> list2LDs = new DLinkedList<>();
            DLinkedList<String> listTLDs = new DLinkedList<>();
            while (input.hasNext()) {
                String line = input.nextLine();
                line = line.toLowerCase(); // convert all input lines to lowercase

                if (validateDomain(line)) { // calling validation method to check if its a legitimate domain
                    numFQDNs++; // adding to total number of legitimate domains
                    if (!(listFQDN.contains(line))) { // if it is not already inside the list of valid FQDNs, then add it
                        uniqueFQDNs++;
                        listFQDN.addFirst(line); // add to list of FQDNS
                        if (!list2LDs.contains(removeTopDomains(line))) { // break down into 2LDs and add to list if its not already in it
                            unique2LDs++; //add to number of 2LDs
                            list2LDs.addFirst(removeTopDomains(line));//add 2LD to list
                        }
                        if (!listTLDs.contains(removeLastDomain(line))) {// break down into TLDs and add to list if its not already in it
                            uniqueTLDs++; //add to number of TLDs
                            listTLDs.addFirst(removeLastDomain(line)); //add TLD to list
                        }
                    }
                }

            }
            input.close();
            // Print statements that meet desired formatting
            System.out.println("Found " + numFQDNs + " FQDNs, " + uniqueFQDNs + " unique FQDNs, " + unique2LDs + " unique 2LDs, "+ uniqueTLDs + " unique TLDs");
            displayNameInfo(listFQDN, list2LDs,listTLDs); // call method to print list of items
        }
        catch (FileNotFoundException e) {
            System.out.println("Error in opening " + fileName);
            System.exit(1);
        }

    }

    /**
     * Validating Domain Method
     * @param in is the String to be checked for validity
     * @return a boolean if it is valid or not
     */
    public static Boolean validateDomain(String in){
        Boolean result = null; // set intial result Boolean to null, depending on if any of the tests fail, this variable will be updated
        String[] subDomains = in.split("\\."); // split input into array of strings on every '.'
        for (String label : subDomains){ //if any one string exceed 63 chars, it fails
            if (label.length() > 63){
                result = false;
            }
        }
        if (subDomains.length <= 1){ // if there is only one element in the array, meaning that the input either has no period or it does not have elements on either side, it fails
            result = false;
        } else if (in.charAt(0) == '.') { // if it begins with a '.' it fails
            result = false;
        } else if (in.charAt(in.length() - 1) == '.'){ // if it ends with a '.' it fails
            result = false;
        } else if (in.length() > 253) { // if the entire list is too long, it fails
            result = false;
        } else { // if it passes all those tests, it passes as a valid FQDN
            result = true;
        }
        return result;
    }

    /**
     * Remove Top domains of valid FQDN, all but last two to create valid 2LD
     * @param in String to be chopped down into 2LD
     * @return returns valid 2LD as String
     */
    public static String removeTopDomains(String in){
        String[] subDomains = in.split("\\."); // create array to split into subdomains
        int length = subDomains.length; // integer for length
        String newDomain = subDomains[length-2] + "." + subDomains[length-1]; // creating valid 2LD from last two indicies in subdomain array
        return newDomain;
    }

    /**
     * Remove first of last two labels in valid 2LDs to create valid TLD
     * @param in String to be chopped down in valid TLD
     * @return returns valid 2LD as String
     */
    public static String removeLastDomain(String in){
        String[] subDomains = in.split("\\."); // create array to split into subdomains
        int length = subDomains.length; // integer for array length
        String newDomain = subDomains[length-1]; // creating valid TLD from last index in subdomain array
        return newDomain;
    }
    /**
     *  This method displays the stats and FQDN and 2LD found in the file
     *
     *  @param DLinkedLists for each of the three printable collections (FQDNs, 2LDs, and TLDs)
     */

    static void displayNameInfo(DLinkedList<String> FDDNs, DLinkedList<String> TwoLDs, DLinkedList<String> TLDs) {

        System.out.print("Unique FQDNs: "); // enhanced for loop to print out each array, print statements are used according to desired formatting of assignment
        for (String data: FDDNs){
            System.out.print(data + " ");
        }
        System.out.println();
        System.out.print("Unique 2LDs:  ");
        for (String data: TwoLDs){
            System.out.print(data + " ");
        }
        System.out.println();
        System.out.print("Unique TLDs:  ");
        for (String data: TLDs){
            System.out.print(data + " ");
        }
        System.out.println();
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
