import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    
    static void bubbleSort(String[] arr) {
    	
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].length() > arr[j + 1].length()) {
                    // 길이가 짧은 문자열이 앞에 오도록 swap
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        Set<String> dict = new TreeSet<>();
        
        for (int i = 0; i < N; i++) {
            dict.add(sc.next());
        } // 중복 없이 오름차순으로 넣어주기

        String[] dictSort = new String[dict.size()];
        int idx = 0;
        for (String c : dict) {
            dictSort[idx++] = c;
        }

        // 버블 정렬을 사용하여 문자열의 길이로 정렬
        bubbleSort(dictSort);

        for (String word : dictSort) {
            System.out.println(word);
        }           
    }
}