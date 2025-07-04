class person{
    private int age;
    private String Name;

    public int getAge(){
        return age;
    }
    public void setAge(int a){
        age=a;
    }
    public String getName(){
        return Name;
    }
    public void setName(String n){
        Name=n;
    }
}
public class Human{
    public static void main(String[] args) {
        person p=new person();
        p.setAge(22);
        p.setName("Karan Agarwal");
        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
    }
}
