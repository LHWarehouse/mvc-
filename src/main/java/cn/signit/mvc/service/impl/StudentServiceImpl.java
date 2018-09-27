package cn.signit.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generator.tables.pojos.Students;

import cn.signit.mvc.dao.StudentMapper;
import cn.signit.mvc.pojo.bo.req.BoAddStudentReq;
import cn.signit.mvc.pojo.bo.req.BoUpdateStudentReq;
import cn.signit.mvc.pojo.bo.resp.BoAddStudentResp;
import cn.signit.mvc.pojo.bo.resp.BoGetStudentResp;
import cn.signit.mvc.pojo.bo.resp.BoUpdateStudentResp;
import cn.signit.mvc.pojo.dto.BoStudentMapper;
import cn.signit.mvc.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
    
    @Autowired
    private StudentMapper  studentMapper;
    
    /**
     * 查
     * @param id
     * @return
     */
    @Override
    public BoGetStudentResp getStudent(Integer id) {
        Students result = studentMapper.getStudent(id);
        
        return BoStudentMapper.INSTANCE.toBoGetStudentResp(result);    
    }
    
    /**
     * 查所有
     * @return
     */
    @Override
    public List<BoGetStudentResp>  getStudents(){
        List<Students> results = studentMapper.getStudents();
        return BoStudentMapper.INSTANCE.toBoGetStudentResps(results);
    }
    
    /**
     * 更新
     * @param boUpdateStudentReq
     * @return
     */
    @Override
    public BoUpdateStudentResp updateStudent(BoUpdateStudentReq boUpdateStudentReq) {
        Students result = studentMapper.updateStudent(BoStudentMapper.INSTANCE.toStudent(boUpdateStudentReq));
        return BoStudentMapper.INSTANCE.toBoUpdateStudentResp(result);
    }
    
    /**
     * 增
     * @param boAddStudentReq
     * @return
     */
    @Override
    public BoAddStudentResp addStudent(BoAddStudentReq boAddStudentReq) {
        Students result = studentMapper.addStudent(BoStudentMapper.INSTANCE.toStudent(boAddStudentReq));
        return BoStudentMapper.INSTANCE.toBoAddStudentResp(result);
    }
    
    /**
     * 删
     * @param id
     * @return
     */
    @Override
    public Boolean deleteStudent(Integer id) {
        Boolean result = studentMapper.deleteStudent(id);
        return result;
    }
}
