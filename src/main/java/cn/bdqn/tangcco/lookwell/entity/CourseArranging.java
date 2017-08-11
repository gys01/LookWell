package cn.bdqn.tangcco.lookwell.entity;

import java.util.Date;

/**
 * Created by HP on 2017/8/11.
 */
public class CourseArranging {
    private Integer arrangingId;
    private Grade grade;
    private Time time;
    private Teacher teacher;
    private Room room;
    private Chapter chapter;
    private Date arrangingDate;


    @Override
    public String toString() {
        return "CourseArranging{" +
                "arrangingId=" + arrangingId +
                ", grade=" + grade +
                ", time=" + time +
                ", teacher=" + teacher +
                ", room=" + room +
                ", chapter=" + chapter +
                ", arrangingDate=" + arrangingDate +
                '}';
    }

    public Integer getArrangingId() {
        return arrangingId;
    }

    public void setArrangingId(Integer arrangingId) {
        this.arrangingId = arrangingId;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Date getArrangingDate() {
        return arrangingDate;
    }

    public void setArrangingDate(Date arrangingDate) {
        this.arrangingDate = arrangingDate;
    }

    public CourseArranging(Integer arrangingId, Grade grade, Time time, Teacher teacher, Room room, Chapter chapter, Date arrangingDate) {

        this.arrangingId = arrangingId;
        this.grade = grade;
        this.time = time;
        this.teacher = teacher;
        this.room = room;
        this.chapter = chapter;
        this.arrangingDate = arrangingDate;
    }

    public CourseArranging() {

    }
}
