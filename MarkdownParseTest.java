import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testNewFile() throws IOException {
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test the links from test-file.md", List.of("https://something.com", "some-page.html"), links);
    }
    @Test
    public void testImageFile() throws IOException {
        Path fileName = Path.of("new-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test links from new-file.md", List.of("google.com"), links);
    }
    @Test
    public void testNoParen() throws IOException {
        Path fileName = Path.of("no-paren.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test links from no-paren.md", List.of(), links);
    }
    @Test
    public void testLinkFirst() throws IOException {
        Path fileName = Path.of("link-first.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test links from link-first.md", List.of("firstline.com"), links);
    }
    @Test
    public void testFormat2() throws IOException {
        Path fileName = Path.of("testformat2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test links from testformat2.md", List.of(), links);
    }
    @Test
    public void testVim() throws IOException {
	Path fileName = Path.of("testformat2.md");
	String contents = Files.readString(fileName);
	ArrayList<String> links = MarkdownParse.getLinks(contents);
	assertEquals("Test links from testformat2.md (vim version)", List.of(), links);
    }
}
