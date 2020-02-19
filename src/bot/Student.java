package bot;

import java.util.Map;
import java.util.regex.Pattern;

public class Student {
    private int id;
    private String name;
    private String group;
    private String subgroup;
    private Map<String, String> groups = Map.of(
            "��-203" , "���-280208",
            "��-202","���-280207");

    public Student(int id) { this.id = id; }

    boolean isNotAuthorized(){
        for (String value: new String[]{this.name, this.group, this.subgroup}) {
            if (value == null)
                return true;
        }
        return false;
    }

    public String getName() { return  this.name; }

    public String getGroup() { return  this.group; }

    public String getUrFUGroup() { return this.groups.get(this.group); }

    public String getSubgroup() { return this.subgroup; }

    public String setAttr(Attr attr, String value) {
        switch (attr) {
            case Name:
                if (Pattern.matches(".+", value)) {
                    this.name = value;
                    return null;
                }
                else {
                    return "������ �������� �� ��������";
                }
            case Group:
                if (Pattern.matches("[�-��-�]+[-_ ]\\d{3}", value)) {
                    String[] array = value.split("[-_ ]");
                    this.group = array[0].toUpperCase() + "-" +array[1];
                    return null;
                }
                else {
                    return "������� ������ �� ������� ��-203";
                }
            case Subgroup:
                if (Pattern.matches("[12]", value)) {
                    this.subgroup = value;
                    return null;
                }
                else {
                    return "������� 1 ��� 2";
                }
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        if (this.isNotAuthorized()) {
            return "������������ �� �����������";
        }
        return String.format("���: %s\n������: %s\n����� ������: %s",
                this.name, this.group, this.subgroup);
    }
}
