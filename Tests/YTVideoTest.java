import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class YTVideoTest
{
    //URL Test Cases
    @Test
    void hasCurrentProgress()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=U6Z8FkjGEb4&t=2s");
        assertTrue(yt.getUrl().matches(".*(t=).*"));
    }

    @Test
    void hasNoProgress()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=U6Z8FkjGEb4");
        assertFalse(yt.getUrl().matches(".*(t=).*"));
    }

    @Test
    void urlIsYoutube()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=U6Z8FkjGEb4&t=2s");
        assertTrue(yt.getUrl().matches(".*(www\\.youtube\\.com/watch).*"));
    }

    @Test
    void urlIsntYoutube()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youboot.com/watch?v=U6Z8FkjGEb4&t=2s");
        assertFalse(yt.getUrl().matches(".*(www\\.youtube\\.com/watch).*"));
    }

    @Test
    void dosomething()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youboot.com/watch?v=U6Z8FkjGEb4&t=2s");
        assertFalse(yt.getUrl().matches(".*(www\\.youtube\\.com/watch).*"));
    }



}