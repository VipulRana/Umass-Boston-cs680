package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AfpsFileSearchVisitorTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 04, 22, 0, 0);
private String[] arraystringfordirectory(ApfsFile f) {
	Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(f.getParent());
	String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(), 
			Integer.toString(f.getSize()), f.getCreationTime().toString(), 
			optionalDirectory.isPresent()?f.getParent().getName():null, f.getOwnerName(),f.getLastModified().toString()};
	return fileInfo;
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
	public void verifyFileEqualityA() {
		ApfsFileSearchVisitor apfsvisior = new ApfsFileSearchVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "false", "a", "350", localTime.toString(), "applications", "vipul", localTime.toString() };
		apfsvisior.setFileName("a");
		root.accept(apfsvisior);
		ApfsFile actual = apfsvisior.getFile();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	@Test
	public void verifyFileEqualityE() {
		ApfsFileSearchVisitor apfsvisior = new ApfsFileSearchVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "false", "e", "700", localTime.toString(), "code", "vipul", localTime.toString() };
		apfsvisior.setFileName("e");
		root.accept(apfsvisior);
		ApfsFile actual = apfsvisior.getFile();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	@Test
	public void verifyFileEqualityB() {
		ApfsFileSearchVisitor apfsvisior = new ApfsFileSearchVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "false", "b", "700", localTime.toString(), "applications", "vipul", localTime.toString() };
		apfsvisior.setFileName("b");
		root.accept(apfsvisior);
		ApfsFile actual = apfsvisior.getFile();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	public void verifyFileEqualityC() {
		ApfsFileSearchVisitor apfsvisior = new ApfsFileSearchVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "false", "c", "800", localTime.toString(), "home", "vipul", localTime.toString() };
		apfsvisior.setFileName("c");
		root.accept(apfsvisior);
		ApfsFile actual = apfsvisior.getFile();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	public void verifyFileEqualityD() {
		ApfsFileSearchVisitor apfsvisior = new ApfsFileSearchVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "false", "d", "80", localTime.toString(), "home", "vipul", localTime.toString() };
		apfsvisior.setFileName("d");
		root.accept(apfsvisior);
		ApfsFile actual = apfsvisior.getFile();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	

}
