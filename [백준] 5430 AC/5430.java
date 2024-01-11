import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            
            String sAry = br.readLine();
            sAry = sAry.substring(1, sAry.length()-1);
            
            List<String> list = new ArrayList<>(Arrays.asList(sAry.split(",")));
            boolean isFront = true, isError = false;
            
            for (int i = 0; i < p.length(); i++) {                              
                char c = p.charAt(i);
                if (c == 'R') {
                    if (isFront) isFront = false;
                    else isFront = true;
                } else {
                    if (list.size() == 0 || list.get(0).equals("")) {
                        isError = true;
                        break;
                    } 
                                      
                    if (isFront) 
                        list.remove(0);
                    else 
                        list.remove(list.size() - 1);
                }             
            }

            if (!isError) {
                bw.write("[");
                if (isFront && list.size() != 0) {
                    for (int i = 0; i < list.size() - 1; i++) 
                        bw.write(list.get(i) + ",");                    
                    bw.write(list.get(list.size() - 1));
                } else if (list.size() != 0) {
                    for (int i = list.size() - 1; i > 0; i--) 
                        bw.write(list.get(i) + ",");
                    bw.write(list.get(0));
                }
                bw.write("]\n");
            } else bw.write("error\n");
        }
        bw.flush();
        bw.close();
    }
}
