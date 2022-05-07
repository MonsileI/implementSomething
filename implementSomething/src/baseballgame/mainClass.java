package baseballgame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class mainClass {

	public static void main(String[] args) throws Exception {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	makeNumber make = new makeNumber();
	
	String question = make.make();
	
	
	while(true) {
		
	
		
		
		System.out.print("숫자를 입력해주세요  : ");
		
		String answer = br.readLine();
		
		checkAnswer ca = new checkAnswer();

		
			
			while(!ca.check(answer)) {
				
				answer = br.readLine();
			}
		
		
		
		calculator cal = new calculator();
		
		String str = cal.checking(answer, question);
		
		if(str.equals("정답")) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			int check = Integer.parseInt(br.readLine());
			if(check==2) {
				break;
			}else if (check==1){
				question = make.make();
			}
		}else {
			System.out.println(str);
		}
		
	}
	System.out.println();
	System.out.println("게임이 종료되었습니다 :)");
	
	
	}
	
	
	
}
	

class checkAnswer {
	
	public static boolean check(String answer) {
		
		try {
			Integer.parseInt(answer);
			
		} catch (Exception e) {
			System.out.println("숫자를 다시 입력해주세요. (숫자만 입력해주세요 ㅜㅠ");
			return false;
		}
		
		if(answer.length()!=3) {
			System.out.println("숫자를 다시 입력해주세요. (세가지 숫자를 중복 없이 입력해 주셔야해요 ㅜㅜ)");
			return false;
		}
		
		char first = answer.charAt(0);
		char second = answer.charAt(1);
		char third = answer.charAt(2);
		
		if(first==second) return false;
		if(second==third) return false;
		if(third==first) return false;
		
		return true;
		
	}
	
}

class makeNumber{
	
	public static String make() {
		int a = (int)(Math.random()*10000)%10;
		int b = (int)(Math.random()*10000)%10;
		int c = (int)(Math.random()*10000)%10;
		
		while(true) {
			
			if(a==b) {
				while(a==b) {
					a = (int)(Math.random()*10000)%10;
					b = (int)(Math.random()*10000)%10;
				}
			}
			if(b==c) {
				while(b==c) {
					b = (int)(Math.random()*10000)%10;
					c = (int)(Math.random()*10000)%10;
				}
			}
			if(c==a) {
				while(c==a) {
					c = (int)(Math.random()*10000)%10;
					a = (int)(Math.random()*10000)%10;
				}
			}
			
			
			if(a!=b) {
				if(b!=c) {
					if(c!=a) {
						break;
					}
				}
			}
			
		}
		
		
		
		return a+""+b+""+c;
		
		
	}

}


 class calculator {
	
		public static String checking(String answer,String question) {
			
			int ball = 0;
			int strike = 0;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(answer.charAt(j)==question.charAt(i)) {
						if(j==i) {
							strike++;
							continue;
						}
						else {
							ball++;
							continue;
						}
					}
				}
				
			}
			if(strike==3) return "정답";
			else {
				
				if(strike!=0) {
					if(ball!=0) {
						return strike+"스트라이크 "+ball+"볼";
					}else {
						return strike+"스트라이크";
					}
				}else if(ball!=0) return ball+"볼";
				 else return "nothing";				
					
			}
			
		}
	
}
