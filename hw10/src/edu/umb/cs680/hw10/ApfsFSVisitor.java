package edu.umb.cs680.hw10;

public interface ApfsFSVisitor 
{
    void visit(ApfsLink link);
    void visit(ApfsDirectory dir);
    void visit(ApfsFile file);
    
    public static void main(String[] args)
    {
    	System.out.println("Interface ApfsFSVisitor is running successfully.");
    }
}
