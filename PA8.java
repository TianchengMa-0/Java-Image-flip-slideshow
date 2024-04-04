import java.awt.Color;

public class PA8 {

    // ------------------------------------------------------------------------
    // Tests
    // ------------------------------------------------------------------------


    public static void testHorizontalFlip()
    {
        Image img1 = new Image("res/pixel-heart.png");
        img1.explore();
        int w = img1.getWidth();
        int h = img1.getHeight();
        img1.flipHorizontalRect(0,0,(int)w/2 ,(int)h);
        img1.explore();
        //Original test

        Image img2 = new Image("res/jinx.PNG");
        img2.explore();
        int w2 = img2.getWidth();
        int h2 = img2.getHeight();
        img2.flipHorizontalRect(100,100,200 ,200);
        img2.explore();

    }
    public static void testcustomFilter()
    {
        Image img1 = new Image("res/yi.jpg");
        img1.explore();
        int w1 = img1.getWidth();
        int h1 = img1.getHeight();
        img1.customFilter(-10,-10,(int)w1/2 ,(int)h1);
        img1.explore();

        Image img2 = new Image("res/vn.jpg");
        img2.explore();
        int w2 = img2.getWidth();
        int h2 = img2.getHeight();
        img2.customFilter(10,50,(int)w2*2 ,(int)h2*3);
        img2.explore();

        Image img3 = new Image("res/pixel-heart.png");
        img3.explore();
        int w3 = img3.getWidth();
        int h3 = img3.getHeight();
        img3.customFilter(10,50,(int)w3/2 ,(int)h3-300);
        img3.explore();
    }
    //TODO : Add test method for your custom filter

    // ------------------------------------------------------------------------
    // Main Method
    // ------------------------------------------------------------------------

    public static void main(String[] args) {

      //  testHorizontalFlip();
        testcustomFilter();

        // TODO: Call the test method for your custom filter

    }
}
