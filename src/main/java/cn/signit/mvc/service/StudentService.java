package cn.signit.mvc.service;

import java.util.List;

import cn.signit.mvc.pojo.bo.req.BoAddStudentReq;
import cn.signit.mvc.pojo.bo.req.BoUpdateStudentReq;
import cn.signit.mvc.pojo.bo.resp.BoAddStudentResp;
import cn.signit.mvc.pojo.bo.resp.BoGetStudentResp;
import cn.signit.mvc.pojo.bo.resp.BoUpdateStudentResp;

public interface StudentService {
    public BoGetStudentResp getStudent(Integer id);

    public List<BoGetStudentResp> getStudents();

    public BoUpdateStudentResp updateStudent(BoUpdateStudentReq boUpdateStudentReq);

    public BoAddStudentResp addStudent(BoAddStudentReq boAddStudentReq);

    public Boolean deleteStudent(Integer id);
}
