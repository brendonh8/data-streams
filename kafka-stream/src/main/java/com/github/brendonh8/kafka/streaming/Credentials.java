package com.github.brendonh8.kafka.streaming;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class Credentials {

    private final String file_path;

    public Credentials(String path) {
        file_path = path;
    }

    public Properties getCredentials() throws IOException {
        FileInputStream fis = new FileInputStream(file_path);

        Properties prop = new Properties();
        prop.load(fis);
        return prop;
    }
    
}

