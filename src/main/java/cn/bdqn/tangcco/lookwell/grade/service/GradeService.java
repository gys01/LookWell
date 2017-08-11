package cn.bdqn.tangcco.lookwell.grade.service;

import cn.bdqn.tangcco.lookwell.entity.Grade;
import cn.bdqn.tangcco.lookwell.tools.PageUtil;

import java.util.List;

/**
 * Created by TYY on 2017/7/25.
 */
public interface GradeService {
    //按班级名模糊查询并分页展示
    PageUtil queryGradeByName(Integer page, Integer rows, String gradeName);

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

    //添加班级名称唯一策略
    String addGradeName(Integer projectId, String projectName);

}
