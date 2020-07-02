package club.dhbxs.beans;

/**
 * @author ：17235
 * @date ：Created in 2020/6/27 下午 3:48
 * @description：
 * @version: 1.0
 */
public class Book {

    /**
     * 图书ID
     */
    private Integer bId;

    /**
     * 书名
     */
    private String bName;

    /**
     * 作者
     */
    private String bAuthor;

    /**
     * 出版社
     */
    private String bPress;

    /**
     * 图片URL地址
     */
    private String bImg;

    /**
     * 库存数量
     */
    private Integer bNumber;

    /**
     * 已借阅数量
     */
    private Integer bBorrow;

    public Book() {
    }

    public Book(Integer bId, String bName, String bAuthor, String bPress, String bImg, Integer bNumber, Integer bBorrow) {
        this.bId = bId;
        this.bName = bName;
        this.bAuthor = bAuthor;
        this.bPress = bPress;
        this.bImg = bImg;
        this.bNumber = bNumber;
        this.bBorrow = bBorrow;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public String getbPress() {
        return bPress;
    }

    public void setbPress(String bPress) {
        this.bPress = bPress;
    }

    public String getbImg() {
        return bImg;
    }

    public void setbImg(String bImg) {
        this.bImg = bImg;
    }

    public Integer getbNumber() {
        return bNumber;
    }

    public void setbNumber(Integer bNumber) {
        this.bNumber = bNumber;
    }

    public Integer getbBorrow() {
        return bBorrow;
    }

    public void setbBorrow(Integer bBorrow) {
        this.bBorrow = bBorrow;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bId=" + bId +
                ", bName='" + bName + '\'' +
                ", bAuthor='" + bAuthor + '\'' +
                ", bPress='" + bPress + '\'' +
                ", bImg='" + bImg + '\'' +
                ", bNumber=" + bNumber +
                ", bBorrow=" + bBorrow +
                '}';
    }
}
