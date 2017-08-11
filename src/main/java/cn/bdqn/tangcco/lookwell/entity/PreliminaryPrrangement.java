package cn.bdqn.tangcco.lookwell.entity;

/**
 * Created by 99117 on 2017/8/6.
 */
public class PreliminaryPrrangement {
    private Integer paId;
    private Grade grade;
    private Time time;
    private Teacher teacher;
    private Room room;
    private Chapter chapter;

    @Override
    public String toString() {
        return "PreliminaryPrrangement{" +
                "paId=" + paId +
                ", grade=" + grade +
                ", time=" + time +
                ", teacher=" + teacher +
                ", room=" + room +
                ", chapter=" + chapter +
                '}';
    }

    public Integer getPaId() {
        return paId;
    }

    public void setPaId(Integer paId) {
        this.paId = paId;
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

    public PreliminaryPrrangement() {

    }

    public PreliminaryPrrangement(Integer paId, Grade grade, Time time, Teacher teacher, Room room, Chapter chapter) {

        this.paId = paId;
        this.grade = grade;
        this.time = time;
        this.teacher = teacher;
        this.room = room;
        this.chapter = chapter;
    }
}
