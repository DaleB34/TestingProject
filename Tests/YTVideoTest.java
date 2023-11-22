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


    //All Time test cases

    @Test
    void noOnes()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("110");
        assertTrue(yt.getTime().matches(".*0$"));
        //checks if there is an amount in the ones place of the time
    }

    @Test
    void isOnes()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("111");
        assertFalse(yt.getTime().matches(".*0$"));
        //checks if there is an amount in the ones place of the time
    }

    @Test
    void isTens()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("163");
        assertTrue(yt.getTime().matches("[0-9]*([6-9][0-9])$"));
        //checks if there is an amount in the tens place of time
    }

    @Test
    void noTens()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("140");
        assertFalse(yt.getTime().matches("[0-9]*([6-9][0-9])$"));
        //checks if there is an amount in the tens place of time
    }

    @Test
    void hasLetters()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("140a");
        assertTrue(yt.getTime().matches(".*[A-Za-z].*"));
    }

    @Test
    void noLetters()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("140");
        assertFalse(yt.getTime().matches(".*[A-Za-z].*"));
    }

    @Test
    void timeIsCool()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("11111");
        String char1 = yt.getTime().charAt(0) + "";
        assertTrue(yt.getTime().matches(char1 + "{" + yt.getTime().length() + "}"));
    }

    @Test
    void timeIsLame()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("11211");
        String char1 = yt.getTime().charAt(0) + "";
        assertFalse(yt.getTime().matches(char1 + "{" + yt.getTime().length() + "}"));
    }

    @Test
    void moreThanOneZero()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("140000");
        assertTrue(yt.getTime().matches(".*0{2}"));
    }

    @Test
    void oneZeroOrLess()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("140");
        assertFalse(yt.getTime().matches(".*0{2}"));
    }

    @Test
    void noUselessZero()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("140");
        String char1 = yt.getTime().charAt(0) + "";
        assertFalse(char1.matches("^[^1-9].*"));
    }

    @Test
    void hasUselessZero()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("040");
        String char1 = yt.getTime().charAt(0) + "";
        assertTrue(char1.matches("^[^1-9].*"));
    }

    @Test
    void startSameAsEnd()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("140001");
        String char1 = yt.getTime().charAt(0) + "";
        assertTrue(yt.getTime().matches(".*" + char1 + "$"));
    }

    @Test
    void startNotSameAsEnd()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("140000");
        String char1 = yt.getTime().charAt(0) + "";
        assertFalse(yt.getTime().matches(".*" + char1 + "$"));
    }


    @Test
    void anyOddNumbers()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("140000");
        assertTrue(yt.getTime().matches(".*[13579].*"));
    }

    @Test
    void NoOddNumbers()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("24680");
        assertFalse(yt.getTime().matches(".*[13579].*"));
    }

    @Test
    void anyEvenNumbers()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("135792");
        assertTrue(yt.getTime().matches(".*[02468].*"));
    }

    @Test
    void NoEvenNumbers()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("13579");
        assertFalse(yt.getTime().matches(".*[02468].*"));
    }

    @Test
    void hasMessage()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("101134");//hello on a calculator
        assertTrue(yt.getTime().matches(".*(01134).*"));
    }

    @Test
    void hasNoMessage()
    {
        YTVideo yt = new YTVideo();
        yt.setTime("43131241231241231241230214012030124");//hello on a calculator
        assertFalse(yt.getTime().matches(".*(01134).*"));
    }

    //all Title test cases

}