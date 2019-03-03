package ch.webapp.util;

import org.assertj.core.util.Files;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileAsStringReader {

    public static String readFile(String path) throws IOException {
        File file = new ClassPathResource("read-book.json").getFile();
        return Files.contentOf(file, Charset.defaultCharset());
    }
}
