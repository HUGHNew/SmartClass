package zrkc.group.javabean;

import java.awt.*;

public class ShowImg {
    Image img;
    String name;

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ShowImg{" +
                "img=" + img +
                ", name='" + name + '\'' +
                '}';
    }
}
