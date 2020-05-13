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

class FileSystemTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 05, 12, 0, 0);
private String[] arraystringfordirectory(ApfsDirectory directory) {
	APFS FilesystemofApfs = APFS.getAPFSFileSystem();
	Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(directory.getParent());
	String[] inforofdirectory = { Boolean.toString(directory.isDirectory()), directory.getName(), 
			Integer.toString(directory.getSize()), directory.getCreationTime().toString(), 
			optionalDirectory.isPresent()?directory.getParent().getName():null, 
					Integer.toString(directory.getTotalSize()),
					Integer.toString(directory.countChildren()), FilesystemofApfs.getFileSystemName(), 
					Integer.toString(FilesystemofApfs.getCapacity()), directory.getOwnerName(),directory.getLastModified().toString() };
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
	public void Testforfileowner() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertEquals(root.getOwnerName(), "vipul");
		assertEquals(root.getLastModified(), localTime);
	}
	
	
	@Test
	public void testfordirectorysetup() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "3500", "2", "drive", "3500", "vipul", localTime.toString()};
		ApfsDirectory actual = root.findDirByName("root");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	

}
