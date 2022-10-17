package Lab_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class packageZIP {

    public void packageArchieve(File[] files, String zipName) {
        try {
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipName));
            // setLevel - poziom kompresji 0 - bez, 9 - najwyższa
            zipOut.setLevel(9);

            if (files.length > 1) {
                for (File f : files) {
                    // tworzy nam element, który będziemy odpowiednio nazywać, getName() - pobieram
                    // nazwę zagadnienia
                    ZipEntry zipE = new ZipEntry(f.getName());
                    zipOut.putNextEntry(zipE);
                    FileInputStream fIn = new FileInputStream(f);

                    // I sposób
                    zipOut.write(fIn.readAllBytes());

                    // II sposób - bez readAllBytes()
                    // byte[] buff = new byte[2048];
                    // int len = 0;
                    // while ((len = fIn.read(buff, 0, buff.length)) != -1) {
                    // zipOut.write(buff, 0, buff.length);
                    // }

                    zipOut.closeEntry();
                    fIn.close();
                }
                zipOut.flush();
                zipOut.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unpackageArchive(Path dlocation, String zipName) {
        try {
            ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipName));
            ZipEntry zipE;

            while ((zipE = zipIn.getNextEntry()) != null) {
                FileOutputStream fOut = new FileOutputStream(new File(dlocation.toString(), zipE.getName()));
                // zapisujemy odczytaną wartość do pliku
                fOut.write(zipIn.readAllBytes());
                fOut.flush();
                fOut.close();
                zipIn.closeEntry();
            }
            zipIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
