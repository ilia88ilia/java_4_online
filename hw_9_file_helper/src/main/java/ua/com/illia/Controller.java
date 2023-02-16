package ua.com.illia;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    static FileHandler fileHandler = new FileHandler();
    static Colors colors = new Colors();

    public void start() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println(colors.YELLOW + "========file-helper===file-helper===WELCOME TO FILE-HELPER========");
        String select;
        menu();
        while ((select = reader.readLine()) != null) {
            menuItems(reader, select);
        }
    }

    public void menu() {
        System.out.println(colors.PURPLE + "-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~--~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
        System.out.println(colors.PURPLE + "-~-~-~-~-~-" + colors.GREEN + "TO START THE FILE SYSTEM......................." + colors.CYAN + "Enter 1");
        System.out.println(colors.PURPLE + "-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~--~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
        System.out.println(colors.PURPLE + "-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~--~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
        System.out.println(colors.PURPLE + "-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~--~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
        System.out.println(colors.GREEN + "....................Exit...................." + colors.CYAN + "Enter 0" + colors.GREEN + "...............");
        System.out.println(colors.PURPLE + "---make your choice under this line-------------------------------");
    }

    public void menuItems(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1":
                workSpace(reader);
                break;
            case "0":
                exit();
                break;
        }
    }

    public void workSpace(BufferedReader reader) throws IOException {

        System.out.println();
        System.out.println(colors.BLUE + "Current Directory Enter.............................................." + colors.CYAN + "pwd");
        System.out.println(colors.BLUE + "Observe the Current Directory Enter.................................." + colors.CYAN + "ls");
        System.out.println(colors.BLUE + "List of all files and directories in current directory Enter........." + colors.CYAN + "ll");
        System.out.println(colors.BLUE + "To Enter The Existing Directory Enter................................" + colors.CYAN + "cd");
        System.out.println(colors.BLUE + "To Create The Directory Enter........................................" + colors.CYAN + "mkdir");
        System.out.println(colors.BLUE + "To Create The File Enter............................................." + colors.CYAN + "cat");
        System.out.println(colors.BLUE + "Delete file or directory in current directory Enter.................." + colors.CYAN + "rm");
        System.out.println(colors.BLUE + "Replace file or directory from directory to directory Enter.........." + colors.CYAN + "mv");
        System.out.println(colors.BLUE + "Find The File or Directory in current directory Enter ..............." + colors.CYAN + "f");
        System.out.println(colors.BLUE + "Find TEXT In All Files or Directories in current directory Enter ...." + colors.CYAN + "ft");
        System.out.println(colors.BLUE + "Escape To Main MENU Enter............................................" + colors.CYAN + "home");
        System.out.println();
        String select = reader.readLine();
        if (select.equals("pwd")) {
            pwd();
            workSpace(reader);
        } else if (select.equals("ls")) {
            ls();
            workSpace(reader);
        } else if (select.equals("ll")) {
            ll();
            workSpace(reader);
        } else if (select.equals("cd")) {
            cd(reader);
            workSpace(reader);
        } else if (select.equals("mkdir")) {
            fileHandler.createDir(reader);
            workSpace(reader);
        } else if (select.equals("cat")) {
            fileHandler.createFile(reader);
            workSpace(reader);
        } else if (select.equals("rm")) {
            rm(reader);
            workSpace(reader);
        } else if (select.equals("mv")) {
            mv(reader);
            workSpace(reader);
        } else if (select.equals("f")) {
            fileHandler.find(reader);
            workSpace(reader);
        } else if (select.equals("ft")) {
            ft(reader);
            workSpace(reader);
        } else if (select.equals("home")) {
            menu();
        } else {
            workSpace(reader);
        }
    }

    public void pwd() {
        if (fileHandler.currentDir != null) {
            System.out.println(colors.GREEN + "Current Dir is : " + fileHandler.currentDir);
            System.out.println(fileHandler.currentDir.getAbsolutePath());
        }
        if (fileHandler.currentDir == null) {
            System.out.println(colors.GREEN + "Change The Directory");
            System.out.println("Directory <<<dir>>> Was Created By Default Enter : cd -------> dir");
        }
    }

    public void ls() {
        if (fileHandler.currentDir != null) {
            File[] files = fileHandler.currentDir.listFiles();
            for (File file : files) {
                System.out.println(colors.CYAN + file);
            }
        } else {
            pwd();
        }
    }

    public void ll() {
        if (fileHandler.currentDir != null) {
            System.out.println(fileHandler.currentDir.getAbsolutePath());
            System.out.println();
            File dir = fileHandler.currentDir;
            fileHandler.readDir(dir);
        } else {
            pwd();
        }
    }

    public void cd(BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println(colors.YELLOW + "Enter The Name Of Dir : ");
        System.out.println("-----for example-----");
        System.out.println("dir");
        System.out.println("dir/name");
        System.out.println("dir/name/name");
        System.out.println("-enter---------");
        System.out.println();
        File newDir = new File(reader.readLine());
        if (newDir.isDirectory()) {
            fileHandler.currentDir = newDir;
            System.out.println(colors.GREEN + fileHandler.currentDir.getAbsolutePath());
        } else if (fileHandler.currentDir == null) {
            pwd();
        } else {
            System.out.println(colors.RED + "Such Directory Not Found");
        }

    }

    public void rm(BufferedReader reader) throws IOException {
        if (fileHandler.currentDir != null) {
            System.out.println();
            System.out.println("Current Directory is : " + fileHandler.currentDir.getAbsolutePath());
            System.out.println();
            ls();
            System.out.println();
            System.out.println(colors.YELLOW + "Enter The File or The Directory Name to REMOVE :");
            System.out.println();
            File dirName = new File(reader.readLine());
            if (dirName.toString().equals("dir")) {
                System.out.println(colors.RED + "You Can't Remove This Directory");
                System.out.println(colors.RED + "This is a Directory By Default");
                rm(reader);
            } else {
                if (dirName.isDirectory()) {
                    fileHandler.rmDir(dirName);
                } else if (dirName.isFile()) {
                    fileHandler.rmFile(dirName);
                } else {
                    System.out.println(colors.RED + "Such File or Directory Not Found");
                }
            }
        } else {
            pwd();
        }
    }

    public void mv(BufferedReader reader) throws IOException {
        if (fileHandler.currentDir != null) {
            ll();
            System.out.println();
            System.out.println(colors.GREEN + "Enter The Name Where to Copy FROM :");
            System.out.println();
            File fromDir = new File(reader.readLine());
            if (fromDir.exists()) {
                ls();
                System.out.println();
                System.out.println(colors.GREEN + "Enter The Name Copy TO Where :");
                System.out.println();
                File toDir = new File(reader.readLine());
                fromDir.renameTo(new File(String.valueOf(toDir)));
            } else {
                System.out.println(colors.RED + "Such File or Directory Not Found");
            }
        } else {
            pwd();
        }
    }

    public void ft(BufferedReader reader) throws IOException {
        if (fileHandler.currentDir != null) {
            System.out.println();
            System.out.println("Enter The Text For Searching : ");
            System.out.println();
            String text = reader.readLine();
            File dir = fileHandler.currentDir;
            fileHandler.findText(text, dir);
        } else {
            pwd();
        }
    }

    public void exit() {
        System.exit(0);
    }

}
