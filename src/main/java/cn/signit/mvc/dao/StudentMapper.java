package cn.signit.mvc.dao;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.generator.tables.pojos.Students;

public interface StudentMapper {
    /**
     * 根据id查询学生信息
     * @param id
     * @return 学生对象
     */
    Students getStudent(@Valid @NotNull Integer id);
    /**
     * 添加学生
     * @param students
     * @return 学生对象
     */
    Students addStudent(@Valid @NotNull Students students);
    
    /**
     * 更新学生
     * @param students
     * @return 学生对象
     */
    Students updateStudent(@Valid @NotNull Students students);
    
    /**
     * 删除学生
     * @param id
     * @return bool类型 
     */
    Boolean deleteStudent(@Valid @NotNull Integer id);
    
    /**
     * 获取所有学生资料
     * @return 学生对象集合
     */
    List<Students> getStudents();
}
