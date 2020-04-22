package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AfpsCountingVisitorTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 04, 22, 0, 0);
	
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.initFileSystem("drive", 3500);
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "vipul", localTime);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "vipul", localTime);
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "vipul", localTime);
		ApfsFile a = new ApfsFile(applications, "a", 350, localTime, "vipul", localTime);
		ApfsFile b = new ApfsFile(applications, "b", 700, localTime, "vipul", localTime);
		ApfsFile c = new ApfsFile(home, "c", 800, localTime, "vipul", localTime);
		ApfsFile d = new ApfsFile(home, "d", 80, localTime, "vipul", localTime);
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "vipul", localTime, applications);
		ApfsFile e = new ApfsFile(code, "e", 700, localTime, "vipul", localTime);
		ApfsFile f = new ApfsFile(code, "f", 870, localTime, "vipul", localTime);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "vipul", localTime, b);
	}
	//count the visitors
	@Test
	void TestCountingVisitorvalue() {
		ApfsCountingVisitor countvis = new ApfsCountingVisitor();
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		root.accept(countvis);
		
		assertEquals(countvis.getDirNum(), 4);
		assertEquals(countvis.getFileNum(), 6);
		assertEquals(countvis.getLinkNum(), 2);
	}
	//testing code to check, need to remove later
	@Test
	void TestCountingVisitorvaluetry() {
		ApfsCountingVisitor countvis = new ApfsCountingVisitor();
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		root.accept(countvis);
		
		assertEquals(countvis.getDirNum(), 4);
		assertEquals(countvis.getFileNum(), 6);
		assertEquals(countvis.getLinkNum(), 2);
	}

}
