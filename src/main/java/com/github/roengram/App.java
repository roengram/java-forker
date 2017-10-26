package com.github.roengram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		int mem = Integer.parseInt(args[0]);
		int maxfork = Integer.parseInt(args[1]);
		int intv = Integer.parseInt(args[2]);
		String cmd = args[3];
        char[] buf = new char [mem*1024*1024];
        try {
			for (int i=0 ; i<maxfork ; i++) {
				Process p = Runtime.getRuntime().exec(cmd);
				System.out.printf("\"%s\" process %d is created\n", cmd, i);
				p.waitFor();
				Thread.sleep(intv);
			}
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted while waiting for child process");
        }
    }
}
