package co.edu.konradlorenz.subject.impl;

import co.edu.konradlorenz.subject.Video;

public class VideoProxy implements Video {

    private RealVideo video;

    private String current;

    public VideoProxy(RealVideo video) {
        this.video = video;
    }

    public void setVideo(RealVideo video) {
        this.video = video;
    }

    @Override
    public String loadSampleVideo() {
        if (video != null)
            return video.loadSampleVideo();
        else
            return current;
    }

    @Override
    public String loadFullVideo() {
        if (video != null)
            return video.loadFullVideo();
        else
            return current;
    }
}
