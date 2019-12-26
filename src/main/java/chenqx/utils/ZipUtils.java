package chenqx.utils;

import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author chenqx 2019-10-16
 * @instruction
 */
public class ZipUtils {


    private long FILE_SIZE = 0;
    private final String ZIP_FILE = getClass().getClassLoader().getResource("zip/test.zip").getPath();
    private final String JPG_FILE = getClass().getClassLoader().getResource("zip/hh.jpg").getPath();

    void zipFileNoBuffer() {

        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile))) {
            long beginTime = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                try (InputStream input = new FileInputStream(JPG_FILE)) {
                    zipOut.putNextEntry(new ZipEntry("" + i));
                    int temp = 0;
                    while ((temp = input.read()) != -1) {
                        zipOut.write(temp);
                    }
                }
            }

            System.out.println(System.currentTimeMillis() - beginTime);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void zipFileBuffer() {

        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile))) {
            long beginTime = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(JPG_FILE))) {
                    zipOut.putNextEntry(new ZipEntry("" + i));
                    int temp = 0;
                    while ((temp = bufferedInputStream.read()) != -1) {
                        zipOut.write(temp);
                    }
                }
            }

            System.out.println(System.currentTimeMillis() - beginTime);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void zipFileChannel() {
        long beginTime = System.currentTimeMillis();

        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {
            for (int i = 0; i < 10; i++) {
                try (FileChannel fileChannel = new FileInputStream(JPG_FILE).getChannel()) {
                    zipOut.putNextEntry(new ZipEntry("1" + i));
                    FILE_SIZE=fileChannel.size();
                    fileChannel.transferTo(0, FILE_SIZE, writableByteChannel);
                }
            }

            System.out.println(System.currentTimeMillis() - beginTime);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ZipUtils zipUtils = new ZipUtils();
//        zipUtils.zipFileNoBuffer();   
//        zipUtils.zipFileBuffer();  //12275ms
        zipUtils.zipFileChannel();
    }
}
