public class YTVideo
{
    //instantiate variables
    public String title;
    public String url;
    public String length; //in hours:minutes:seconds


    //constructors

    public YTVideo(String title, String url, String length) {
        this.title = title;
        this.url = url;
        this.length = length;
    }

    public YTVideo() {
        title = "";
        url = "";
        length = "00:00:00";
    }


    //getters
    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getLength() {
        return length;
    }

    //setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
