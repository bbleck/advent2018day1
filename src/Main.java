import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

  static ArrayList<Integer> input = new ArrayList<>();
  static boolean flag = false;

  public static void main(String[] args) {
    Main theMain = new Main();
    try{
      URL url = theMain.getClass().getResource("input.txt");
      File file = new File(url.getPath());
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String tempStr = "";
      while((tempStr=reader.readLine()) != null){
        input.add(Integer.parseInt(tempStr));
      }
      reader.close();
    }catch(IOException e){
      //do nothing
    }
    int freguency = 0;
    for (int i = 0; i < input.size(); i++) {
      freguency+=input.get(i);
    }
    System.out.println(freguency);

    HashSet<Integer> theSubs = new HashSet<>();
    int subtotal = 0;
    int current = 0;
    int last = input.size()-1;
    int frequency = 0;
    theSubs.add(subtotal);
    do{
      frequency += input.get(current);
      if(current < last){
        current++;
      }else{
        current = 0;
      }
      if(!theSubs.add(frequency)){
        System.out.println("\n\n\n\n\n" + frequency);
        flag = true;
      }

    }while(!flag);
  }
}
