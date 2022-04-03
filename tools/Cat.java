package tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

class Cat {
  public static void main(String[] args) {
    File outFile = new File(args[0]);
    try (OutputStream out = new FileOutputStream(outFile)) {
      for (int i = 1; i < args.length; i++) {
        String arg = args[i];
        if (arg.startsWith("<")) {
          Files.copy(Paths.get(arg.substring(1)), out);
        } else {
          out.write(arg.getBytes(StandardCharsets.UTF_8));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
