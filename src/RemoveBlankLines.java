import java.io.*;
public class RemoveBlankLines {
    private static final String FILENAME = "texto.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;
        File inputFile = new File(FILENAME);
        File outputFile = new File("tempFile.txt");
        try {
            inputStream = new BufferedReader(new FileReader(inputFile));
            outputStream = new PrintWriter(new FileWriter(outputFile));
            String line;
            while ((line = inputStream.readLine()) != null) {
                if(!line.matches("//s*")) {
                    outputStream.println(line);
                }
            }
            inputFile.delete();
            outputFile.renameTo(inputFile);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
