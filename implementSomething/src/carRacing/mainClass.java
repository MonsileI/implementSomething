package carRacing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class mainClass {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
		
		String carNum = br.readLine();
		
		System.out.println(carNum);
		
		System.out.println("시도할 회수는 몇회인가요?");
		
		int count = Integer.parseInt(br.readLine());
	
		System.out.println(count);
		
		String [] temp = carNum.split(",");
		
		HashMap<String,String> map = new HashMap<>();
		
		for(String str : temp) map.put(str, "");
		
		for(int i=0;i<count;i++) {
		
			for(String key:map.keySet()) {
				map.put(key, map.getOrDefault(key, "")+turn());
				System.out.println(key + ":" + map.get(key));
			}
		
			System.out.println();
		
		}
	
		ArrayList<String>winner = new ArrayList<>();
		
		int max = 0;
		
		for(String key:map.keySet()) max= Math.max(max, map.get(key).length());
		
		for(String key:map.keySet()) {
			if(max==map.get(key).length()) winner.add(key);
		}
		
		System.out.println("최종 우승자:" + winner);
	}

	static String turn() {
		
		int a = (int)(Math.random()*10000)%10;
		
		
		return a>4? "-" : "";
		
	}
}
