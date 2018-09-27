package cn.signit.mvc.controller;

import cn.signit.mvc.pojo.vo.VoResponseBody;
import cn.signit.mvc.pojo.vo.req.VoAddStudentReq;
import cn.signit.mvc.pojo.vo.req.VoUpdateStudentReq;
import cn.signit.mvc.pojo.vo.resp.VoAddStudentResp;
import cn.signit.mvc.pojo.vo.resp.VoGetStudentResp;
import cn.signit.mvc.pojo.vo.resp.VoUpdateStudentResp;

public interface StudentController {
    public VoResponseBody<VoGetStudentResp> getStudent(Integer id);
    
    public VoResponseBody<VoGetStudentResp> getStudents();
    
    public VoResponseBody<VoUpdateStudentResp> updateStudent(Integer id,
            VoUpdateStudentReq voUpdateStudentReq);
    
    public VoResponseBody<VoAddStudentResp> addStudent(
            VoAddStudentReq voAddStudentReq);
    
    public void deleteStudent(Integer id);
}
