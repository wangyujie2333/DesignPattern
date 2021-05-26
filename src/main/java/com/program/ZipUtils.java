package com.program;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @author wangyuj
 * @date 2020/7/27
 **/
public class ZipUtils {

    private static final String MD5 = "MD5";
    private static final String MD2 = "MD2";

    private static final char[] HEX_CHARS =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "14fa98d4d74b189993c380c7b9e4d9d3"+"yVvdcU4syy2KAME+EMX2W87ZP0asdV4GFlsv9A";
        str = md5(str);
        System.out.println(str);
        //String str = new String("73.25".getBytes("UTF-8"));
        //for (int i = 0; i < 100000000; i++) {
        //    str = md5(str);
        //    if (i == 100000000 - 1) {
        //        System.out.println(str);
        //    }
        //}

    }

    private static String md5(String value) {
        byte[] bytes = null;
        try {
            MessageDigest messageDigest = null;
            bytes = messageDigest.digest(value.getBytes("UTF-8"));
            char[] chars = new char[32];
            for (int i = 0; i < chars.length; i = i + 2) {
                byte b = bytes[i / 2];
                chars[i] = HEX_CHARS[(b >>> 0x4) & 0xf];
                chars[i + 1] = HEX_CHARS[b & 0xf];
            }
            return new String(chars);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void maiqqn(String[] args) {
        //List<File> files = new ArrayList<>();
        //for (int i = 0; i < 10; i++) {
        //    File file = null;
        //    try {
        //        file = writeToText("wangyujie" + i, "name" + i);
        //    } catch (IOException e) {
        //        e.printStackTrace();
        //    }
        //    files.add(file);
        //}
        //zipFiles(files);
        String path = ZipUtils.class.getResource("/").getPath() + "fileName.zip";
        try {
            unZipFiles(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static File writeToText(String musicInfo, String fileName) throws IOException {
        // 生成的文件路径
        String path = ZipUtils.class.getResource("/").getPath() + fileName + ".txt";
        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        // write 解决中文乱码问题
        OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(fw);
        // 写入数据
        bw.write(musicInfo);
        bw.flush();
        bw.close();
        fw.close();
        return new File(path);
    }


    public static void zipFiles(List<File> files) {
        // 生成的文件路径
        String path = ZipUtils.class.getResource("/").getPath() + "fileName.zip";
        File zipFile = new File(path);
        if (!zipFile.exists()) {
            try {
                zipFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 创建 FileOutputStream 对象
        FileOutputStream fileOutputStream = null;
        // 创建 ZipOutputStream
        ZipOutputStream zipOutputStream = null;
        // 创建 FileInputStream 对象
        FileInputStream fileInputStream = null;

        try {
            // 实例化 FileOutputStream 对象
            fileOutputStream = new FileOutputStream(zipFile);
            // 实例化 ZipOutputStream 对象
            zipOutputStream = new ZipOutputStream(fileOutputStream);
            // 创建 ZipEntry 对象
            ZipEntry zipEntry = null;
            // 遍历源文件数组
            for (int i = 0; i < files.size(); i++) {
                // 将源文件数组中的当前文件读入 FileInputStream 流中
                File file = files.get(i);
                fileInputStream = new FileInputStream(file);
                // 实例化 ZipEntry 对象，源文件数组中的当前文件
                zipEntry = new ZipEntry(file.getName());
                zipOutputStream.putNextEntry(zipEntry);
                // 该变量记录每次真正读的字节个数
                int len;
                // 定义每次读取的字节数组
                byte[] buffer = new byte[1024];
                while ((len = fileInputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, len);
                }
                file.delete();
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unZipFiles(File zipFile) throws IOException {
        String descDir = ZipUtils.class.getResource("/").getPath();
        File pathFile = new File(descDir);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        ZipFile zip = new ZipFile(zipFile);
        for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            String outPath = (descDir + zipEntryName).replaceAll("\\*", "/");
            ;
            //判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
            if (!file.exists()) {
                file.mkdirs();
            }
            //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if (new File(outPath).isDirectory()) {
                continue;
            }
            //输出文件路径信息
            System.out.println(outPath);

            OutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
        }
        System.out.println("******************解压完毕********************");
    }
}
