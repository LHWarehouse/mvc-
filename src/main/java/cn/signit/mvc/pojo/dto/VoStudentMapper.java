package cn.signit.mvc.pojo.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cn.signit.mvc.pojo.bo.req.BoAddStudentReq;
import cn.signit.mvc.pojo.bo.req.BoUpdateStudentReq;
import cn.signit.mvc.pojo.bo.resp.BoAddStudentResp;
import cn.signit.mvc.pojo.bo.resp.BoGetStudentResp;
import cn.signit.mvc.pojo.bo.resp.BoUpdateStudentResp;
import cn.signit.mvc.pojo.vo.req.VoAddStudentReq;
import cn.signit.mvc.pojo.vo.req.VoUpdateStudentReq;
import cn.signit.mvc.pojo.vo.resp.VoAddStudentResp;
import cn.signit.mvc.pojo.vo.resp.VoGetStudentResp;
import cn.signit.mvc.pojo.vo.resp.VoUpdateStudentResp;

@Mapper
public interface VoStudentMapper {
    VoStudentMapper INSTANCE = Mappers.getMapper(VoStudentMapper.class);

    /**
     * 还未映射
     * 
     * @param voAddStudentReq
     * @return
     */
    @Mapping(target = "birth", source = "birth", dateFormat = "yyyy-MM-dd")
    BoAddStudentReq toBoAddStudentReq(VoAddStudentReq voAddStudentReq);

    /**
     * 还未映射
     * 
     * @param voAddStudentReq
     * @return
     */
    BoUpdateStudentReq toBoUpdateStudentReq(VoUpdateStudentReq voUpdateStudentReq);

    /**
     * 还未映射
     * 
     * @param voAddStudentReq
     * @return
     */
    VoAddStudentResp toVoAddStudentResp(BoAddStudentResp boAddStudentResp);

    VoGetStudentResp toVoGetStudentResp(BoGetStudentResp boGetStudentResp);

    List<VoGetStudentResp> toVoGetStudentResps(List<BoGetStudentResp> boGetStudentResps);

    VoUpdateStudentResp toVoUpdateStudentResp(BoUpdateStudentResp boUpdateStudentResp);
}
