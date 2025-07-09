public class Student {
    private Long id;
    private String name;
    private Integer marks;

    public Student() {
    }

    public Student(Long id, String name, Integer marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }
}