import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Studenttest {
	
	public static int checkno(String no) {
		int size=0;
		
		try {
			size=Integer.parseInt(no);
		}catch(Exception E) {
			System.out.println("Not a valid no :"+E);
			return 0;
		}
		
		if(size<=0) {
			System.out.println("Please enter valid no");
			return size;
		}
		
		return size;
		
		
		
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size=0;
		Scanner sc = new Scanner(System.in);
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> AV=new ArrayList<String>();
		ArrayList<String> ANV=new ArrayList<String>();
		ArrayList<String> BV=new ArrayList<String>();
		ArrayList<String> BNV=new ArrayList<String>();
		
		LinkedHashMap<String, String> Veg = new LinkedHashMap<String,String>();
		LinkedHashMap<String, String> NVeg = new LinkedHashMap<String,String>();
		

		
		boolean flag=true;
		while(flag) {
			
			String count = sc.nextLine();
			String[] cnt = count.split("\\s");
			size=checkno(cnt[1]);
			
			if(size>0) {
				flag=false;
			}
		}
		
				
		int j=0;
		String req;
		while(j<size) {
		
			req = sc.nextLine();
			
			if(req.contains("fin")) {
				break;
			}else if(j==size) {
				System.out.println("Size exceeded");
				break;
			}
				al.add(req);
				j++;
			
		}
		
		String[] sp;
		
		for(int i=0;i<al.size();i++) {
			if(al.get(i).contains("NV")) {
				sp = al.get(i).split("\\s");
				NVeg.put(sp[1], sp[2]);
	
			}else {
				sp = al.get(i).split("\\s");
				Veg.put(sp[1], sp[2]);
	
			}
		}
					
		Set<String> Vkey = Veg.keySet();
		Iterator<String> it1 = Vkey.iterator();
		while(it1.hasNext()) {
			String stu = it1.next();
			if(Veg.get(stu).equalsIgnoreCase("A")) {	
				AV.add(stu);
			}
			else
				BV.add(stu);
			}
		
		Set<String> NKey = NVeg.keySet();
		Iterator<String> it2 = NKey.iterator();
		while(it2.hasNext()) {
			String stu = it2.next();
			if(NVeg.get(stu).equalsIgnoreCase("A")) {
				
				ANV.add(stu);
				
			}
			else
				BNV.add(stu);
			}
		
		System.out.println();
		System.out.println("AV :"+AV);
		System.out.println("BV :"+BV);
		System.out.println("ANV :"+ANV);
		System.out.println("BNV :"+BNV);
	}

}
