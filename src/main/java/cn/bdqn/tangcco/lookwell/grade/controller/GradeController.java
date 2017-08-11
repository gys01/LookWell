package cn.bdqn.tangcco.lookwell.grade.controller;

import cn.bdqn.tangcco.lookwell.entity.Grade;
import cn.bdqn.tangcco.lookwell.grade.service.GradeService;
import cn.bdqn.tangcco.lookwell.tools.Message;
import cn.bdqn.tangcco.lookwell.tools.PageUtil;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TYY on 2017/7/25.
 */

@Controller
@RequestMapping(value = "grade")
public class GradeController {

    @Resource
    private GradeService gradeService;

    @RequestMapping(value = "toGradeList", method = RequestMethod.GET)
    public String toGradeList() {
        return "gradeList";
    }

    /**
     * 按班级名模糊查询并分页展示
     * @param page
     * @param rows
     * @param gradeName
     * @return
     */
    @RequestMapping(value = "queryGrade", method = RequestMethod.POST,
        produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String queryGrade(Integer page, Integer rows, String gradeName) {
        PageUtil p = gradeService.queryGradeByName(page, rows, gradeName);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", p.getTotal());
        map.put("rows", p.getObjs());
        String json = JSONArray.toJSONString(map);
        System.out.println(json);
        return json;
    }

    /**
     * 添加班级
     * @param grade
     * @return
     */
    @RequestMapping(value = "addGrade", method = RequestMethod.POST,
        produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String addGrade(Grade grade) {
        Integer count = gradeService.addGrade(grade);
        Message msg = new Message();
        if (count > 0) {
            msg.setMsg("添加成功");
        } else {
            msg.setMsg("添加失败，请联系管理员");
        }
        return JSONArray.toJSONString(msg);
    }

    /**
     * 按id查单个班级
     * @param id
     * @return
     */
    @RequestMapping(value = "queryGradeById", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String queryGradeById(Integer id) {
        Grade grade = gradeService.queryGradeById(id);
        String json = JSONArray.toJSONString(grade);
        System.out.println(json);
        return json;
    }

    /**
     * 修改班级
     * @param grade
     * @return
     */
    @RequestMapping(value = "updateGrade", method = RequestMethod.POST,
        produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String updateGrade(Grade grade) {
        Integer count = gradeService.updateGrade(grade);
        Message msg = new Message();
        if (count > 0) {
            msg.setMsg("修改成功");
        } else {
            msg.setMsg("修改失败，请联系管理员");
        }
        return JSONArray.toJSONString(msg);
    }

    /**
     * 删除单个班级
     * @param id
     * @return
     */
    @RequestMapping(value = "deleteGradeById", method = RequestMethod.POST,
        produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteGradeById(Integer id) {
        Integer count = gradeService.deleteGradeById(id);
        Message msg = new Message();
        if (count > 0) {
            msg.setMsg("删除单个成功");
        } else {
            msg.setMsg("删除单个失败");
        }
        return JSONArray.toJSONString(msg);
    }

    /**
     * 删除多个班级
     * @param gradeIdListStr
     * @return
     */
    @RequestMapping(value = "deleteGradeByIdList", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteGradeByIdList(String gradeIdListStr) {
        //字符串转为数组
        String[] idStrArray = gradeIdListStr.split(",");
        List<Integer> idList = new ArrayList<Integer>();
        for (int i=0;i<idStrArray.length;i++) {
            idList.add(Integer.parseInt(idStrArray[i]));
        }
        Integer count = gradeService.deleteGradeByIdList(idList);
        Message msg = new Message();
        if (count > 0) {
            msg.setMsg("删除多个成功");
        } else {
            msg.setMsg("删除多个失败");
        }
        return JSONArray.toJSONString(msg);
    }

    /**
     * 查询全部班级
     * @return
     */

    @RequestMapping(value = "queryAllGrade", method = RequestMethod.GET,
            produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String queryAllGrade() {
        List<Grade> gradeList = gradeService.queryAllGrade();
        return JSONArray.toJSONString(gradeList);
    }


}

