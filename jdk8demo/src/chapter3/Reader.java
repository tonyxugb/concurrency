package chapter3;

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
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        System.out.println("oneLine:" + oneLine);

        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println("twoLine:" + twoLine);
    }
}
