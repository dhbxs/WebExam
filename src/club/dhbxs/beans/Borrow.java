package club.dhbxs.beans;

import java.sql.Timestamp;

/**
 * @author ：17235
 * @date ：Created in 2020/6/27 下午 3:49
 * @description：
 * @version: 1.0
 */
public class Borrow {

    /**
     * 借阅ID
     */
    private Integer borrowId;

    /**
     * 用户ID
     */
    private Integer uId;

    /**
     * 书的ID
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
     * 借书日期
     */
    private Timestamp bBdate;

    /**
     * 还书日期
     */
    private Timestamp bRdate;

    /**
     * 当前状态
     */
    private String bState = "未还";

    public Borrow() {
    }

    public Borrow(Integer borrowId, Integer uId, Integer bId, String bName, String bAuthor, Timestamp bBdate, Timestamp bRdate, String bState) {
        this.borrowId = borrowId;
        this.uId = uId;
        this.bId = bId;
        this.bName = bName;
        this.bAuthor = bAuthor;
        this.bBdate = bBdate;
        this.bRdate = bRdate;
        this.bState = bState;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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

    public Timestamp getbBdate() {
        return bBdate;
    }

    public void setbBdate(Timestamp bBdate) {
        this.bBdate = bBdate;
    }

    public Timestamp getbRdate() {
        return bRdate;
    }

    public void setbRdate(Timestamp bRdate) {
        this.bRdate = bRdate;
    }

    public String getbState() {
        return bState;
    }

    public void setbState(String bState) {
        this.bState = bState;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowId=" + borrowId +
                ", uId=" + uId +
                ", bId=" + bId +
                ", bName='" + bName + '\'' +
                ", bAuthor='" + bAuthor + '\'' +
                ", bBdate=" + bBdate +
                ", bRdate=" + bRdate +
                ", bState='" + bState + '\'' +
                '}';
    }
}
