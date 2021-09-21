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
import java.util.Scanner;
import java.util.regex.*;

public class ProcessFQDN {

    /**
     * This is the main method
     * @param args command line arguments (1 file name)
     */
    public static void main(String[] args) {

        if(!argsOK(args))
            System.exit(1);
        readNameFile(args[0]);


        //for (String : test.iterator().hasNext())
        //{ System.out.println("value" + test);} ;
    }
    /**
     *  This method reads (and eventually stores) FQDN and 2LD in the fqdn file
     *
     *  @param  filename is the fqdn filename (command line argument)
     */
    static void readNameFile(String fileName){
        System.out.println("Processing " + fileName);
        // reading dictionary file
        int fullyQDN = 0;// integer of the number of fully qualified domain names
        DLinkedList<String> FQDNList = new DLinkedList<String>(); //DLinked list for each of the different fully qualified domain names
        DLinkedList<String> TwoLDList = new DLinkedList<String>();
        DLinkedList<String> TLDList = new DLinkedList<String>();

        DLinkedList<String> list = new DLinkedList<String>(); //Added DLinkedList object called 'list' to store values of the input file

        try {
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNext()) {
                String line = input.nextLine();
                System.out.println("debug: " + line);
                list.addFirst(line);// populate 'list' DLinkedList array
                }
            input.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error in opening " + fileName);
            System.exit(1);
        }
        int totalFQNS = 0;
        int uniqueFQDNs = 0;
        int TwoLDs = 0;
        int TLDs = 0;
        String regexFQDN = "^([A-Za-z]{1, 63}\\.)+[A-Za-z]{1, 63}\\.)+[A-Za-z]{1, 63}$";
        String regex2DL = "^([A-Za-z]{1, 63}\\.)+[A-Za-z]{1, 63}$";
        for (String domainName : list){

            if ((domainName.contains("."))){
                domainName.split()
            } else if ()
                domainName
        }

        for (String string : list)
            System.out.println(string);
    }
    public void analyseFile(){

    }

    /**
     *  This method displays the stats and FQDN and 2LD found in the file
     *
     *  @param DLinkedLists for each of the three printable collections (FQDNs, 2LDs, and TLDs)
     */
    static void displayNameInfo(DLinkedList FDDNs, DLinkedList TwoLDs, DLinkedList TLDs) {

        System.out.print("Unique FQDNs: ");
        for (Object string: FDDNs){
            System.out.print(FDDNs.iterator().next() + " ");
        }
        System.out.print("Unique 2LDs:  ");
        for (Object string: TwoLDs){
            System.out.print(TwoLDs.iterator().next() + " ");
        }
        System.out.print("Unique TLDs:  ");
        for (Object string: TLDs){
            System.out.print(TLDs.iterator().next() + " ");
        }
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
/* DEAD Code
    /**
     * Method using regular expression in java to check if domain name is legitimate or matches the given criteria
     * @param domain is the domain name given from the DLinkedList object 'list'
     * @return int

    static int domainValidation(String domain){
        String regex2DL = "^([A-Za-z]{1,63}\\.)+[A-Za-z]{1,63}$"; // regular expression for 2LDs
        Pattern pattern2DL = Pattern.compile(regex2DL);
        Matcher check2Dl = pattern2DL.matcher(domain);

        String regexFQDN = "^([A-Za-z]{1,63}\\.)+[A-Za-z]{1,63}\\.)+[A-Za-z]{1,63}$"; // regular expression for FQDN
        Pattern patternFQDN = Pattern.compile(regexFQDN);
        Matcher checkFQDN = patternFQDN.matcher(domain);

        if (checkFQDN.matches()){
            return 2;
        } else if (check2Dl.matches()){
            return 1;
        } else{
            return 0;
        }
    }
*/
}
