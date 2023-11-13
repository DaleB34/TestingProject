import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class YTVideoTest
{

    @Test
    void timeThresholdValid()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=yFLg-pGPSBA");
        yt.setLength(1433);
        int currentTime = 453;
        assertTrue(currentTime < yt.getLength());
    }

    @Test
    void overTimeThreshold()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=yFLg-pGPSBA");
        yt.setLength(1433);
        int currentTime = 1500;
        assertFalse(currentTime < yt.getLength());
    }

    @Test
    void hasCurrentProgress()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=U6Z8FkjGEb4$t=2s");
        assertTrue(yt.getUrl().matches(".*(t=).*"));
    }
    @Test
    void has()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("t=");
        assertTrue(yt.getUrl().matches(".*(t=).*"));
    }

    @Test
    void isVideo()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com");
        assertFalse(yt.getUrl().contains("v="));
    }

    @Test
    void firstCharacterUpper()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("Your Mom");
        assertTrue(yt.getUrl().matches(""));
    }

}