package codecool;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    private FilePartReader filePartReader;
    private static String filePath;

    @BeforeAll
    static void initFile(){
        filePath = "/home/adina/Projects/java/filePartReader/src/main/java/codecool/textFile.txt";
    }

    @BeforeEach
    void init(){
        filePartReader = new FilePartReader();
    }

    @Test
    public void testReadReturnsValue() throws IOException{
        int fromLine = 1;
        int toLine = 3;
        filePartReader.setup(filePath, fromLine, toLine);
        assertNotNull(filePartReader.read());
    }

    @Test
    public void TestReadLinesReturnValue() throws IOException{
        int fromLine = 1;
        int toLine = 3;
        filePartReader.setup(filePath, fromLine, toLine);
        assertNotNull(filePartReader.readLine(fromLine, toLine));
    }

}