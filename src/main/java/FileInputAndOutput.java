import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class FileInputAndOutput {
    public String readInput(String path) throws IOException {
        try{
            return Files.readString(Path.of(path), StandardCharsets.US_ASCII);
        }catch (IOException e){
            throw new NoSuchFileException("file does not exist");
        }

    }

    public void writeOutput(String message) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("output.txt", false), true);
        out.write(message);
        out.close();
    }
}
