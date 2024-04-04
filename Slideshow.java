import java.util.Scanner;
public class Slideshow{
  public Sound[] sounds;
  public Image[] pictures;


  public Slideshow(){
    this.sounds = new Sound[0];
    this.pictures = new Image[0];
  }


  public void addSlide(Image newImg, Sound newSound){

    Sound[] CopySound = new Sound[this.sounds.length+1];
    for (int i=0;i<CopySound.length-1;i++){
      CopySound[i]=this.sounds[i];
    }
    Image[] CopyImage = new Image[this.pictures.length+1];
    for (int i=0;i<CopyImage.length-1;i++){
      CopyImage[i]=this.pictures[i];
    }


    CopySound[this.sounds.length]=newSound;
    CopyImage[this.pictures.length]=newImg;
    this.sounds = CopySound;
    this.pictures = CopyImage;

  }


  public void play(){
    for (int i = 0; i < this.sounds.length; i++){
      this.pictures[i].show();
      this.sounds[i].blockingPlay();
    }
  }


  public static void main(String[] args) {
    Sound sounds1=new Sound("res/UpbeatFunk.wav");
    Image pictures1=new Image("res/yi.jpg");
    Sound sounds2=new Sound("res/wind.wav");
    Image pictures2=new Image("res/vn.jpg");
    Sound sounds3=new Sound("res/bbc.wav");
    Image pictures3=new Image("res/jinx.PNG");
    Slideshow newSlide = new Slideshow();
    newSlide.addSlide(pictures1,sounds1);
    newSlide.addSlide(pictures2,sounds2);
    newSlide.addSlide(pictures3,sounds3);
    newSlide.play();
    Scanner scnr=new Scanner(System.in);
    System.out.println("Do you want to play the slide again? Answer YES or NO.");
    String answer=scnr.next();
    while (answer.equals("YES")){
      newSlide.play();
      System.out.println("Do you want to play the slide again? Answer YES or NO.");
      answer=scnr.next();
    }
    if (answer.equals("NO")){
      System.exit(0);
    }
  }
}
