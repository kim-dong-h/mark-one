package com.dhkim.markone.codingTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LevelOne {
  @Test
	void contextLoads() {

    // int [] queue1  = {1,2,3,4,5};
    // int [] queue2 = {4,3,2,5,3};
    // System.out.println(solution(queue1, queue2));;
    test();
	}


  public void test(){

  }

  public int solution(int [] queue1, int [] queue2) {

    int result = 0;

    int sum = 0;


    for(int i =0; i< queue1.length; i++){
      sum += queue1[i];
    }
    for(int i=0; i< queue2.length; i++){
      sum += queue2[i];
    }

    if((sum % 2) != 0){
      return -1;
    }
    
    


    return result;
    
  }

}
