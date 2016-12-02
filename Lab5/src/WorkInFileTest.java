import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Алина on 13.11.2016.
 */
public class WorkInFileTest {

    List<String> validUnsortedList;
    List<String> validSortedList;
    String testFileName;

    @Before
    public void setUp() throws Exception {
        validUnsortedList = Arrays.asList("sdvsdvjjv", "ksndknkdsnksndk", "sddjodjv", "dksmsd", "scdocosdcmdsoc", "lsdmlcsmcsldcmldcsl", "ldcl");
        validSortedList = Arrays.asList("lsdmlcsmcsldcmldcsl", "ksndknkdsnksndk", "scdocosdcmdsoc", "sdvsdvjjv", "sddjodjv", "dksmsd", "ldcl");

        //write list to file
        testFileName = "C://SomeDir//file1.txt";
        Files.write(Paths.get(testFileName), validUnsortedList);
    }

    @Test
    public void testReadFile_expectedTrue() throws Exception {
        assertEquals(validUnsortedList, WorkInFile.readFile(testFileName));
    }

    @Test
    public void testSortList_validSortedArray_expectedTrue() throws Exception {
        assertEquals(validSortedList, WorkInFile.sortList(validUnsortedList));
    }

    @Test
    public void testWriteFile_expectedTrue() throws Exception {
        WorkInFile.writeFile(testFileName,validSortedList);
        assertEquals(validSortedList, WorkInFile.readFile(testFileName));
    }
}