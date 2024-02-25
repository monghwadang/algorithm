import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] heap;
	static int heapSize;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		heap = new int[N+1];

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				System.out.println(heapPop());
			} else {
				heapPush(n);
			}
		}

	}

	static void swap(int p, int ch) {
		int tmp = heap[p];
		heap[p] = heap[ch];
		heap[ch] = tmp;
	}

	static void heapPush(int n) {

		heap[++heapSize] = n;

		int ch = heapSize;
		int p = heapSize / 2;

		while (p > 0 && heap[p] < heap[ch]) {
			swap(p, ch);

			ch = p;
			p = ch / 2;
		}

	}

	static int heapPop() {
		
		if(heapSize==0) {
			return 0;
		}

		int popItem = heap[1];

		heap[1] = heap[heapSize--];

		int p = 1;
		int ch = 2 * p;

		if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
			ch = ch + 1;
		}

		while (ch <= heapSize && heap[p] < heap[ch]) {
			swap(p, ch);

			p = ch;
			ch = p * 2;

			if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
				ch = ch + 1;
			}

		}

		return popItem;

	}

}