package edu.umb.cs680.hw10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitorTest {

    private static APFS apfs;
    private static ApfsDirectory root, applications, home, code;
    private static ApfsFile a, b, c, d, e, f;
    private static ApfsLink x, y;

    @BeforeAll
    public static void setUp() {
        apfs = new APFS("vipul");
        apfs.initFileSystem("Local Disk", 1000);
        root = apfs.getRootDir();

        applications = new ApfsDirectory(root, "applications");
        home = new ApfsDirectory(root, "home");
        root.appendChild(applications);
        root.appendChild((home));

        a = new ApfsFile(applications, "a", 10);
        b = new ApfsFile(applications, "b", 10);
        applications.appendChild(a);
        applications.appendChild(b);

        c = new ApfsFile(home, "c", 10);
        d = new ApfsFile(home, "d", 10);
        code = new ApfsDirectory(home, "code");
        home.appendChild(c);
        home.appendChild(d);
        home.appendChild(code);

        e = new ApfsFile(code, "e", 10);
        f = new ApfsFile(code, "f", 10);
        code.appendChild(e);
        code.appendChild(f);

        x = new ApfsLink(home, "x", applications);
        y = new ApfsLink(code, "y", b);
        home.appendChild(x);
        code.appendChild(y);
    }

    @Test
    public void testCountingOfRoot() {
        int[] expected = {4, 6, 2};

        ApfsCountingVisitor v = new ApfsCountingVisitor();
        root.accept(v);
        int[] actual = {v.getDirNum(), v.getFileNum(), v.getLinkNum()};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testCountingOfHome() {
        int[] expected = {2, 4, 2};

        ApfsCountingVisitor v = new ApfsCountingVisitor();
        home.accept(v);
        int[] actual = {v.getDirNum(), v.getFileNum(), v.getLinkNum()};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFileCrawlingOfRoot() {
        LinkedList<ApfsFile> expected = new LinkedList<>(Arrays.asList(a, b, c ,d, e, f));

        ApfsFileCrawlingVisitor v = new ApfsFileCrawlingVisitor();
        root.accept(v);
        LinkedList<ApfsFile> actual = v.getFiles();
        assertEquals(expected, actual);
    }

    @Test
    public void testFileCrawlingOfApplications() {
        LinkedList<ApfsFile> expected = new LinkedList<>(Arrays.asList(a, b));

        ApfsFileCrawlingVisitor v = new ApfsFileCrawlingVisitor();
        applications.accept(v);
        LinkedList<ApfsFile> actual = v.getFiles();
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchFInRoot() {
        LinkedList<ApfsFile> expected = new LinkedList<>(Arrays.asList(f));

        ApfsFileSearchVisitor v = new ApfsFileSearchVisitor("f");
        root.accept(v);
        LinkedList<ApfsFile> actual = v.getFoundFiles();
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchAInHome() {
        LinkedList<ApfsFile> expected = new LinkedList<>();

        ApfsFileSearchVisitor v = new ApfsFileSearchVisitor("a");
        home.accept(v);
        LinkedList<ApfsFile> actual = v.getFoundFiles();
        assertEquals(expected, actual);
    }
}