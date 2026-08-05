import java.util.*;

class Warranty
{
	private String warrantyId;
	private String warrantyType;
	private String expiryDate;
	private String status;

	public Warranty(String warrantyId,String warrantyType,String expiryDate,String status)
	{
		this.warrantyId = warrantyId;
		this.warrantyType = warrantyType;
		this.expiryDate = expiryDate;
		this.status = status;
	}
	
	public String getwarrantyId()
	{
		return warrantyId;
	}
	public String getwarrantyType()
	{
		return warrantyType;
	}
	public String getexpiryDate()
	{
		return expiryDate;
	}
	public String getstatus()
	{
		return status;
	}
}

class Product extends Warranty
{
	private String productId;
	private String productName;
	private String category;
	private String brand;

	public Product(String productId,String productName,String category,String brand,String id,String type,String date,String status)
	{
		super(id,type,date,status);
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.brand = brand;
	}
	
	public String getproductId()
	{
		return productId;
	}
	public String getproductName()
	{
		return productName;
	}
	public String getcategory()
	{
		return category;
	}
	public String getbrand()
	{
		return brand;
	}
}

class Solution3
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); sc.nextLine();
		Product[] P = new Product[num];
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
			P[i] = new Product(a,b,c,d,e,f,g,h);
		}
		String br = sc.nextLine();
		Product[] result = fetchExpiredWarrantyProductsByBrand(P,br);
		if(result==null)
		{
			System.out.println("No Expired Warranty Products Found");
		}else{
			for(Product p : result)
			{
				System.out.println(p.getproductId());
				System.out.println(p.getproductName());
				System.out.println(p.getwarrantyId());
				System.out.println(p.getwarrantyType());
			}
		}
	}

	public static Product[] fetchExpiredWarrantyProductsByBrand(Product[] arr,String brand)
	{
		List<Product> matchList = new ArrayList<>();
		for(Product p : arr)
		{
			if(p.getbrand().equalsIgnoreCase(brand) && p.getstatus().equalsIgnoreCase("Expired"))
			{
				matchList.add(p);
			}
		}
		if(matchList.isEmpty())
		{
			return null;
		}
		return matchList.toArray(new Product[0]);
	}
}
