package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DirectoryTest {
	
	static LocalDateTime localTime = LocalDateTime.now();
	
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		Directory root = new Directory(null, "root", 0, localTime);
		Directory applications = new Directory(root, "applications", 0, localTime);
		Directory home = new Directory(root, "home", 0, localTime);
		Directory code = new Directory(home, "code", 0, localTime);
		File a = new File(applications, "a", 1300, localTime);
		File b = new File(applications, "b", 350, localTime);
		File c = new File(home, "c", 500, localTime);
		File d = new File(home, "d", 700, localTime);
		File e = new File(code, "e", 70, localTime);
		File f = new File(code, "f", 130, localTime);
		//creation of files and adding root dir
		FileSystem.getFileSystem().addRootDir(root);
		
	}
	
	private String[] dirToStringArray(Directory d) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(d.getParent());
		String[] directorystring = { Boolean.toString(d.isDirectory()), d.getName(), 
				Integer.toString(d.getSize()), d.getCreationTime().toString(), 
				optionalDirectory.isPresent()?d.getParent().getName():null, 
						Integer.toString(d.getTotalSize()),
						Integer.toString(d.countChildren())};
		return directorystring;
	}

	
	
	@Test
	void testretDirectoryandFiles() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertSame("home", fileSystem.getRootDirs().get(0).findDirByName("home").getName());
		assertSame("root", fileSystem.getRootDirs().get(0).findDirByName("root").getName());
		assertSame("applications", fileSystem.getRootDirs().get(0).findDirByName("applications").getName());
		assertSame("code", fileSystem.getRootDirs().get(0).findDirByName("code").getName());
		assertSame("a", fileSystem.getRootDirs().get(0).findFileByName("a").getName());
		assertSame("f", fileSystem.getRootDirs().get(0).findFileByName("f").getName());
	} 
	
	@Test
	void testforDirectoryandfiles() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertTrue(fileSystem.getRootDirs().get(0).findDirByName("root").isDirectory());
		assertTrue(fileSystem.getRootDirs().get(0).findDirByName("home").isDirectory());
		assertTrue(fileSystem.getRootDirs().get(0).findDirByName("home").isDirectory());
		assertTrue(fileSystem.getRootDirs().get(0).findDirByName("code").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("a").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("b").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("c").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("d").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("e").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("f").isDirectory());
	}
	
	@Test
	public void verifyDirectoryEqualityCode() { 
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "code", "0", localTime.toString(), "home", "200", "2" };
		Directory actual = fileSystem.getRootDirs().get(0).findDirByName("code");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	
	@Test
	void testdirectoryfilenumbers() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertSame("a", fileSystem.getRootDirs().get(0).findDirByName("applications").getFiles().get(0).getName());
		assertSame("b", fileSystem.getRootDirs().get(0).findDirByName("applications").getFiles().get(1).getName());
		assertSame("c", fileSystem.getRootDirs().get(0).findDirByName("home").getFiles().get(0).getName());
		assertSame("d", fileSystem.getRootDirs().get(0).findDirByName("home").getFiles().get(1).getName());
		assertSame("e", fileSystem.getRootDirs().get(0).findDirByName("code").getFiles().get(0).getName());
		assertSame("f", fileSystem.getRootDirs().get(0).findDirByName("code").getFiles().get(1).getName());
	}
	
	@Test
	void testsubdirectoriesonly() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertSame("applications", fileSystem.getRootDirs().get(0).findDirByName("root").getSubDirectories().get(0).getName());
		assertSame("home", fileSystem.getRootDirs().get(0).findDirByName("root").getSubDirectories().get(1).getName());
		assertSame("code", fileSystem.getRootDirs().get(0).findDirByName("home").getSubDirectories().get(0).getName());
	}
	@Test
	void tesforcodesize() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertEquals(200, fileSystem.getRootDirs().get(0).findDirByName("code").getTotalSize());

		
	}
	
	
	@Test
	public void verifyDirectoryEqualityRoot() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "3050", "2" };
		Directory actual = fileSystem.getRootDirs().get(0).findDirByName("root");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	
	@Test
	public void verifyDirectoryEqualityHome() { 
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "home", "0", localTime.toString(), "root", "1400", "3" };
		Directory actual = fileSystem.getRootDirs().get(0).findDirByName("home");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	@Test
	void testsubfilesandfoldersnumber() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertEquals(2, fileSystem.getRootDirs().get(0).findDirByName("root").countChildren());
		assertEquals(2, fileSystem.getRootDirs().get(0).findDirByName("applications").countChildren());
		assertEquals(3, fileSystem.getRootDirs().get(0).findDirByName("home").countChildren());
		assertEquals(2, fileSystem.getRootDirs().get(0).findDirByName("code").countChildren());
	}
	@Test
	void tesfoldersizes() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertEquals(3050, fileSystem.getRootDirs().get(0).findDirByName("root").getTotalSize());
		assertEquals(200, fileSystem.getRootDirs().get(0).findDirByName("code").getTotalSize());
		assertEquals(1650, fileSystem.getRootDirs().get(0).findDirByName("applications").getTotalSize());
		assertEquals(1400, fileSystem.getRootDirs().get(0).findDirByName("home").getTotalSize());
		
	}
	@Test
	void testforroosize() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertEquals(3050, fileSystem.getRootDirs().get(0).findDirByName("root").getTotalSize());	
	}
	@Test
	public void verifyDirectoryEqualityApplications() { 
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root", "1650", "2" };
		Directory actual = fileSystem.getRootDirs().get(0).findDirByName("applications");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	
	
}

