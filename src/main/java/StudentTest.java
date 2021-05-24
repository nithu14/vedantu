import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Studenttest {
	static LinkedList<String> NA = new LinkedList<String>();
	static LinkedHashMap<String, String> Veg = new LinkedHashMap<String,String>();
	static LinkedHashMap<String, String> NVeg = new LinkedHashMap<String,String>();
	
	public static int checkno(String no) {
		// to check for valid int entered
		int size=0;
		
		try {
			size=Integer.parseInt(no);
		}catch(Exception E) {
			System.out.println("Not a valid no :"+E);
			System.out.println("Please enter valid no");
			return 0;
		}
		
		if(size<=0) {
			System.out.println("Please enter valid no");
			return size;
		}	
		return size;
	}
	
	public static void addstudent(Scanner sc,int size) {
		int j=0;
		String req;
		ArrayList<String> al = new ArrayList<String>();
		new ArrayList<String>();
		String[] sp = null;
		
		while(j<size) {
			
			req = sc.nextLine();
			
			if(req.contains("fin")) {
				break;
			}else if(j==size) {
				System.out.println("Size exceeded");
				break;
			}
			
			// check for id length
			String[] split = req.split(" ");
			
			if(split[1].length()>4) {
				System.out.println("not a valid id, please enter again");
			}
			else if(al.contains(split[1])) {
				System.out.println("duplicate Student, please enter again");
			}
			else
				al.add(req);
				
			j++;
			
		}	
		
		// Separate students based on their food preference 
				for(int i=0;i<al.size();i++) {
					if(al.get(i).contains("NV")) {
						sp = al.get(i).split("\\s");
						NVeg.put(sp[1], sp[2]);
			
					}else if(al.get(i).contains("V")) {
						sp = al.get(i).split("\\s");
						Veg.put(sp[1], sp[2]);
			
					}else {
						sp = al.get(i).split("\\s");
						NA.add(sp[1]);
					}
				}
	}

	public static Object[] Separator(LinkedHashMap<String, String> hm) {
//		ArrayList<String>obj =new ArrayList<String>();
		Object[] obj=new Object[2];
		ArrayList<String> AV=new ArrayList<String>();
		ArrayList<String> BV=new ArrayList<String>();
		
		Set<String> key = hm.keySet();
		Iterator<String> it1 = key.iterator();
		while(it1.hasNext()) {
			String stu = it1.next();
			if(hm.get(stu).equalsIgnoreCase("A")) {	
				AV.add(stu);
			}
			else if(hm.get(stu).equalsIgnoreCase("B"))
				BV.add(stu);
			else
				NA.add(stu);
			}
		
		obj[0]=AV;
		obj[1]=BV;
		
		return obj;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size=0;
		Scanner sc = new Scanner(System.in);
		Object[] sep=new Object[2];
		// check untill valid int is entered	
		boolean flag=true;
		while(flag) {	
			String count = sc.nextLine();
			String[] cnt = count.split("\\s");
			size=checkno(cnt[1]);
			
			if(size>0) {
				System.out.println("Please enter "+size+" Student records");
				flag=false;
			}
		}
		
	// add students for size given			
		addstudent(sc,size);
		
	// Separate students based on class and print
		
		sep=Separator(Veg);	
		System.out.println("AV :"+sep[0].toString());
		System.out.println("BV :"+sep[1].toString());

		sep=Separator(NVeg);	
		System.out.println("ANV :"+sep[0].toString());
		System.out.println("BNV :"+sep[1].toString());
		System.out.println("NA :"+NA);
		
	}

}
