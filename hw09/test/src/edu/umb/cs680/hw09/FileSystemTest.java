package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileSystemTest {

static LocalDateTime localTime = LocalDateTime.of(2019, 12, 20, 0, 0);
	
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.initFileSystem("drive", 3500);
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "sandesh", localTime);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "sandesh", localTime);
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "sandesh", localTime);
		ApfsFile a = new ApfsFile(applications, "a", 350, localTime, "sandesh", localTime);
		ApfsFile b = new ApfsFile(applications, "b", 700, localTime, "sandesh", localTime);
		ApfsFile c = new ApfsFile(home, "c", 800, localTime, "sandesh", localTime);
		ApfsFile d = new ApfsFile(home, "d", 80, localTime, "sandesh", localTime);
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "sandesh", localTime, applications);
		ApfsFile e = new ApfsFile(code, "e", 700, localTime, "sandesh", localTime);
		ApfsFile f = new ApfsFile(code, "f", 870, localTime, "sandesh", localTime);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "sandesh", localTime, b);
	}
	@Test
	public void testforrootinstance() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertEquals(root.getOwnerName(), "sandesh");
		assertEquals(root.getLastModified(), localTime);
	}
	private String[] stringarraycreation(ApfsDirectory dir) {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(dir.getParent());
		String[] infofordirectory = { Boolean.toString(dir.isDirectory()), dir.getName(), 
				Integer.toString(dir.getSize()), dir.getCreationTime().toString(), 
				optionalDirectory.isPresent()?dir.getParent().getName():null, 
						Integer.toString(dir.getTotalSize()),
						Integer.toString(dir.countChildren()), FilesystemofApfs.getFileSystemName(), 
						Integer.toString(FilesystemofApfs.getCapacity()), dir.getOwnerName(),dir.getLastModified().toString() };
		return infofordirectory;
	}
	
	@Test
	public void testforrootstatus() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "3500", "2", "drive", "3500", "sandesh", localTime.toString()};
		ApfsDirectory actual = root.findDirByName("root");
		assertArrayEquals(expected,stringarraycreation(actual));
	}
	
	

}
