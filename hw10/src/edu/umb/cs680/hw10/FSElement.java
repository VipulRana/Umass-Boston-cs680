package edu.umb.cs680.hw10;

public abstract class FSElement {
    protected String name;
    protected int size;

    public FSElement(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public abstract boolean isDirectory();

    public abstract boolean isFile();
    
    public static void main(String[] args)
    {
    	System.out.println("Class FSElement is running successfully.");
    }
}