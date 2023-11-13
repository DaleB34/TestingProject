public class YTVideo
{
    //instantiate variables
    public String title;
    public String url;
    public int length; //in seconds


    //constructors

    public YTVideo(String title, String url, int length) {
        this.title = title;
        this.url = url;
        this.length = length;
    }

    public YTVideo() {
        title = "";
        url = "";
        length = 0;
    }


    //getters
    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public int getLength() {
        return length;
    }

    //setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
