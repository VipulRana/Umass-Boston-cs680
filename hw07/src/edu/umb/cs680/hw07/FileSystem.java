package edu.umb.cs680.hw07;

import java.util.LinkedList;

public class FileSystem {
	private LinkedList<Directory> directoryroot;
	private static FileSystem instance = null;
	
	void addRootDir(Directory Rootdirectory) {
		//adding  root directory
		directoryroot = new LinkedList<Directory>();
		directoryroot.add(Rootdirectory);
	}
	private FileSystem() {};
	
	
	
	public static FileSystem getFileSystem() {
		if(instance==null) //instanceone
			instance = new FileSystem ();
		return instance; // to return the filesystem instance
	}
	
	
	public LinkedList<Directory> getRootDirs() {
		return this.directoryroot;
	}
	public static void main(String[] args) {
		System.out.println("The class fileSystem has completely run!");
	}
}
