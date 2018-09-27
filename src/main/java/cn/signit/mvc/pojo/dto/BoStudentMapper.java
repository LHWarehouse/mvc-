package cn.signit.mvc.pojo.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.generator.tables.pojos.Students;

import cn.signit.mvc.pojo.bo.req.BoAddStudentReq;
import cn.signit.mvc.pojo.bo.req.BoUpdateStudentReq;
import cn.signit.mvc.pojo.bo.resp.BoAddStudentResp;
import cn.signit.mvc.pojo.bo.resp.BoGetStudentResp;
import cn.signit.mvc.pojo.bo.resp.BoUpdateStudentResp;

@Mapper
public interface BoStudentMapper {
    
    BoStudentMapper INSTANCE = Mappers.getMapper(BoStudentMapper.class);

    Students toStudent(BoAddStudentReq boAddStudentReq);

    Students toStudent(BoUpdateStudentReq boUpdateStudentReq);

    BoAddStudentResp toBoAddStudentResp(Students students);

    BoGetStudentResp toBoGetStudentResp(Students students);

    BoUpdateStudentResp toBoUpdateStudentResp(Students students);

    List<BoGetStudentResp> toBoGetStudentResps(List<Students> students);
}
