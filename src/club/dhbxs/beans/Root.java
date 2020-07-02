package club.dhbxs.beans;

/**
 * @author ：17235
 * @date ：Created in 2020/6/27 下午 3:49
 * @description：
 * @version: 1.0
 */
public class Root {

    /**
     * 管理员ID
     */
    private Integer rId;

    /**
     * 管理员用户名
     */
    private String rName;

    /**
     * 管理员密码
     */
    private String rPassword;

    private String rEmail;

    public Root() {
    }

    public Root(Integer rId, String rName, String rPassword, String rEmail) {
        this.rId = rId;
        this.rName = rName;
        this.rPassword = rPassword;
        this.rEmail = rEmail;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrPassword() {
        return rPassword;
    }

    public void setrPassword(String rPassword) {
        this.rPassword = rPassword;
    }

    public String getrEmail() {
        return rEmail;
    }

    public void setrEmail(String rEmail) {
        this.rEmail = rEmail;
    }

    @Override
    public String toString() {
        return "Root{" +
                "rId=" + rId +
                ", rName='" + rName + '\'' +
                ", rPassword='" + rPassword + '\'' +
                ", rEmail='" + rEmail + '\'' +
                '}';
    }
}
