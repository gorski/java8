package net.mgorski.java8.mod01;


import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileListing {

    private static Logger LOG = LoggerFactory.getLogger(FileListing.class);

    public static void main(String[] args) {

        Map<String, String> env = System.getenv();

        final String dir = env.get("JAVA_HOME") == null ? "." : env.get("JAVA_HOME");
        LOG.info("Java home:{}", env.get("JAVA_HOME"));

        // Java7
        File[] dirs = new File(dir).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        LOG.info("dirs:{}", Arrays.toString(dirs));

        // Java8 - passing method
        File[] fileStream = new File(dir).listFiles(File::isFile);
        LOG.info("files:{}", Arrays.toString(fileStream));

        // Java8 - lambda
        File[] bins = new File(dir).listFiles((dir1, name) -> dir1.getName().contains("bin"));
        LOG.info("files containing bin:{}", Arrays.toString(bins));



    }
}
