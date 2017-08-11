package cn.bdqn.tangcco.lookwell.grade.service;

import cn.bdqn.tangcco.lookwell.entity.Grade;
import cn.bdqn.tangcco.lookwell.grade.dao.GradeMapper;
import cn.bdqn.tangcco.lookwell.gradename.dao.GradeNameMapper;
import cn.bdqn.tangcco.lookwell.tools.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by TYY on 2017/7/4.
 */

@Service
public class GradeServiceImpl implements GradeService {

    @Resource
    private GradeMapper gradeMapper;

    //按班级名模糊查询并分页展示
    @Override
    public PageUtil queryGradeByName(Integer page, Integer rows, String gradeName) {
        PageUtil pageUtil = new PageUtil(page, rows);
        //1.计算总记录数
        Integer count = gradeMapper.queryCountGradeByName(gradeName);
        //2.计算开始位置start
        Integer start = pageUtil.getStart();
        //3.查列表信息
        List<Grade> gradeList = gradeMapper.queryGradeByName(start, rows, gradeName);
        //4.进行分页
        pageUtil.setTotal(count);
        pageUtil.setObjs(gradeList);
        //返回对象
        return pageUtil;
    }

    //添加班级
    @Override
    public Integer addGrade(Grade grade) {
        Date now=new Date();
        grade.setCreateTime(now);
        grade.setUpdateTime(now);
        //1.生成班级名称
//        Project project = new Project();    //
//        project.setProjectId(1);            //
        Integer projectId = grade.getProject().getProjectId();
        String projectName = grade.getProject().getProjectName();
        String gradeName=addGradeName(projectId, projectName);
        //2.班级名称赋值
        grade.setGradeName(gradeName);
        return gradeMapper.addGrade(grade);
    }

    //按id查单个班级
    @Override
    public Grade queryGradeById(Integer id) {
        return gradeMapper.queryGradeById(id);
    }

    //修改班级
    @Override
    public Integer updateGrade(Grade grade) {
        Date now=new Date();
        grade.setUpdateTime(now);
        return gradeMapper.updateGrade(grade);
    }

    //删除单个班级
    @Override
    public Integer deleteGradeById(Integer id) {
        return gradeMapper.deleteGradeById(id);
    }

    //删除多个班级
    @Override
    public Integer deleteGradeByIdList(List<Integer> idList) {
        Integer count = gradeMapper.deleteGradeByIdList(idList);
        return count;
    }

    //查询全部班级
    @Override
    public List<Grade> queryAllGrade() {
        return gradeMapper.queryAllGrade();
    }



    //添加班级名称唯一策略
    @Resource
    private GradeNameMapper gradeNameMapper;

    /**
     * 添加班级名称唯一策略
     * 产品名称 + n个0 + 自增的num
     * 班级名称指定为10位
     * @param projectId
     * @param projectName
     * @return
     */
    @Override
    public String addGradeName(Integer projectId, String projectName) {
        //1. max_num自加1
        Integer n = gradeNameMapper.updateNumByProjectId(projectId);
        //2. 查班级的max_num
        Integer max_num = gradeNameMapper.queryNumByProjectId(projectId);
        //3. 拼接班级名称 projectName + '00...'+ max_num
        String str = projectName + max_num;
        int length = 10 - str.length();
        for(int i=0;i<length;i++){
            projectName = projectName + 0;      //字符串连接
        }
        String gradeName = projectName + max_num;
        return gradeName;
    }

}
