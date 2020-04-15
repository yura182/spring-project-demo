package com.yura.spring.demo.course.logger;

import com.yura.spring.demo.course.event.Event;
import com.yura.spring.demo.course.logger.EventLogger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException {
        file = new File(fileName);
        if (!file.canWrite()) {
            throw new IOException("Access denied");
        }
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.getMsg() + "\n", Charset.defaultCharset(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
