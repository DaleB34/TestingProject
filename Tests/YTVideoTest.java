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
    void noCurrentProgress()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=yFLg-pGPSBA");
        yt.setLength(1433);
        int currentTime = 1500;
        assertFalse(currentTime < yt.getLength());
    }

}