import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size=0;
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> al = new ArrayList<String>();
		
		HashMap<String, String> Veg = new HashMap<String,String>();
		LinkedHashSet<String> VS = new LinkedHashSet<String>();
		HashMap<String, String> NVeg = new HashMap<String,String>();
		LinkedHashSet<String> NVS = new LinkedHashSet<String>();
		String req = sc.next();
		String[] cnt = req.split("_");
		
		size=Integer.parseInt(cnt[1]);
		
		int j=0;
		while(j<size) {
		
			req = sc.next();
			
			if(req.contains("fin")) {
				break;
			}else if(j==size) {
				System.out.println("Size exceeded");
				break;
			}
				al.add(req);
				j++;
			
		}
	//		req="reg 1 B V";
		String[] sp;
		
		for(int i=0;i<al.size();i++) {
			if(al.get(i).contains("NV")) {
				sp = al.get(i).split("_");
				NVeg.put(sp[1], sp[2]);
				NVS.add(sp[1]);
			}else {
				sp = al.get(i).split("_");
				Veg.put(sp[1], sp[2]);
				VS.add(sp[1]);
			}
		}
				
		ArrayList<String> AV=new ArrayList<String>();
		ArrayList<String> ANV=new ArrayList<String>();
		ArrayList<String> BV=new ArrayList<String>();
		ArrayList<String> BNV=new ArrayList<String>();
		
		Iterator<String> it1 = VS.iterator();
		while(it1.hasNext()) {
			String stu = it1.next();
			if(Veg.get(stu).equalsIgnoreCase("A")) {
				
				AV.add(stu);
				
			}
			else
				BV.add(stu);
			}
		
		Iterator<String> it2 = NVS.iterator();
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
