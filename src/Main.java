import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = 0, m = 0, c;
        FileReader fileReader = new FileReader(new File("input.txt"));
        while ((c = fileReader.read()) != ' ') {
            n = n * 10 + c - 48;
        }
        while ((c = fileReader.read()) != '\r') {
            m = m * 10 + c - 48;
        }
        fileReader.read();
        int degree[] = new int[n];
        List<Integer> listArray[] = new List[n];
        for (int i = 0; i < n; i++) {
            listArray[i] = new LinkedList<>();
        }
        int v, u;
        for (int i = 0; i < m; i++) {
            v = 0; u = 0;
            while ((c = fileReader.read()) != ' ') {
                v = v * 10 + c - 48;
            }
            while ((c = fileReader.read()) != '\r' && (c != -1)) {
                u = u * 10 + c - 48;
            }
            fileReader.read();
            degree[v - 1]++;
            degree[u - 1]++;
            listArray[v - 1].add(u);
            listArray[u - 1].add(v);

        }
        FileWriter fileWriter = new FileWriter(new File("output.txt"));
        for (int i = 0; i < n; i++) {
            fileWriter.write(degree[i] + " ");
            for (Integer item : listArray[i]) {
                fileWriter.write(item + " ");
            }
            fileWriter.write("\n");
        }
        fileWriter.close();
        fileReader.close();
    }

}

