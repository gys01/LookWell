package cn.bdqn.tangcco.lookwell.entity;

/**
 * 实体类：班级名称自动生成
 *
 */
public class GradeName {
    private Integer granamId;       //班级名称id

    private Integer maxNum;         //最大编号

    private Project project;           //外键：产品id

    public Integer getGranamId() {
        return granamId;
    }

    public void setGranamId(Integer granamId) {
        this.granamId = granamId;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public GradeName() {
    }

    @Override
    public String toString() {
        return "GradeName{" +
                "granamId=" + granamId +
                ", maxNum=" + maxNum +
                ", project=" + project +
                '}';
    }
}