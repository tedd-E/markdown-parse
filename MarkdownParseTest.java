import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testNewFile() throws IOException {
        Path filename = Path.of("test-file.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test the links of test-file.md", List.of("https://something.com", "some-page.html"), links);

    }

    @Test
    public void testLinkFirst() throws IOException {
        Path filename = Path.of("linkfirst.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test the links of link-first.md", List.of("[link](hee.com)"), links);
    }

    @Test
    public void testNoParen() throws IOException {
        Path filename = Path.of("no-paren.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test the links of no-paren.md", List.of("[link]google.com"), links);
    }
}