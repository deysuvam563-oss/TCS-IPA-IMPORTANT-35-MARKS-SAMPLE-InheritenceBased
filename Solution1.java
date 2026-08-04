import java.util.*;

class Scholarship
{
    private String scholarshipId;
    private String scholarshipType;
    private double amount;
    private String status;
    
    public Scholarship(String scholarshipId,String scholarshipType,double amount,String status)
    {
        this.scholarshipId=scholarshipId;
        this.scholarshipType=scholarshipType;
        this.amount=amount;
        this.status=status;
    }
    
    public String getscholarshipId()
    {
        return scholarshipId;
    }
    public String getscholarshipType()
    {
        return scholarshipType;
    }
    public double getamount()
    {
        return amount;
    }
    public String getstatus()
    {
        return status;
    }
}

class Student extends Scholarship
{
    private String studentId;
    private String studentName;
    private String course;
    private String city;
    
    public Student(String studentId,String studentName,String course,String city,String id,String type,double amt,String st)
    {
        super(id,type,amt,st);
        this.studentId=studentId;
        this.studentName=studentName;
        this.course=course;
        this.city=city;
    }
    
    public String getstudentId()
    {
        return studentId;
    }
    public String getstudentName()
    {
        return studentName;
    }
    public String getcourse()
    {
        return course;
    }
    public String getcity()
    {
        return city;
    }
}

class Solution1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); sc.nextLine();
        Student[] S = new Student[num];
        for(int i=0;i<num;i++)
        {
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            String d = sc.nextLine();
            String e = sc.nextLine();
            String f = sc.nextLine();
            double g = sc.nextDouble(); sc.nextLine();
            String h = sc.nextLine();
            S[i] = new Student(a,b,c,d,e,f,g,h);
        }
        String ct = sc.nextLine();
        Student[] result = fetchScholarshipPendingStudentsByCity(S,ct);
        if(result==null)
        {
            System.out.println("No scholarship Pending Students Found");
        }else{
            for(Student d : result)
            {
                System.out.println(d.getstudentId());
                System.out.println(d.getstudentName());
                System.out.println(d.getscholarshipId());
                System.out.println(d.getscholarshipType());
            }
        }
    }
    
    public static Student[] fetchScholarshipPendingStudentsByCity(Student[] arr,String city)
    {
        List<Student> matchList = new ArrayList<>();
        for(Student s : arr)
        {
            if(s.getcity().equalsIgnoreCase(city) && s.getstatus().equalsIgnoreCase("Pending"))
            {
                matchList.add(s);
            }
        }
        if(matchList.isEmpty())
        {
            return null;
        }
        return matchList.toArray(new Student[0]);
    }
}
