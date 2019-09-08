package co.edu.konradlorenz.dto;

import java.io.Serializable;

public class Data implements Serializable {

    private String video;

    public Data() {
    }

    public Data(String video) {
        this.video = video;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
