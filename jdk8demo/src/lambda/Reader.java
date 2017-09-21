package lambda;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by xugebing on 2017/7/24.
 */
public class Reader {

    public String processFile(BufferedReaderProcessor p) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\data.txt"));
        return p.process(br);
    }


    @Test
    public void testProcess() throws IOException {

        BufferedReaderProcessor brp = (BufferedReader br) -> br.readLine();
        String oneLine = processFile(brp);
        System.out.println("oneLine:" + oneLine);

        BufferedReaderProcessor brp2 = (BufferedReader br) -> br.readLine() + br.readLine();
        String twoLine = processFile(brp2);
        System.out.println("twoLine:" + twoLine);
    }
}
