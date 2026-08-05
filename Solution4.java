import java.util.*;

class MedicalRecord
{
	private String recordId;
	private String disease;
	private String doctorName;
	private String status;

	public MedicalRecord(String recordId,String disease,String doctorName,String status)
	{
		this.recordId = recordId;
		this.disease = disease;
		this.doctorName = doctorName;
		this.status = status;
	}
	
	public String getrecordId()
	{
		return recordId;
	}
	public String getdisease()
	{
		return disease;
	}
	public String getdoctorName()
	{
		return doctorName;
	}
	public String getstatus()
	{
		return status;
	}
}

class Patient extends MedicalRecord
{
	private String patientId;
	private String patientName;
	private String city;
	private String bloodGroup;

	public Patient(String patientId,String patientName,String city,String bloodGroup,String id,String disease,String name,String status)
	{
		super(id,disease,name,status);
		this.patientId = patientId;
		this.patientName = patientName;
		this.city = city;
		this.bloodGroup = bloodGroup;
	}
	
	public String getpatientId()
	{
		return patientId;
	}
	public String getpatientName()
	{
		return patientName;
	}
	public String getcity()
	{
		return city;
	}
	public String getbloodGroup()
	{
		return bloodGroup;
	}
}

class Solution4
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); sc.nextLine();
		Patient[] P = new Patient[num];
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
			P[i] = new Patient(a,b,c,d,e,f,g,h);
		}
		String ct = sc.nextLine();
		Patient[] result = fetchPatientUnderTreatmentByCity(P,ct);
		if(result==null)
		{
			System.out.println("No Patients Found");
		}else{
			for(Patient p : result)
			{
				System.out.println(p.getpatientId());
				System.out.println(p.getpatientName());
				System.out.println(p.getrecordId());
				System.out.println(p.getdisease());
			}
		}
	}

	public static Patient[] fetchPatientUnderTreatmentByCity(Patient[] arr,String city)
	{
		List<Patient> matchList = new ArrayList<>();
		for(Patient p : arr)
		{
			if(p.getcity().equalsIgnoreCase(city) && p.getstatus().equalsIgnoreCase("Under Treatment"))
			{
				matchList.add(p);
			}
		}
		if(matchList.isEmpty())
		{
			return null;
		}
		return matchList.toArray(new Patient[0]);
	}
}
