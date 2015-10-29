package io;

import java.io.File;

public class MainRenameDir {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File lvOrgDir = new File("files");
		File lvNewDir = new File("c:/files");
		
		System.out.println( lvOrgDir.renameTo(lvNewDir) );
		
	}

}
