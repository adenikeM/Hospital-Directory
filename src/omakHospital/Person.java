package omakHospital;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private Gender gender;

    public Person(String firstName, String lastName, int age, String address, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.gender = gender;
    }

    public Person() {}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public Gender getGender() {return gender;}

    public void setGender(Gender gender) {this.gender = gender;}

   // public String getMessageDetails(){
      //  return firstName + "," + lastName + "," + age + "," + address + "," + gender;
   // }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}

