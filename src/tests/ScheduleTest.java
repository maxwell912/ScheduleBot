package tests;

import bot.Attr;
import bot.DayOfWeek;
import bot.Schedule;
import bot.Student;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScheduleTest {
    private static String mondaySchedule ="09:00 - 10:30\n1.��������-��������������� ����������������(���������)\n  \n511���������, 4\n\n10:40 - 12:10\n��������-��������������� ����������������(���������)\n  \n526���������, 4\n\n";

    @Test
    public void getDayOfWeekSchedule_0() {
        Student student = new Student(1);
        student.setAttr(Attr.Group, "��-203");
        Schedule schedule = new Schedule();
        assertEquals(mondaySchedule,
                schedule.getDayOfWeekSchedule(student, DayOfWeek.monday));
    }
}