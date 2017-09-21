package ruixue.etl.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class IOUtils {

	public static List<String> readAllLines(String pathStr) throws IOException {
		Path path = Paths.get(pathStr);
		return Files.readAllLines(path);						
	}
}
