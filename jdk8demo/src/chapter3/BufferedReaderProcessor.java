package chapter3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by xugebing on 2017/7/24.
 */
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
