package notDefault;

public class Commercial {
    private String image;
    private String url;
    private int counter;

    public Commercial(String i, String url){
        image = i;
        this.url = url;
        counter = 0;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void incrementCounter() {
        counter++;
    }
}
