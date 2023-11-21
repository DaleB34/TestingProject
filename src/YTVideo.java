public class YTVideo
{
    //instantiate variables
    public String title;
    public String url;
    public String time; //in seconds


    //constructors

    public YTVideo(String title, String url, String length) {
        this.title = title;
        this.url = url;
        this.time = length;
    }

    public YTVideo() {
        title = "";
        url = "";
        time = "";
    }


    //getters
    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getTime() {
        return time;
    }

    //setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTime(String length) {
        this.time = length;
    }
}
