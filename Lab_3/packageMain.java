package Lab_3;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class packageMain {
    public static void main(String[] args) {

        packageZIP pz = new packageZIP();
        File[] files = Paths.get("Lab_3\\pliki").toFile().listFiles();

        pz.packageArchieve(files, "Lab_3\\pliki\\plik.zip");
        pz.unpackageArchive(Path.of("Lab_3\\pliki_out"), "Lab_3\\pliki\\plik.zip");
    }
}
