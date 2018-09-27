package cn.signit.mvc.dao.impl;

import static com.generator.tables.Students.STUDENTS;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.generator.tables.pojos.Students;
import com.generator.tables.records.StudentsRecord;

import cn.signit.mvc.dao.StudentMapper;

@Repository
public class StudentMapperImpl implements StudentMapper {

    @Autowired
    private DSLContext dsl;
    
    /**
     * 根据id查询学生信息
     * @param id
     * @return 学生对象
     */
    @Override
    public Students getStudent(Integer id) {
        StudentsRecord record = dsl.selectFrom(STUDENTS)
                .where(STUDENTS.ID.eq(id))
                .fetchOne();
        Assert.notNull(record, "请输入有效id");
        if (record != null) {
            return record.into(Students.class);
        }
        return null;
    }
    
    /**
     * 添加学生
     * @param students
     * @return 学生对象
     */
    @Override
    public Students addStudent(Students students) {
        StudentsRecord record = dsl.newRecord(STUDENTS);
        record.from(students);
        int count = record.store();
        if (count > 0) {
            return record.into(Students.class);
        } else {
            return null;
        }
    }
    
    /**
     * 更新学生
     * @param students
     * @return 学生对象
     */
    @Override
    public Students updateStudent(Students students) {
        StudentsRecord record = dsl.newRecord(STUDENTS);
        record.from(students);
        record.changed("id", false);
        int count = record.store();
        if (count == 1) {
            return record.into(Students.class);
        } else {
            return null;
        }
    }
    
    /**
     * 删除学生
     * @param id
     * @return bool类型 
     */
    @Override
    public Boolean deleteStudent(Integer id) {
        int delRows = dsl.deleteFrom(STUDENTS)
                .where(STUDENTS.ID.eq(id))
                .execute();
        if(delRows > 0) {
            return true;
        }else {
            Assert.isTrue(delRows == 0, "通过id删除用户失败");
            return false;
        }
    }
    
    /**
     * 获取所有学生资料
     * @return 学生对象集合
     */
    @Override
    public List<Students> getStudents() {
        Result<StudentsRecord> record = dsl.selectFrom(STUDENTS)
                .fetch();
        if (record.isEmpty()) {
            return null;
        }
        return record.into(Students.class);
    }
}
