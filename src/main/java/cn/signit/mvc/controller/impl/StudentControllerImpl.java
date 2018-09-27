package cn.signit.mvc.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cn.signit.mvc.controller.StudentController;
import cn.signit.mvc.pojo.bo.resp.BoAddStudentResp;
import cn.signit.mvc.pojo.bo.resp.BoGetStudentResp;
import cn.signit.mvc.pojo.bo.resp.BoUpdateStudentResp;
import cn.signit.mvc.pojo.dto.VoStudentMapper;
import cn.signit.mvc.pojo.vo.VoResponseBody;
import cn.signit.mvc.pojo.vo.req.VoAddStudentReq;
import cn.signit.mvc.pojo.vo.req.VoUpdateStudentReq;
import cn.signit.mvc.pojo.vo.resp.VoAddStudentResp;
import cn.signit.mvc.pojo.vo.resp.VoGetStudentResp;
import cn.signit.mvc.pojo.vo.resp.VoUpdateStudentResp;
import cn.signit.mvc.service.StudentService;

@RestController
public class StudentControllerImpl implements StudentController {
    
    //@PostMapping("/students")
    //@ResponseStatus(HttpStatus.CREATED)
    public VoAddStudentReq test(@RequestBody VoAddStudentReq voAddStudentReq) {
        
        System.out.println(voAddStudentReq.getBirth());
        
        return voAddStudentReq;
    }
    
    /**
     * 
     * 正式开始
     */
    
    @Autowired
    private StudentService studentService;
    
    /**
     * 根据id查询指定id的记录
     * @param id
     * @return
     */
    @GetMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VoResponseBody<VoGetStudentResp> getStudent(@PathVariable("id")Integer id){
        VoResponseBody<VoGetStudentResp> response = new VoResponseBody<VoGetStudentResp>();
        List<VoGetStudentResp> list = new ArrayList<VoGetStudentResp>();
        
        BoGetStudentResp result = studentService.getStudent(id);
        VoGetStudentResp voGetStudentResp = VoStudentMapper.INSTANCE.toVoGetStudentResp(result);
        list.add(voGetStudentResp);
        
        response.setStatus(200);
        response.setMsg("获取成功");
        response.setData(list);
        return response;
        
    }
    
    /**
     * 查询一个记录列表
     * @param vo
     * @return
     */
    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public VoResponseBody<VoGetStudentResp> getStudents() {
        VoResponseBody<VoGetStudentResp> response = new VoResponseBody<VoGetStudentResp>();
        
        List<BoGetStudentResp> results = studentService.getStudents();
        List<VoGetStudentResp> voGetStudentResps = VoStudentMapper.INSTANCE.toVoGetStudentResps(results);
        
        response.setStatus(200);
        response.setMsg("获取成功");
        response.setData(voGetStudentResps);
        
        return response;
    }
    
    /**
     * 根据id来更新相应字段
     * @param id
     * @param 
     * @return
     */
    @PutMapping("/students/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public VoResponseBody<VoUpdateStudentResp> updateStudent(@PathVariable("id")Integer id,
            @RequestBody VoUpdateStudentReq voUpdateStudentReq){
        VoResponseBody<VoUpdateStudentResp> response = new VoResponseBody<VoUpdateStudentResp>();
        List<VoUpdateStudentResp> list = new ArrayList<VoUpdateStudentResp>();
        
        BoUpdateStudentResp result = studentService.updateStudent(VoStudentMapper.INSTANCE.toBoUpdateStudentReq(voUpdateStudentReq));
        VoUpdateStudentResp voUpdateStudentResp = VoStudentMapper.INSTANCE.toVoUpdateStudentResp(result);
        list.add(voUpdateStudentResp);
        
        response.setStatus(200);
        response.setMsg("获取成功");
        response.setData(list);
        
        return response;
        
    }
    
    /**
     * 在数据表中插入一行
     * @param voAddAuthorReq
     * @return
     */
    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public VoResponseBody<VoAddStudentResp> addStudent(
            @RequestBody VoAddStudentReq voAddStudentReq){
        VoResponseBody<VoAddStudentResp> response = new VoResponseBody<VoAddStudentResp>();
        List<VoAddStudentResp> list = new ArrayList<VoAddStudentResp>();
        
        BoAddStudentResp result = studentService.addStudent(VoStudentMapper.INSTANCE.toBoAddStudentReq(voAddStudentReq));
        VoAddStudentResp voAddStudentResp = VoStudentMapper.INSTANCE.toVoAddStudentResp(result);
        list.add(voAddStudentResp);
        
        response.setStatus(200);
        response.setMsg("获取成功");
        response.setData(list);
        
        return response;
        
    } 
    
    /**
     * 删除指定id的行
     * @param id
     */
    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("id")Integer id) {
        studentService.deleteStudent(id);
    }
    
}
