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
    void urlIsNormalYoutube()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=U6Z8FkjGEb4&t=2s");
        assertTrue(yt.getUrl().matches(".*(www\\.youtube\\.com/watch).*"));
    }

    @Test
    void urlIsntNormalYoutube()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youboot.com/watch?v=U6Z8FkjGEb4&t=2s");
        assertFalse(yt.getUrl().matches(".*(www\\.youtube\\.com/watch).*"));
    }

    @Test
    void isAnyYoutubeLink() //because there are youtu.be links
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://youtu.be/zWh3CShX_do?si=PGuK2LO21klWO8wl&t=80");
        assertTrue(yt.getUrl().matches(".*youtu(\\.be|be\\.com).*"));
    }


    @Test
    void isAnyYoutubeLinkNormal()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=U6Z8FkjGEb4&t=2s");
        assertTrue(yt.getUrl().matches(".*youtu(\\.be|be\\.com).*"));
    }

    @Test
    void isNotAnyYTLink()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("yuotu.be.com/msrioux");
        assertFalse(yt.getUrl().matches(".*youtu(\\.be|be\\.com).*"));
    }

    @Test
    void isYTLinkAbnormal()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("youtubecomyoutubcom.com.com.com.youtube.");
        assertFalse(yt.getUrl().matches(".*youtu(\\.be|be\\.com).*"));
    }

    @Test
    void isVideoWithTimeStamp()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=U6Z8FkjGEb4&t=2s");
        assertTrue(yt.getUrl().matches(".*(v=){1}.*(t=){1}.*"));
    }

    @Test
    void isVideoWithoutTimeStamp()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=U6Z8FkjGEb4");
        assertFalse(yt.getUrl().matches(".*(v=){1}.*(t=){1}.*"));
    }

    @Test
    void validSigns()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=U6Z8FkjGEb4");
        assertFalse(yt.getUrl().matches(".*[!@#$%^&*()\\[\\];',|<>\"{}\\-+`~].*"));
        //only valid signs that are in a youtube link are - _ / = . :
    }

    @Test
    void invalidSigns()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("youtube.com/watch?v=U67432498$$$!@@#");
        assertTrue(yt.getUrl().matches(".*[!@#$%^&*()\\[\\];',|<>\"{}\\-+`~].*"));
        //only valid signs that are in a youtube link are - _ / = . :
    }

    @Test
    void startsWithHttp()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=U6Z8FkjGEb4");
        assertTrue(yt.getUrl().matches("^http.*"));
    }

    @Test
    void doesntStartWithHttp()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("www.youtube.com/watch?v=U6Z8FkjGEb4");
        assertFalse(yt.getUrl().matches("^http.*"));
    }

    @Test
    void chanceOfRickRoll()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        assertTrue(yt.getUrl().matches(".*(dQw4w9WgXcQ).*"));
        //dont take any chances with any link
    }

    @Test
    void NoChanceOfRickRoll()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("www.youtube.com/watch?v=U6Z8FkjGEb4");
        assertFalse(yt.getUrl().matches(".*(dQw4w9WgXcQ).*"));
        //dont take any chances with any link
    }

    @Test
    void isChannelLink()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/channel/UCu9UrE6gUL36T9M4fnc7RjA");
        assertTrue(yt.getUrl().matches(".*(channel){1}.*"));
    }

    @Test
    void isNotChannelLink()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        assertFalse(yt.getUrl().matches(".*(channel){1}.*"));
    }

    @Test
    void isHomeScreen()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/?bp=wgUCEAE%3D");
        assertTrue(yt.getUrl().matches(".*(\\?bp=){1}.*"));
    }

    @Test
    void isNotHomeScreen()
    {
        YTVideo yt = new YTVideo();
        yt.setUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        assertFalse(yt.getUrl().matches(".*(\\?bp=){1}.*"));
    }






}