package tests;

import bot.Attr;
import bot.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    private Student student;
    @Before
    public void setUp() throws Exception {
        student = new Student(0);
    }

    @Test
    public void getName_NULLLINE() {
        assertEquals("������ �������� �� ��������",
                student.setAttr(Attr.Name, ""));
    }

    @Test
    public void getName_NOTNULL() {
        student.setAttr(Attr.Name, "Student");
        assertEquals("Student", student.getName());
    }

    @Test
    public void getName_RUSSIAN() {
        student.setAttr(Attr.Name, "�������");
        assertEquals("�������", student.getName());
    }

    @Test
    public void getGroup() {
        student.setAttr(Attr.Group, "��-203");
        assertEquals("��-203", student.getGroup());
    }

    @Test
    public void getGroup_NULLGROUP() {
        assertEquals("������� ������ �� ������� ��-203",
                student.setAttr(Attr.Group, ""));
    }

    @Test
    public void getGroup_GROUPWITHGROUND() {
        student.setAttr(Attr.Group, "���_404");
        assertEquals("���-404", student.getGroup());
    }

    @Test
    public void getGroup_GROUPWITHWHITESPACE() {
        student.setAttr(Attr.Group, "��� 227");
        assertEquals("���-227", student.getGroup());
    }

    @Test
    public void getGroup_ENGLISH() {
        assertEquals("������� ������ �� ������� ��-203",
                student.setAttr(Attr.Group, "jj-203"));
    }

    @Test
    public void getGroup_LESSNUMBEROFDECIMALS() {
        assertEquals("������� ������ �� ������� ��-203",
                student.setAttr(Attr.Group, "��-00"));
    }

    @Test
    public void getGroup_BIGGERNUMBEROFDECIMALS() {
        assertEquals("������� ������ �� ������� ��-203",
                student.setAttr(Attr.Group, "��-2032"));
    }

    @Test
    public void getSubgroup_1() {
        student.setAttr(Attr.Subgroup, "1");
        assertEquals("1", student.getSubgroup());
    }

    @Test
    public void getSubgroup_2() {
        student.setAttr(Attr.Subgroup, "2");
        assertEquals("2", student.getSubgroup());
    }

    @Test
    public void getSubgroup_0() {
        assertEquals("������� 1 ��� 2", student.setAttr(Attr.Subgroup, "0"));
    }

    @Test
    public void getSubgroup_3() {
        assertEquals("������� 1 ��� 2", student.setAttr(Attr.Subgroup, "3"));
    }

    @Test
    public void getSubgroup_NOTANUMBER() {
        assertEquals("������� 1 ��� 2", student.setAttr(Attr.Subgroup, "h"));
    }

    @Test
    public void testToString() {
        student.setAttr(Attr.Name, "������");
        student.setAttr(Attr.Group, "��-203");
        student.setAttr(Attr.Subgroup, "1");
        assertEquals("���: ������\n������: ��-203\n����� ������: 1", student.toString());
    }

    @Test
    public void  testToString_NOTAUTHORIZED() {
        student.setAttr(Attr.Name, "������");
        student.setAttr(Attr.Group, "��-203");
        assertEquals("������������ �� �����������", student.toString());
    }
}