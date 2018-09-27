package cn.signit.mvc.pojo.vo.req;

import java.util.Date;

public class VoAddStudentReq {
    private Integer id;
    private String name;
    private String sex;
    
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birth;
    private String phone;
    private String addr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public VoAddStudentReq(Integer id, String name, String sex, Date birth, String phone, String addr) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.phone = phone;
        this.addr = addr;
    }

    public VoAddStudentReq() {
        super();
        // TODO Auto-generated constructor stub
    }

}
