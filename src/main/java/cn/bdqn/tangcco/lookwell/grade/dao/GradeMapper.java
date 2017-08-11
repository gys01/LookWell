package cn.bdqn.tangcco.lookwell.grade.dao;

import cn.bdqn.tangcco.lookwell.entity.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by TYY on 2017/7/25.
 */
public interface GradeMapper {
    //按班级名查总记录数
    Integer queryCountGradeByName(@Param("gradeName") String gradeName);

    //按班级名模糊查询并分页展示
    List<Grade> queryGradeByName(@Param("start") Integer start, @Param("rows") Integer rows, @Param("gradeName") String gradeName);

    //添加班级
    Integer addGrade(Grade grade);

    //按id查单个班级
    Grade queryGradeById(Integer id);

    //修改班级
    Integer updateGrade(Grade grade);

    //删除单个班级
    Integer deleteGradeById(Integer id);

    //删除多个班级
    Integer deleteGradeByIdList(List<Integer> idList);

    //查询全部班级
    List<Grade> queryAllGrade();

}
