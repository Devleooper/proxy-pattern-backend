package co.edu.konradlorenz.subject.impl;

import co.edu.konradlorenz.subject.Video;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

public class RealVideo implements Video {

    private String videoName;

    private static String DATA_TYPE_CONSTANT = "data:video/mp4;base64,%s";

    public RealVideo(String videoName) {
        this.videoName = videoName;
    }

    @Override
    public String loadSampleVideo() {
        return String.format(DATA_TYPE_CONSTANT , loadStub(videoName));
    }

    @Override
    public String loadFullVideo() {
        return String.format(DATA_TYPE_CONSTANT , loadStub(videoName));
    }

    private String loadStub(String videoName) {
        String base64encode = "";
        String filePath = String.format("D:" + File.separator + "example-videos" + File.separator + "%s", videoName) + ".mp4";
        File file = new File(filePath);

        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {

                byte[] videoData = new byte[(int) file.length()];

                fis.read(videoData);
                base64encode = Base64.getEncoder().encodeToString(videoData);

            } catch (FileNotFoundException ex) {
                System.out.println("video not found" + filePath + " : " + ex);
            } catch (IOException ex) {
                System.out.println("An error ocurred reading the image" + " : " + ex);
            }


        }

        return base64encode;
    }
}
