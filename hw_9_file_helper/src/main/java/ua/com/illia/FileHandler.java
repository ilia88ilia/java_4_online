package ua.com.illia;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class FileHandler {

    File currentDir;
    Colors colors = new Colors();

    public void readDir(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                readDir(file);
                System.out.println(colors.CYAN + file);
            } else {
                System.out.println(colors.CYAN + file);
            }
        }
    }

    public void createDir(BufferedReader reader) throws IOException {
        if (currentDir != null) {
            System.out.println();
            System.out.println("Current Directory is : " + currentDir.getAbsolutePath());
            System.out.println();
            System.out.println(colors.YELLOW + "Enter The Directory Name :");
            System.out.println();
            String dirName = reader.readLine();
            File dir = new File(currentDir, dirName);
            if (dir.exists()) {
                System.out.println();
                System.out.println(colors.RED + "Such Directory is Already Exists");
                System.out.println();
            } else {
                dir.mkdir();
                System.out.println(colors.YELLOW + "created successfully DIR " + colors.GREEN + dir);
            }
        } else {
            new Controller().pwd();
        }
    }

    public void createFile(BufferedReader reader) throws IOException {
        if (currentDir != null) {
            System.out.println();
            System.out.println("Current Directory is : " + currentDir.getAbsolutePath());
            System.out.println();
            System.out.println(colors.YELLOW + "Enter The File Name :");
            System.out.println();
            String fileName = reader.readLine();
            File file = new File(currentDir, fileName);
            if (file.exists()) {
                System.out.println();
                System.out.println(colors.RED + "Such File is Already Exists");
                System.out.println();
            } else {
                file.createNewFile();
                System.out.println();
                System.out.println(colors.YELLOW + "created successfully FILE " + colors.GREEN + file);
                System.out.println();
                System.out.println(file.getAbsolutePath());
            }
        } else {
            new Controller().pwd();
        }
    }

    public void rmFile(File filePath) {
        filePath.delete();
        System.out.println();
        System.out.println(colors.GREEN + "The File -----> " + colors.WHITE + filePath + colors.GREEN + " <----- Has Been DELETED");
        System.out.println();
    }

    public boolean rmDir(File dirPath) {
        File[] allContents = dirPath.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                rmDir(file);
                System.out.println(colors.GREEN + "The Directory -----> " + colors.WHITE + dirPath + colors.GREEN + " <----- Has Been DELETED");
            }
        }
        return dirPath.delete();
    }

    public void find(BufferedReader reader) throws IOException {
        if (currentDir != null) {
            System.out.println();
            System.out.println("Enter The Name of The File or of The Directory : ");
            System.out.println();
            String name = reader.readLine();
            File dir = currentDir;
            findHandler(name, dir);
        } else {
            new Controller().pwd();
        }
    }

    public void findHandler(String name, File dir) {
        File targetDir = dir;
        File[] list = dir.listFiles();
        if (list != null) {
            for (File f : list) {
                if (f.getName().equals(name)) {
                    System.out.println();
                    System.out.println(colors.GREEN + "-------> " + colors.BLUE + name + colors.PURPLE + " <------- Has Been Found in The Directory" + targetDir.getAbsolutePath());
                    System.out.println();
                    break;
                }
                if (f.isDirectory() && !f.getName().equals(name)) {
                    findHandler(name, f);
                }
            }
        } else {
            System.out.println(colors.RED + "Such File or Directory Not Found");
        }

    }

    public void findText(String text, File dir) throws IOException {
        if (currentDir != null) {
            Map<String, String> textMap = new HashMap<>();
            File[] list = dir.listFiles();
            if (list != null) {
                for (File f : list) {
                    if (f.isDirectory()) {
                        findText(text, f);
                    } else if (f.isFile()) {
                        textMap.put(f.getAbsolutePath(), textFounder(f));
                    }
                }
            }
            for (String s : textMap.keySet()) {
                if (textMap.get(s).contains(text)) {
                    System.out.println(colors.GREEN + "The Text -----> " + colors.PURPLE + text + colors.GREEN + " <----- Was Found at There " + s);
                }
            }
        } else {
            new Controller().pwd();
        }
    }

    private String textFounder(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }

}


