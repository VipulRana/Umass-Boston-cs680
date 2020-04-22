package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AfspFileCrawlingVisitorTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 04, 22, 0, 0);
private String[] arraystringfordirectory(ArrayList<ApfsFile> files) {
	String[] filesInDir = new String[files.size()];
	int i = 0;
	for(ApfsFile f : files) {
		filesInDir[i] = f.getName();
		i++;
	}
	return filesInDir;
}
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
	
	
	@Test
	void checkFilesUnderHome() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		ApfsDirectory home = root.findDirByName("home");
		home.accept(visitor);
		String[] expected = {"e","f","c","d"};
		ArrayList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	void checkFilesUndercode() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		ApfsDirectory pictures = root.findDirByName("code");
		pictures.accept(visitor);
		String[] expected = {"e","f"};
		ArrayList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	@Test
	void checkFilesUnderRoot() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		root.accept(visitor);
		String[] expected = {"a","b","e","f","c","d"};
		ArrayList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	@Test
	void checkFilesUnderApplcations() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		ApfsDirectory system = root.findDirByName("applications");
		system.accept(visitor);
		String[] expected = {"a","b"};
		ArrayList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
}

