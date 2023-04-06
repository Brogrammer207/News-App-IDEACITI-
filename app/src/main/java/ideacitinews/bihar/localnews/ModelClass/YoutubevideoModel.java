package ideacitinews.bihar.localnews.ModelClass;

public class YoutubevideoModel {

    public String title;
    public String url;
    public String videoimage;

    public YoutubevideoModel(String title,String url,String videoimage)
    {
        this.title = title;
        this.url = url;
        this.videoimage = videoimage;
    }
    public YoutubevideoModel()
    {

    }
        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    public String getVideoimage() {
        return videoimage;
    }

    public void setVideoimage(String videoimage) {
        this.videoimage = videoimage;
    }
}
