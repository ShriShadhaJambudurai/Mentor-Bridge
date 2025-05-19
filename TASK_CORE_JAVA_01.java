import java.util.*;
public class TASK_CORE_JAVA_01 {
    static class CreateStudent {
        int ID;
        String name;
        int age;
        String course;

        CreateStudent(int ID, String name, int age, String course) {
            this.ID = ID;
            this.name = name;
            this.age = age;
            this.course = course;
        }

        public int getID() {
            return ID;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getCourse() {
            return course;
        }

        public void setId(int ID) {
            this.ID = ID;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setCourse(String course) {
            this.course = course;
        }


        public String displaystudent() {
            return "ID: " + ID + ", name: " + name + ", age: " + age + ", course: " + course;
        }
    }


    public static void main(String args[]){
        Scanner obj = new Scanner(System.in);
        ArrayList<CreateStudent> studentdata = new ArrayList<>();
        while(true) {
            System.out.println("1.Add Student\n2.View studentdetails\n3.View by ID\n4.Update details\n5.Delete\n6.Exit");
            System.out.print("Enter your choice: ");
            int choice = obj.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter ID: ");
                    int ID = obj.nextInt();
                    System.out.print("Enter name: ");
                    obj.nextLine();
                    String name = obj.nextLine();
                    System.out.print("Enter age: ");
                    int age = obj.nextInt();
                    System.out.print("Enter course: ");
                    obj.nextLine();
                    String course = obj.nextLine();
                    studentdata.add(new CreateStudent(ID, name, age, course));
                    System.out.println("Student added");
                    break;

                case 2:
                    if(studentdata.isEmpty()){
                        System.out.println("No student found");
                    }
                    else {
                        for (CreateStudent s : studentdata) {
                            System.out.println(s.displaystudent());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    ID = obj.nextInt();

                    boolean found = false;
                    for (CreateStudent s : studentdata) {
                        if (ID == s.getID()) {
                            System.out.println(s.displaystudent());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No data found");
                    }

                    break;
                case 4:
                    System.out.print("Enter the Student ID to be updated: ");
                    ID = obj.nextInt();
                    boolean found1 = false;
                    for(CreateStudent s : studentdata) {
                        if (ID == s.getID()) {
                            System.out.print("Enter name: ");
                            obj.nextLine();
                            name = obj.nextLine();
                            System.out.print("Enter age: ");
                            age = obj.nextInt();
                            obj.nextLine();
                            System.out.print("Enter course: ");
                            course = obj.nextLine();
                            s.setName(name);
                            s.setAge(age);
                            s.setCourse(course);
                            System.out.println("Student details updated");
                            found1 = true;
                            break;

                        }

                        }
                    if (!found1) {
                        System.out.println("No data found");
                    }

                    break;
                case 5:
                    System.out.print("Enter ID to be deleted: ");
                    ID = obj.nextInt();
                    boolean removed = studentdata.removeIf(s -> s.ID == ID);
                    if(removed){
                        System.out.println("The data has been removed");
                    }
                    else{
                        System.out.println("Give the correct ID");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");


            }
        }
    }

}
