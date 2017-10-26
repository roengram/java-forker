package com.github.roengram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class App
{
    public static void main( String[] args )
    {
		int mem = Integer.parseInt(args[0]);
		int maxfork = Integer.parseInt(args[1]);
		int forknum = Integer.parseInt(args[2]);
		int intv = Integer.parseInt(args[3]);
		String cmd = args[4];
        char[] buf = new char [mem*1024*1024];
        try {
			for (int i=0 ; i<maxfork ; i++) {
			    for (int j=0 ; j<forknum ; j++) {
                    Process p = Runtime.getRuntime().exec(cmd, null, null);
                    System.out.printf("\"%s\" process %d-%d is created\n", cmd, i, j);
                    p.waitFor(9999, TimeUnit.SECONDS);
			    }
				Thread.sleep(intv);
			}
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted while waiting for child process");
        }
    }
}
