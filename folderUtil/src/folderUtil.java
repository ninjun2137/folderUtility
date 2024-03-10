import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.*;

public class folderUtil {
    public static void main(String[] args) {
        while (true) {
            Scanner reader = new Scanner(System.in);
            System.out.println("JAVA FOLDER UTILITY TOOL:");
            System.out.println("1 - Flatten COPY (Specify ROOT folder. Program will copy all files from underlying folder to specified folder)");
            System.out.println("2 - Flatten CUT (Specify ROOT folder. Program will cut all files from underlying folder to specified folder)");
            System.out.print("SELECT: ");
            String input = reader.nextLine();
            switch (input) {
                case "1", "2" -> {
                    System.out.print("Please input ROOT: ");
                    String root = reader.nextLine();
                    System.out.print("Please input destination: ");
                    String destination = reader.nextLine();
                    if (flatten(root, input, destination)) {
                        System.out.println("Flattened successfully");
                    } else {
                        System.out.println("Error while flattening");
                    }
                }
                default -> {
                    return;
                }
            }


        }
    }

    public static boolean flatten(String path, String method, String destination) {
        try {
            List<Path> pathList;
            try (Stream<Path> walk = Files.walk(Paths.get(path))) {
                pathList = walk.filter(Files::isRegularFile).collect(Collectors.toList());
            }
            for (Path p : pathList) {
                if(p.getParent().toString().equals(path) && path.equals(destination)){
                    continue;
                }
                if (!p.getParent().toString().equals(path))
                    Files.copy(p.toAbsolutePath(), Paths.get(destination+"/"+p.getFileName()), REPLACE_EXISTING);

                if(method.equals("2")){
                    if (!p.toString().equals(path) && !p.getParent().toString().equals(path))
                        Files.delete(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
}
