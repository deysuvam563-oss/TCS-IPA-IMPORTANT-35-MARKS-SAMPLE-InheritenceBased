import java.util.*;

class Certification
{
	String certificationId;
	String certificationName;
	String issuedBy;
	String status;

	public Certification(String certificationId,String certificationName,String issuedBy,String status)
	{
		this.certificationId=certificationId;
		this.certificationName=certificationName;
		this.issuedBy=issuedBy;
		this.status=status;
	}

	public String getcertificationId()
	{
		return certificationId;
	}
	public String getcertificationName()
	{
		return certificationName;
	}
	public String getissuedBy()
	{
		return issuedBy;
	}
	public String getstatus()
	{
		return status;
	}
}

class Employee extends Certification
{
	String employeeId;
	String employeeName;
	String department;
	String designation;

	public Employee(String employeeId,String employeeName,String department,String designation,String id,String Name,String issue,String st)
	{
		super(id,Name,issue,st);
		this.employeeId=employeeId;
		this.employeeName=employeeName;
		this.department=department;
		this.designation=designation;	
	}

	public String getemployeeId()
	{
		return employeeId;
	}
	public String getemployeeName()
	{
		return employeeName;
	}
	public String getdepartment()
	{
		return department;
	}
	public String getdesignation()
	{
		return designation;
	}
}

class Solution
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int num = sc.nextInt(); sc.nextLine();
		Employee[] EMP = new Employee[num];
		for(int i=0;i<num;i++)
		{
			String a = sc.nextLine();
			String b = sc.nextLine();
			String c = sc.nextLine();
			String d = sc.nextLine();
			String e = sc.nextLine();
			String f = sc.nextLine();
			String g = sc.nextLine();
			String h = sc.nextLine();
			EMP[i] = new Employee(a,b,c,d,e,f,g,h);
		}
		String d = sc.nextLine();
		Employee[] result = fetchEmployeesWithExpiredCertificationByDepartment(EMP,d);
		if(result==null)
		{
			System.out.println("No Employees Found");
		}else{
			for(Employee ep : result)
			{
				System.out.println(ep.getemployeeId());
				System.out.println(ep.getemployeeName());
				System.out.println(ep.getcertificationId());
				System.out.println(ep.getcertificationName());
			}
		}		
	}

	public static Employee[] fetchEmployeesWithExpiredCertificationByDepartment(Employee[] arr,String dept)
	{
		List<Employee> matchList = new ArrayList<>();
		for(Employee e : arr)
		{
			if(e.getdepartment().equalsIgnoreCase(dept) && e.getstatus().equalsIgnoreCase("Expired"))
			{
				matchList.add(e);
			}
		}
		if(matchList.isEmpty())
		{
			return null;
		}
		return matchList.toArray(new Employee[0]);	
	}
}
