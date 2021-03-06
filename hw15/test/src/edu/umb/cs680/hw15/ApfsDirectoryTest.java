package edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw15.APFS;
import edu.umb.cs680.hw15.ApfsDirectory;
import edu.umb.cs680.hw15.ApfsFile;
import edu.umb.cs680.hw15.ApfsLink;

class ApfsDirectoryTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 05, 12, 0, 0);
private String[] arraystringfordirectory(ApfsDirectory directory) {
	Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(directory.getParent());
	String[] inforofdirectory = { Boolean.toString(directory.isDirectory()), directory.getName(), 
			Integer.toString(directory.getSize()), directory.getCreationTime().toString(), 
			optionalDirectory.isPresent()?directory.getParent().getName():null, 
					Integer.toString(directory.getTotalSize()),
					Integer.toString(directory.countChildren()), directory.getOwnerName(),directory.getLastModified().toString()};
	return inforofdirectory;
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
	void testforsizedir() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertEquals(3500, root.findDirByName("root").getTotalSize());
		assertEquals(2450, root.findDirByName("home").getTotalSize());
		assertEquals(1050, root.findDirByName("applications").getTotalSize());
		assertEquals(1570, root.findDirByName("code").getTotalSize());
	}


	@Test
	void testforfileanddirectory() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertSame("home", root.findDirByName("home").getName());
		assertSame("root", root.findDirByName("root").getName());
		assertSame("applications", root.findDirByName("applications").getName());
		assertSame("code", root.findDirByName("code").getName());
		assertSame("a", root.findFileByName("a").getName());	
		assertSame("c", root.findFileByName("c").getName());
		assertSame("d", root.findFileByName("d").getName());
		assertSame("e", root.findFileByName("e").getName());
		assertSame("f", root.findFileByName("f").getName());
		assertSame("b", root.findFileByName("b").getName());
	}
	@Test
	public void verifyDirectoryEqualityHome() { 
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "home", "0", localTime.toString(), "root", "2450", "3", "vipul", localTime.toString() };
		ApfsDirectory actual = root.findDirByName("home");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	@Test
	void checkfetchedDirAndFile() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		assertSame("home", root.findDirByName("home").getName());
		assertSame("root", root.findDirByName("root").getName());
		assertSame("applications", root.findDirByName("applications").getName());
		assertSame("code", root.findDirByName("code").getName());
		assertSame("a", root.findFileByName("a").getName());
		assertSame("f", root.findFileByName("f").getName());
	}
	
	
	@Test
	public void verifyDirectoryEqualityCode() { 
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "code", "0", localTime.toString(), "home", "1570", "2", "vipul", localTime.toString() };
		ApfsDirectory actual = root.findDirByName("code");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	@Test
	public void verifyDirectoryEqualityApplications() { 
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root", "1050", "2", "vipul", localTime.toString() };
		ApfsDirectory actual = root.findDirByName("applications");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	@Test
	void testforinfoonfiles() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertSame("d", root.findDirByName("home").getFiles().get(1).getName());
		assertSame("a", root.findDirByName("applications").getFiles().get(0).getName());
		assertSame("b", root.findDirByName("applications").getFiles().get(1).getName());
		assertSame("c", root.findDirByName("home").getFiles().get(0).getName());
	}
	
	@Test
	void testsubdir() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertSame("applications", root.findDirByName("root").getSubDirectories().get(0).getName());
		assertSame("home", root.findDirByName("root").getSubDirectories().get(1).getName());
	}
	
	@Test
	void testsubfilesindir() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertEquals(2, root.findDirByName("root").countChildren());
		assertEquals(2, root.findDirByName("applications").countChildren());
		assertEquals(3, root.findDirByName("home").countChildren());
		assertEquals(2, root.findDirByName("code").countChildren());
	}
	
	@Test
	public void verifyDirectoryEqualityRoot() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "3500", "2", "vipul", localTime.toString() };
		ApfsDirectory actual = root.findDirByName("root");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	
	
	
	

}
