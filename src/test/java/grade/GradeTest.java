package grade;

import base.TestBase;
import cn.bdqn.tangcco.lookwell.entity.Grade;
import cn.bdqn.tangcco.lookwell.grade.service.GradeService;
import cn.bdqn.tangcco.lookwell.tools.PageUtil;
import org.junit.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TYY on 2017/7/25.
 */
public class GradeTest extends TestBase {

    @Inject
    private GradeService gradeService;

    //按班级名模糊查询并分页展示
    @Test
    public void testQueryGrade() {
        PageUtil pageUtil = gradeService.queryGradeByName(1, 5,"班");
        System.out.println("记录数："+pageUtil.getTotal());
        List<Grade> gradeList = pageUtil.getObjs();
        for (int i=0;i<gradeList.size();i++) {
            System.out.println(gradeList.get(i));
        }
    }

    //添加班级
    @Test
    public void testAddGrade() {
        Grade grade = new Grade();
        grade.setGradeName("添加班级");
        grade.setGradeDesc("添加描述");
        grade.setGradeStatus("添加状态");
        Integer count = gradeService.addGrade(grade);
        System.out.println(count);
        System.out.println(grade.toString());
    }

    //按id查单个班级
    @Test
    public void testQueryGradeById() {
        Grade grade = gradeService.queryGradeById(1);
        System.out.println(grade.toString());
    }

    //修改班级
    @Test
    public void testUpdateGrade() {
        Grade grade = new Grade();
        grade.setGradeId(2);
        grade.setGradeName("修改班级2");
        grade.setGradeDesc("");
//        grade.setGradeStatus("修改状态");
        Integer count = gradeService.updateGrade(grade);
        System.out.println(count);
        System.out.println(grade.toString());
    }

    //删除单个班级
    @Test
    public void testDeleteGradeById() {
        Integer count = gradeService.deleteGradeById(3);
        System.out.println(count);
    }

    //删除多个班级
    @Test
    public void testDeleteGradeByIdList() {
        List<Integer> idList = new ArrayList<Integer>();
        idList.add(4);
        idList.add(5);
        Integer count = gradeService.deleteGradeByIdList(idList);
        System.out.println(count);
    }

    //查询全部班级
    @Test
    public void testQueryAllGrade() {
        List<Grade> gradeList = gradeService.queryAllGrade();
        for (int i = 0; i < gradeList.size(); i++) {
            System.out.println(gradeList.get(i));
        }
    }

    //添加班级名称唯一策略
    @Test
    public void testAddGradeName(){
        Integer projectId=1;
        String projectName="产品名称";
        String gradeName=gradeService.addGradeName(projectId, projectName);
        System.out.println("班级名称："+gradeName);
    }

}
