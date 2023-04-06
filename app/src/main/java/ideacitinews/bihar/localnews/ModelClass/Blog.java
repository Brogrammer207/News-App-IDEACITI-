package ideacitinews.bihar.localnews.ModelClass;

/**
 * Created by manish on 29/7/18.
 */

public class Blog {

    private String title;
    private String image;
    private String desc1;
    private String desc2;
    private String desc3;
    private String id;

    public Blog(String title, String image, String desc1, String desc2, String desc3){
        this.title = title;
        this.image = image;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.desc3 = desc3;

    }

    public Blog() {
        //this constructor is required
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getDesc3() {
        return desc3;
    }

    public void setDesc3(String desc3) {
        this.desc3 = desc3;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
